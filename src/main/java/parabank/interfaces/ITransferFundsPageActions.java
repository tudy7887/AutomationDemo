package parabank.interfaces;

public interface ITransferFundsPageActions extends IUserBaseActions {
    void EnterAmount(String text);
    String GetTransferFoundsErrorMessage();
    void ClickTransferButton();
    void SetFromAccountComboBox(String account);
    void SetToAccountComboBox(String account);
}
