package testng.parabank;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends LoginTest{
    private String checking, savings, startCash;
    private String wrongAccountNumberMessage, wrongAccountTypeMessage, wrongAccountBalanceMessage,
            wrongAccountAvailableMessage;

    @BeforeSuite(alwaysRun = true)
    public void Setup(){
        super.Setup();
        InitializeProperties();
    }

    @Test(dependsOnMethods = "LoginSuccessful", groups = "newaccount")
    public void OenNewCheckingAccount() {
        InuitTest("Oen New Checking Account");
        iParaBankFacade.ClickAccountOverviewMenu();
        var mainAccountNumber = iParaBankFacade.GetAccounts().get(0).Number;
        AddScreenshot("Accounts Overview", "Existing Accounts Number");
        iParaBankFacade.ClickOpenNewAccountMenu();
        iParaBankFacade.FillNewAccountData(mainAccountNumber, checking);
        AddScreenshot("Create New Account", "Fill New Account Data");
        iParaBankFacade.ClickCreateNewAccount();
        var newAccountNumber = iParaBankFacade.GetNewAccountNumber();
        AddScreenshot("New Checking Account", "New Account Number");
        iParaBankFacade.ClickNewAccount();
        var details = iParaBankFacade.GetAccountsDetails();
        AddScreenshot("New Checking Account Details", "New Account Details");
        SoftAssertEqual(details.Number, newAccountNumber, wrongAccountNumberMessage);
        SoftAssertEqual(details.Type, checking, wrongAccountTypeMessage);
        SoftAssertEqual(details.Balance, startCash, wrongAccountBalanceMessage);
        SoftAssertEqual(details.Available, startCash, wrongAccountAvailableMessage);
    }

    @Test(dependsOnMethods = "LoginSuccessful", groups = "newaccount")
    public void OenNewSavingAccount() {
        InuitTest("Oen New Saving Account");
        iParaBankFacade.ClickAccountOverviewMenu();
        var mainAccountNumber = iParaBankFacade.GetAccounts().get(0).Number;
        AddScreenshot("Accounts Overview", "Existing Accounts Number");
        iParaBankFacade.ClickOpenNewAccountMenu();
        iParaBankFacade.FillNewAccountData(mainAccountNumber, savings);
        AddScreenshot("Create New Account", "Fill New Account Data");
        iParaBankFacade.ClickCreateNewAccount();
        var newAccountNumber = iParaBankFacade.GetNewAccountNumber();
        AddScreenshot("New Checking Account", "New Account Number");
        iParaBankFacade.ClickNewAccount();
        var details = iParaBankFacade.GetAccountsDetails();
        AddScreenshot("New Checking Account Details", "New Account Details");
        SoftAssertEqual(details.Number, newAccountNumber, wrongAccountNumberMessage);
        SoftAssertEqual(details.Type, savings, wrongAccountTypeMessage);
        SoftAssertEqual(details.Balance, startCash, wrongAccountTypeMessage);
        SoftAssertEqual(details.Available, startCash, wrongAccountTypeMessage);
    }

    private void InitializeProperties(){
        checking = configLoader.GetProperties("checking");
        savings = configLoader.GetProperties("savings");
        startCash = configLoader.GetProperties("startCash");

        wrongAccountNumberMessage = configLoader.GetProperties("wrongAccountNumberMessage");
        wrongAccountTypeMessage = configLoader.GetProperties("wrongAccountTypeMessage");
        wrongAccountBalanceMessage = configLoader.GetProperties("wrongAccountBalanceMessage");
        wrongAccountAvailableMessage = configLoader.GetProperties("wrongAccountAvailableMessage");
    }
}
