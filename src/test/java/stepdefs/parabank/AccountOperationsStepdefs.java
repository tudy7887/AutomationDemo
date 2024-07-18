package stepdefs.parabank;

import basetest.BaseTest;

import org.testng.annotations.BeforeSuite;
import io.cucumber.java8.En;
import parabank.dto.LoginDTO;
import parabank.facade.IParaBankFacade;
import parabank.facade.ParaBankFacade;
import util.ConfigLoader;

public class AccountOperationsStepdefs extends BaseTest implements En {
    protected IParaBankFacade iParaBankFacade;
    protected String paraBankPropertyFilePath = "src/test/resources/properties/ParaBank.properties";
    private String accountOverviewTitle, checking, loginFailMessage, wrongAccountMessage, wrongAccountNumberMessage,
    wrongTransferSuccessfulMessage, wrongTransactionDebitMessage, wrongTransactionCreditMessage;
    private LoginDTO user2;
    private String from, to;
    private int nrOfAccounts;

    @BeforeSuite(alwaysRun = true)
    public void Setup(){
        super.Setup();
        configLoader = new ConfigLoader(paraBankPropertyFilePath);
        iParaBankFacade = new ParaBankFacade(driver);
        InitializeProperties();
    }

    public AccountOperationsStepdefs() {
        Before(()->{
            Setup();
            InuitTest("Account Operation Scenario");
        });

        After(()->{
            Logout();
            Teardown();
        });
        Given("^I'm a Para Bank user with N accounts; main account on the first position$", () -> {
            AddDetails("Given: I'm a Para Bank user with N accounts; main account on the first position");
            Login();
            iParaBankFacade.ClickAccountOverviewMenu();
            from = iParaBankFacade.GetAccounts().get(0).Number;
            nrOfAccounts = iParaBankFacade.GetAccounts().size();
            AddScreenshot("Accounts Overview", "Main Account On First Position");
        });
        When("^I go to create a new account page$", () -> {
            AddDetails("When: I go to create a new account page");
            iParaBankFacade.ClickOpenNewAccountMenu();
            AddScreenshot("Create New Account Menu", "Create New Account Menu");
        });
        And("^Fill the data$", () -> {
            AddDetails("And: Fill the data");
            iParaBankFacade.FillNewAccountData(from, checking);
            AddScreenshot("Create New Account", "Fill New Account Data");
        });
        And("^Click on Create New Account$", () -> {
            AddDetails("And: Click on Create New Account");
            iParaBankFacade.ClickCreateNewAccount();
        });
        Then("^I should see the new created account$", () -> {
            AddDetails("Then: I should see the new created account");
            to = iParaBankFacade.GetNewAccountNumber();
            AddScreenshot("New Account", "New Account");
        });
        And("^Now I should have one more account$", () -> {
            AddDetails("And: Now I should have one more account");
            iParaBankFacade.ClickAccountOverviewMenu();
            HardAssertEqual(iParaBankFacade.GetAccounts().size(), nrOfAccounts + 1, wrongAccountNumberMessage );
        });
        And("^Last account should be the newly created one$", () -> {
            AddDetails("And: Last account should be the newly created one");
            HardAssertEqual(iParaBankFacade.GetAccounts().get(nrOfAccounts).Number, to, wrongAccountMessage);
        });
        Given("^I'm a Para Bank user with at least 2 accounts; I wanna transfer between first 2 accounts$", () -> {
            AddDetails("Given: I'm a Para Bank user with at least 2 accounts; I wanna transfer between first 2 accounts");
            Login();
            iParaBankFacade.ClickAccountOverviewMenu();
            CreateNewAccountIfLessThanTwoAccounts();
            from = iParaBankFacade.GetAccounts().get(0).Number;
            to = iParaBankFacade.GetAccounts().get(1).Number;
            AddScreenshot("Accounts Overview", "At Least 2 Accounts");
        });
        When("^I go Transfer funds$", () -> {
            AddDetails("When: I go Transfer funds");
            iParaBankFacade.ClickTransferFundsMenu();
        });
        And("Insert {string} to Amount, chose first account as From and chose second account as To", (String amount) -> {
            AddDetails(String.format("And: Insert %s to Amount, chose first account as From and chose second account as To", amount));
            iParaBankFacade.FillTransferData(from, to, amount);
            AddScreenshot("Transfer Funds", "Transfer Funds Menu");
        });
        And("^Click on Transfer$", () -> {
            AddDetails("And: Click on Transfer");
            iParaBankFacade.ClickTransferButton();
        });
        Then("I should see a confirmation message of the {string}$ transaction", (String amount) -> {
            AddDetails(String.format("Then: I should see a confirmation message of the %s$ transaction", amount));
            var actual = iParaBankFacade.GetTransferFoundsSuccessfulMessage();
            var expected = GetTransactionSuccessfulMessage(from, to, amount);
            HardAssertEqual(actual, expected, wrongTransferSuccessfulMessage);
        });
        And("Last transaction on first account is {string} Debit", (String amount) -> {
            AddDetails(String.format("And: Last transaction on first account is %s Debit", amount));
            iParaBankFacade.ClickAccountOverviewMenu();
            iParaBankFacade.ClickAccountInAccountOverview(0);
            var details = iParaBankFacade.GetAccountsDetails();
            SoftAssertEqual(details.Number, from, wrongAccountMessage);
            var transaction =  details.Transactions.get(details.Transactions.size() - 1);
            SoftAssertEqual(transaction.Debit, GetAmountInDollars(amount),wrongTransactionDebitMessage);
            SoftAssertEqual(transaction.Credit, "",wrongTransactionCreditMessage);
        });
        And("Last transaction on second account is {string} Credit", (String amount) -> {
            AddDetails(String.format("And: Last transaction on second account is %s Credit", amount));
            iParaBankFacade.ClickAccountOverviewMenu();
            iParaBankFacade.ClickAccountInAccountOverview(1);
            var details = iParaBankFacade.GetAccountsDetails();
            SoftAssertEqual(details.Number, to, wrongAccountMessage);
            var transaction =  details.Transactions.get(details.Transactions.size() - 1);
            SoftAssertEqual(transaction.Credit, GetAmountInDollars(amount),wrongTransactionCreditMessage);
            SoftAssertEqual(transaction.Debit, "",wrongTransactionDebitMessage);
        });
    }

