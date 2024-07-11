package parabank.interfaces;

public interface IRequestLoanPageActions extends IUserBaseActions {
    void EnterAmount(String text);
    void EnterDownPayment(String text);
    void SetFromAccountCombobox(String account);
    void ClickApplyButton();
    String GetErrorRequestMessage();
    String GetStatusMessage();
    String GetApprovedMessage();
    String GetDeniedMessage();
    String GetAccountNumber();
    void ClickOnAccountNumber();
    void ClearAmount();
    void ClearDownPayment();
}
