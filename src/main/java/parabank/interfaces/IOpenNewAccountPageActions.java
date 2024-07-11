package parabank.interfaces;

public interface IOpenNewAccountPageActions extends IUserBaseActions {
    void SetTypeAccountCombobox(String type);
    void SetFromAccountCombobox(String account);
    String GetNewAccount();
    void ClickCreateNewAccount();
    void ClickNewAccount();
}
