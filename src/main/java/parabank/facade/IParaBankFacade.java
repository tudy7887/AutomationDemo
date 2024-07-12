package parabank.facade;

import parabank.dto.*;

import java.util.List;

public interface IParaBankFacade {
    void GoToLoginPage();
    // Login Page
    void ClearLoginData();
    void EnterLoginData(LoginDTO user);
    void ClickLoginButton();
    void ClickRegisterLink();
    String GetLoginErrorMessage();

    // Register Page
    void ClearRegisterData();
    void EnterRegisterData(RegisterDTO user);
    void ClickRegister();

    // Welcome Page
    void GetWelcomeNewUserMessage();

    // Menu Actions
    void ClickOpenNewAccountMenu();
    void ClickAccountOverviewMenu();
    void ClickTransferFundsMenu();
    void ClickBillPayMenu();
    void ClickFindTransactionsMenu();
    void ClickUpdateContractInfoMenu();
    void ClickRequestLoanMenu();
    void ClickLogOutMenu();

    // Open New Account Page
    void FillNewAccountData(String fromAccount, String accountType);
    void ClickCreateNewAccount();
    String GetNewAccountNumber();
    void ClickNewAccount();

    // Account Overview Page
    List<AccountOverviewDTO> GetAccounts();
    String GetTotal();
    void ClickAccountInAccountOverview(int index);
    AccountDetailDTO GetAccountsDetails();
    void ClickTransactionOverview(int index);

    // Transfer Funds Page
    void FillTransferData(String fromAccount, String toAccount, String amount);
    void ClickTransferButton();
    String GetTransferFoundsErrorMessage();
    String GetTransferFoundsSuccessfulMessage();

    // Bill and Pay Page
    void ClearBillAndPayData();
    void EnterBillAndPayData(BillAndPayDTO payment);
    void ClickSendPaymentButton();
    String GetBillCompletedMessage();
    String GetNameErrorMessage();
    String GetAddressErrorMessage();
    String GetCityErrorMessage();
    String GetStateErrorMessage();
    String GetZipCodeErrorMessage();
    String GetPhoneErrorMessage();
    String GetAccountErrorMessage();
    String GetAccountVerificationErrorMessage();
    String GetAmountErrorMessage();

    // Find Transaction Page
    void SetSearchTransactionAccount(String account);
    void EnterSearchTransactionId(String id);
    void EnterSearchTransactionDate(String date);
    void EnterSearchTransactionDatesBetween(String from, String to);
    void EnterSearchTransactionAmount(String amount);
    String GetFindByIdErrorErrorMessage();
    String GetFindByDateErrorErrorMessage();
    String GetFindByDateRangeErrorErrorMessage();
    String GetFindByAmountErrorErrorMessage();
    void ClickFindByIdButton();
    void ClickFindByDateButton();
    void ClickFindByDateRangeButton();
    void ClickFindByAmountButton();
    void ClearSearchTransactionId();
    void ClearSearchTransactionDate();
    void ClearSearchTransactionDatesBetween();
    void ClearSearchTransactionAmount();
    List<TransactionOverwiewDTO> GetTransactionSearchResult();
    void ClickTransactionSearch(int index);
    TransactionDetailDTO GetTransactionDetail();

    // Update Contract Info Page
    void ClearUpdateInfoData();
    void EnterRegisterData(UpdateInfoDTO user);
    void ClickUpdateProfileButton();
    String GetUpdateSuccessfulMessage();

    // Request Loan Page
    void ClearRequestLoanData();
    void EnterRequestLoanData(String fromAccount, String amount, String downPayment);
    void ClickRequestLoanApplyButton();
    String GetRequestedLoanErrorRequestMessage();
    String GetRequestedLoanStatusMessage();
    String GetRequestedLoanApprovedMessage();
    String GetRequestedLoanDeniedMessage();
    String GetRequestedLoanAccountNumber();
    void ClickRequestedLoanAccountNumber();
}
