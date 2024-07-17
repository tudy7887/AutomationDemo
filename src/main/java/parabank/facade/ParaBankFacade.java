package parabank.facade;

import org.openqa.selenium.WebDriver;
import parabank.actions.*;
import parabank.dto.*;
import parabank.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class ParaBankFacade implements IParaBankFacade {
    private WebDriver driver;
    protected IAccountsDetailPageActions iAccountsDetailPageActions;
    protected ITransactionDetailsPageActions iTransactionDetailsPageActions;
    protected IAccountsOverviewPageActions iAccountsOverviewPageActions;
    protected IBillPayPageActions iBillPayPageActions;
    protected IFindTransactionsPageActions iFindTransactionsPageActions;
    protected ILoginPageActions iLoginPageActions;
    protected IOpenNewAccountPageActions iOpenNewAccountPageActions;
    protected IRegisterPageActions iRegisterPageActions;
    protected IRequestLoanPageActions iRequestLoanPageActions;
    protected ITransferFundsPageActions iTransferFundsPageActions;
    protected IUpdateContractInfoPageActions iUpdateContractInfoPageActions;
    protected IWelcomePageActions iWelcomePageActions;
    protected IUserMenuActions iUserMenuActions;

    public ParaBankFacade(WebDriver driver){
        this.driver = driver;
        iAccountsDetailPageActions = new AccountsDetailPageActions(driver);
        iTransactionDetailsPageActions = new TransactionDetailsPageActions(driver);
        iAccountsOverviewPageActions = new AccountsOverviewPageActions(driver);
        iBillPayPageActions = new BillPayPageActions(driver);
        iFindTransactionsPageActions = new FindTransactionsPageActions(driver);
        iLoginPageActions = new LoginPageActions(driver);
        iOpenNewAccountPageActions = new OpenNewAccountPageActions(driver);
        iRegisterPageActions = new RegisterPageActions(driver);
        iRequestLoanPageActions = new RequestLoanPageActions(driver);
        iTransferFundsPageActions = new TransferFundsPageActions(driver);
        iUpdateContractInfoPageActions = new UpdateContractInfoPageActions(driver);
        iWelcomePageActions = new WelcomePageActions(driver);
        iUserMenuActions = new UserMenuActions(driver);
    }

    public String GetCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public void GoToLoginPage() {
        iLoginPageActions.GotoPage();
    }
    public String GetAccountsOverview() {
        iAccountsOverviewPageActions.WaitUntilLoaded();
        return iAccountsOverviewPageActions.GetAccountOverviewTitle();
    }
    public String GetLoginPage() {
        iLoginPageActions.WaitUntilLoaded();
        return iLoginPageActions.GetCustomerLoginTitle();
    }

    // Login Page
    public void ClearLoginData(){
        iLoginPageActions.ClearUsername();
        iLoginPageActions.ClearPassword();
    }
    public void EnterLoginData(LoginDTO user){
        iLoginPageActions.EnterUsername(user.Username);
        iLoginPageActions.EnterPassword(user.Password);
    }
    public void ClickLoginButton(){
        iLoginPageActions.ClickLoginButton();
        iAccountsOverviewPageActions.WaitUntilLoaded();
    }
    public void ClickLoginButtonFail(){
        iLoginPageActions.ClickLoginButton();
    }
    public void ClickRegisterLink(){
        iLoginPageActions.ClickRegisterLink();
        iRegisterPageActions.WaitUntilLoaded();
    }
    public String GetLoginErrorMessage(){
        return iLoginPageActions.GetLoginErrorMessage();
    }

    // Register Page
    public void ClearRegisterData(){
        iRegisterPageActions.ClearFirstName();
        iRegisterPageActions.ClearLastName();
        iRegisterPageActions.ClearAddress();
        iRegisterPageActions.ClearCity();
        iRegisterPageActions.ClearState();
        iRegisterPageActions.ClearZipCode();
        iRegisterPageActions.ClearPhone();
        iRegisterPageActions.ClearSSn();
        iRegisterPageActions.ClearUsername();
        iRegisterPageActions.ClearPassword();
        iRegisterPageActions.ClearPasswordConfirmation();
    }
    public void EnterRegisterData(RegisterDTO user){
        iRegisterPageActions.EnterFirstName(user.FirstName);
        iRegisterPageActions.EnterLastName(user.LastName);
        iRegisterPageActions.EnterAddress(user.Address);
        iRegisterPageActions.EnterCity(user.City);
        iRegisterPageActions.EnterState(user.State);
        iRegisterPageActions.EnterZipCode(user.ZipCode);
        iRegisterPageActions.EnterPhone(user.Phone);
        iRegisterPageActions.EnterSsn(user.Ssn);
        iRegisterPageActions.EnterUsername(user.Username);
        iRegisterPageActions.EnterPassword(user.Password);
        iRegisterPageActions.EnterPasswordConfirmation(user.Password);
    }
    public void ClickRegister(){
        iRegisterPageActions.ClickRegisterButtonButton();
        iWelcomePageActions.WaitUntilDataIsLoaded();
    }

    // Welcome Page
    public String GetWelcomeNewUserMessage(){
        return iWelcomePageActions.GetWelcomeNewUserMessage();
    }

    // Menu Actions
    public void ClickOpenNewAccountMenu(){
        iUserMenuActions.ClickOpenNewAccountMenu();
        iOpenNewAccountPageActions.WaitUntilDataIsLoaded();
    }
    public void ClickAccountOverviewMenu(){
        iUserMenuActions.ClickAccountOverviewMenu();
        iAccountsOverviewPageActions.WaitUntilDataIsLoaded();
    }
    public void ClickTransferFundsMenu(){
        iUserMenuActions.ClickTransferFundsMenu();
        iTransferFundsPageActions.WaitUntilDataIsLoaded();
    }
    public void ClickBillPayMenu(){
        iUserMenuActions.ClickBillPayMenu();
        iBillPayPageActions.WaitUntilDataIsLoaded();
    }
    public void ClickFindTransactionsMenu(){
        iUserMenuActions.ClickFindTransactionsMenu();
        iFindTransactionsPageActions.WaitUntilDataIsLoaded();
    }
    public void ClickUpdateContractInfoMenu(){
        iUserMenuActions.ClickUpdateContractInfoMenu();
        iUpdateContractInfoPageActions.WaitUntilDataIsLoaded();
    }
    public void ClickRequestLoanMenu(){
        iUserMenuActions.ClickRequestLoanMenu();
        iRequestLoanPageActions.WaitUntilDataIsLoaded();
    }
    public void ClickLogOutMenu(){
        iUserMenuActions.ClickLogOutMenu();
        iLoginPageActions.WaitUntilLoaded();
    }

    // Open New Account Page
    public void FillNewAccountData(String fromAccount, String accountType){
        iOpenNewAccountPageActions.SetFromAccountCombobox(fromAccount);
        iOpenNewAccountPageActions.SetTypeAccountCombobox(accountType);
    }
    public void ClickCreateNewAccount(){
        iOpenNewAccountPageActions.ClickCreateNewAccount();
    }
    public String GetNewAccountNumber(){
        return iOpenNewAccountPageActions.GetNewAccount();
    }
    public void ClickNewAccount(){
        iOpenNewAccountPageActions.ClickNewAccount();
        iAccountsDetailPageActions.WaitUntilDataIsLoaded();
    }

    // Account Overview Page
    public List<AccountOverviewDTO> GetAccounts(){
        iAccountsOverviewPageActions.WaitUntilDataIsLoaded();
        var result = new ArrayList<AccountOverviewDTO>();
        var numbers = iAccountsOverviewPageActions.GetAccountList();
        var balances = iAccountsOverviewPageActions.GetBalanceList();
        var availables = iAccountsOverviewPageActions.GetAvailableList();

        for(var i = 0; i<numbers.size(); i++){
            var account = new AccountOverviewDTO();
            account.Index = i;
            account.Number = numbers.get(i);
            account.Balance = balances.get(i);
            account.Available = availables.get(i);
            result.add(account);
        }

        return result;
    }
    public String GetTotal(){
        iAccountsOverviewPageActions.WaitUntilDataIsLoaded();
        return iAccountsOverviewPageActions.GetTotal();
    }
    public void ClickAccountInAccountOverview(int index){
        iAccountsOverviewPageActions.ClickAccountList(index);
        iAccountsDetailPageActions.ChooseAccount(String.valueOf(index));
        iAccountsDetailPageActions.WaitUntilDataIsLoaded();
    }
    public AccountDetailDTO GetAccountsDetails(){
        iAccountsDetailPageActions.WaitUntilDataIsLoaded();
        var result = new AccountDetailDTO();
        var transactionsOverview = new ArrayList<TransactionOverwiewDTO>();
        var dates = iAccountsDetailPageActions.GetTransactionDatesList();
        var transactions = iAccountsDetailPageActions.GetTransactionTransactionList();
        var debits = iAccountsDetailPageActions.GetTransactionDebitList();
        var credits = iAccountsDetailPageActions.GetTransactionCreditList();

        for(var i = 0; i<dates.size(); i++){
            var transaction = new TransactionOverwiewDTO();
            transaction.Index = i;
            transaction.Date = dates.get(i);
            transaction.Transaction = transactions.get(i);
            transaction.Debit = debits.get(i);
            transaction.Credit = credits.get(i);
            transactionsOverview.add(transaction);
        }

        result.Number = iAccountsDetailPageActions.GetNumber();
        result.Balance = iAccountsDetailPageActions.GetBalance();
        result.Available = iAccountsDetailPageActions.GetAvailable();
        result.Type = iAccountsDetailPageActions.GetType();
        result.Transactions = transactionsOverview;
        return result;
    }
    public void ClickTransactionOverview(int index){
        iAccountsDetailPageActions.ClickTransactionTransactionList(index);
        iTransactionDetailsPageActions.ChooseTransaction(String.valueOf(index));
        iTransactionDetailsPageActions.WaitUntilDataIsLoaded();
    }
    // Transfer Funds Page
    
    public void FillTransferData(String fromAccount, String toAccount, String amount){
        iTransferFundsPageActions.SetFromAccountComboBox(fromAccount);
        iTransferFundsPageActions.SetToAccountComboBox(toAccount);
        iTransferFundsPageActions.EnterAmount(amount);
    }
    public void ClickTransferButton(){
        iTransferFundsPageActions.ClickTransferButton();
    }
    public String GetTransferFoundsErrorMessage(){
        return iTransferFundsPageActions.GetTransferFoundsErrorMessage();
    }
    public String GetTransferFoundsSuccessfulMessage(){
        return iTransferFundsPageActions.GetTransferFoundsSuccessfulMessage();
    }

    // Bill and Pay Page
    public void ClearBillAndPayData(){
        iBillPayPageActions.ClearAccount();
        iBillPayPageActions.ClearName();
        iBillPayPageActions.ClearAddress();
        iBillPayPageActions.ClearCity();
        iBillPayPageActions.ClearState();
        iBillPayPageActions.ClearZipCode();
        iBillPayPageActions.ClearPhone();
        iBillPayPageActions.ClearAccount();
        iBillPayPageActions.ClearAccountVerification();
        iBillPayPageActions.ClearAmount();
    }
    public void EnterBillAndPayData(BillAndPayDTO payment){
        iBillPayPageActions.SetFromAccountCombobox(payment.FromAccount);
        iBillPayPageActions.EnterName(payment.Name);
        iBillPayPageActions.EnterAddress(payment.Address);
        iBillPayPageActions.EnterCity(payment.City);
        iBillPayPageActions.EnterState(payment.State);
        iBillPayPageActions.EnterZipCode(payment.ZipCode);
        iBillPayPageActions.EnterPhone(payment.Phone);
        iBillPayPageActions.EnterAccount(payment.Account);
        iBillPayPageActions.EnterAccountVerification(payment.Account);
        iBillPayPageActions.EnterAmount(payment.Amount);
        iBillPayPageActions.EnterPhone(payment.Phone);
    }
    public void ClickSendPaymentButton(){
        iBillPayPageActions.ClickSendPaymentButton();
    }
    public String GetBillCompletedMessage(){
        return iBillPayPageActions.GetBillCompletedMessage();
    }
    public String GetNameErrorMessage(){
        return iBillPayPageActions.GetNameErrorMessage();
    }
    public String GetAddressErrorMessage(){
        return iBillPayPageActions.GetAddressErrorMessage();
    }
    public String GetCityErrorMessage(){
        return iBillPayPageActions.GetCityErrorMessage();
    }
    public String GetStateErrorMessage(){
        return iBillPayPageActions.GetStateErrorMessage();
    }
    public String GetZipCodeErrorMessage(){
        return iBillPayPageActions.GetZipCodeErrorMessage();
    }
    public String GetPhoneErrorMessage(){
        return iBillPayPageActions.GetPhoneErrorMessage();
    }
    public String GetAccountErrorMessage(){
        return iBillPayPageActions.GetAccountErrorMessage();
    }
    public String GetAccountVerificationErrorMessage(){
        return iBillPayPageActions.GetAccountVerificationErrorMessage();
    }
    public String GetAmountErrorMessage(){
        return iBillPayPageActions.GetAmountErrorMessage();
    }

    // Find Transaction Page
    public void SetSearchTransactionAccount(String account){
        iFindTransactionsPageActions.SetFromAccountCombobox(account);
    }
    public void EnterSearchTransactionId(String id){
        iFindTransactionsPageActions.EnterSearchTransactionId(id);
    }
    public void EnterSearchTransactionDate(String date){
        iFindTransactionsPageActions.EnterSearchTransactionDate(date);
    }
    public void EnterSearchTransactionDatesBetween(String from, String to){
        iFindTransactionsPageActions.EnterSearchTransactionFromDate(from);
        iFindTransactionsPageActions.EnterSearchTransactionToDate(to);
    }
    public void EnterSearchTransactionAmount(String amount){
        iFindTransactionsPageActions.EnterSearchTransactionAmount(amount);
    }
    public String GetFindByIdErrorErrorMessage(){
        return iFindTransactionsPageActions.GetFindByIdErrorErrorMessage();
    }
    public String GetFindByDateErrorErrorMessage(){
        return iFindTransactionsPageActions.GetFindByDateErrorErrorMessage();
    }
    public String GetFindByDateRangeErrorErrorMessage(){
        return iFindTransactionsPageActions.GetFindByDateRangeErrorErrorMessage();
    }
    public String GetFindByAmountErrorErrorMessage(){
        return iFindTransactionsPageActions.GetFindByAmountErrorErrorMessage();
    }
    public void ClickFindByIdButton(){
        iFindTransactionsPageActions.ClickFindByIdButton();
        iFindTransactionsPageActions.WaitUntilDataIsLoaded();
    }
    public void ClickFindByDateButton(){
        iFindTransactionsPageActions.ClickFindByDateButton();
        iFindTransactionsPageActions.WaitUntilDataIsLoaded();
    }
    public void ClickFindByDateRangeButton(){
        iFindTransactionsPageActions.ClickFindByDateRangeButton();
        iFindTransactionsPageActions.WaitUntilDataIsLoaded();
    }
    public void ClickFindByAmountButton(){
        iFindTransactionsPageActions.ClickFindByAmountButton();
        iFindTransactionsPageActions.WaitUntilDataIsLoaded();
    }
    public void ClearSearchTransactionId(){
        iFindTransactionsPageActions.ClearSearchTransactionId();
    }
    public void ClearSearchTransactionDate(){
        iFindTransactionsPageActions.ClearSearchTransactionDate();
    }
    public void ClearSearchTransactionDatesBetween(){
        iFindTransactionsPageActions.ClearSearchTransactionFromDate();
        iFindTransactionsPageActions.ClearSearchTransactionToDate();
    }
    public void ClearSearchTransactionAmount(){
        iFindTransactionsPageActions.ClearSearchTransactionAmount();
    }
    public List<TransactionOverwiewDTO> GetTransactionSearchResult(){
        var result = new ArrayList<TransactionOverwiewDTO>();
        var dates = iFindTransactionsPageActions.GetResultDateList();
        var transactions = iFindTransactionsPageActions.GetResultTransactionList();
        var debits = iFindTransactionsPageActions.GetResultDebitList();
        var credits = iFindTransactionsPageActions.GetResultCreditList();

        for(var i = 0; i<dates.size(); i++){
            var transaction = new TransactionOverwiewDTO();
            transaction.Index = i;
            transaction.Date = dates.get(i);
            transaction.Transaction = transactions.get(i);
            transaction.Debit = debits.get(i);
            transaction.Credit = credits.get(i);
            result.add(transaction);
        }

        return result;
    }
    public void ClickTransactionSearch(int index){
        iFindTransactionsPageActions.ClickResultTransactionList(index);
        iTransactionDetailsPageActions.ChooseTransaction(String.valueOf(index));
        iTransactionDetailsPageActions.WaitUntilLoaded();
        iTransactionDetailsPageActions.WaitUntilDataIsLoaded();
    }
    public TransactionDetailDTO GetTransactionDetail(){
        var result = new TransactionDetailDTO();
        result.Id = iTransactionDetailsPageActions.GetTransactionId();
        result.Date = iTransactionDetailsPageActions.GetTransactionDate();
        result.Amount = iTransactionDetailsPageActions.GetTransactionAmount();
        result.Type = iTransactionDetailsPageActions.GetTransactionType();
        return result;
    }

    // Update Contract Info Page
    public void ClearUpdateInfoData(){
        iUpdateContractInfoPageActions.ClearFirstName();
        iUpdateContractInfoPageActions.ClearLastName();
        iUpdateContractInfoPageActions.ClearAddress();
        iUpdateContractInfoPageActions.ClearCity();
        iUpdateContractInfoPageActions.ClearState();
        iUpdateContractInfoPageActions.ClearZipCode();
        iUpdateContractInfoPageActions.ClearPhone();
    }
    public void EnterUpdatedInfoData(UpdateInfoDTO user){
        iUpdateContractInfoPageActions.EnterFirstName(user.FirstName);
        iUpdateContractInfoPageActions.EnterLastName(user.LastName);
        iUpdateContractInfoPageActions.EnterAddress(user.Address);
        iUpdateContractInfoPageActions.EnterCity(user.City);
        iUpdateContractInfoPageActions.EnterState(user.State);
        iUpdateContractInfoPageActions.EnterZipCode(user.ZipCode);
        iUpdateContractInfoPageActions.EnterPhone(user.Phone);
    }
    public void ClickUpdateProfileButton(){
        iUpdateContractInfoPageActions.ClickUpdateProfileButton();
    }
    public String GetUpdateSuccessfulMessage(){
        return iUpdateContractInfoPageActions.GetUpdateSuccessfulMessage();
    }
    public UpdateInfoDTO GetUserInfo(){
        iUpdateContractInfoPageActions.WaitUntilDataIsLoaded();
        var user = new UpdateInfoDTO();
        user.FirstName = iUpdateContractInfoPageActions.GetFirstName();
        user.LastName = iUpdateContractInfoPageActions.GetLastName();
        user.Address = iUpdateContractInfoPageActions.GetAddress();
        user.State = iUpdateContractInfoPageActions.GetState();
        user.City = iUpdateContractInfoPageActions.GetCity();
        user.ZipCode = iUpdateContractInfoPageActions.GetZipCode();
        user.Phone = iUpdateContractInfoPageActions.GetPhone();
        return user;
    }

    // Request Loan Page
    public void ClearRequestLoanData(){
        iRequestLoanPageActions.ClearAmount();
        iRequestLoanPageActions.ClearDownPayment();
    }
    public void EnterRequestLoanData(String fromAccount, String amount, String downPayment){
        iRequestLoanPageActions.SetFromAccountCombobox(fromAccount);
        iRequestLoanPageActions.EnterAmount(amount);
        iRequestLoanPageActions.EnterDownPayment(downPayment);
    }
    public void ClickRequestLoanApplyButton(){
        iRequestLoanPageActions.ClickApplyButton();
    }
    public String GetRequestedLoanErrorRequestMessage(){
        return iRequestLoanPageActions.GetErrorRequestMessage();
    }
    public String GetRequestedLoanStatusMessage(){
        return iRequestLoanPageActions.GetStatusMessage();
    }
    public String GetRequestedLoanApprovedMessage(){
        return iRequestLoanPageActions.GetApprovedMessage();
    }
    public String GetRequestedLoanDeniedMessage(){
        return iRequestLoanPageActions.GetDeniedMessage();
    }
    public String GetRequestedLoanAccountNumber(){
        return iRequestLoanPageActions.GetAccountNumber();
    }
    public void ClickRequestedLoanAccountNumber(){
        iRequestLoanPageActions.ClickOnAccountNumber();
    }

}
