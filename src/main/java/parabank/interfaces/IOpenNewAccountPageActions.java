package parabank.interfaces;

public interface IOpenNewAccountPageActions extends IBaseActions {
    void SetTypeAccountCombobox(String type);
    void SetFromAccountCombobox(String account);
    String GetNewAccount();
    void ClickCreateNewAccount();
    void ClickNewAccount();
}
