package parabank.interfaces;

public interface ITransferFundsPageActions extends IBaseActions {
    void EnterAmount(String text);
    String GetTransferFoundsErrorMessage();
    String GetTransferFoundsSuccessfulMessage();
    void ClickTransferButton();
    void SetFromAccountComboBox(String account);
    void SetToAccountComboBox(String account);
}