    @Override protected String GetReportName() {
        return "ParaBankAccountOperationsCucumber.html";
    }

    protected void Login(){
        iParaBankFacade.GoToLoginPage();
        iParaBankFacade.ClearLoginData();
        iParaBankFacade.EnterLoginData(user2);
        iParaBankFacade.ClickLoginButton();
        HardAssertEqual(iParaBankFacade.GetAccountsOverview(), accountOverviewTitle, loginFailMessage);
    }

    protected void Logout() {
        iParaBankFacade.ClickLogOutMenu();
    }

    private void CreateNewAccountIfLessThanTwoAccounts(){
        nrOfAccounts = iParaBankFacade.GetAccounts().size();
        if(nrOfAccounts < 2){
            from = iParaBankFacade.GetAccounts().get(0).Number;
            iParaBankFacade.ClickOpenNewAccountMenu();
            iParaBankFacade.FillNewAccountData(from, checking);
            iParaBankFacade.ClickCreateNewAccount();
            iParaBankFacade.ClickAccountOverviewMenu();
        }
    }

    private String GetTransactionSuccessfulMessage(String fromAccount, String toAccount, String amount){
        return String.format("$%s.00 has been transferred from account #%s to account #%s.", amount, fromAccount, toAccount);
    }

    private String GetAmountInDollars(String amount){
        return String.format("$%s.00", amount);
    }

    private void InitializeProperties(){
        checking = configLoader.GetProperties("checking");
        accountOverviewTitle = configLoader.GetProperties("accountOverviewTitle");
        loginFailMessage = configLoader.GetProperties("loginFailMessage");
        wrongAccountMessage = configLoader.GetProperties("wrongAccountMessage");
        wrongAccountNumberMessage = configLoader.GetProperties("wrongAccountNumberMessage");
        wrongTransferSuccessfulMessage = configLoader.GetProperties("wrongTransferSuccessfulMessage");
        wrongTransactionCreditMessage = configLoader.GetProperties("wrongTransactionCreditMessage");
        wrongTransactionDebitMessage = configLoader.GetProperties("wrongTransactionDebitMessage");

        user2 = new LoginDTO();
        user2.Username = configLoader.GetProperties("user2");
        user2.Password = configLoader.GetProperties("password2");

    }
}
