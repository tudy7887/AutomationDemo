package parabank.interfaces;

public interface ILoginPageActions extends IBaseActions {
    void EnterUsername(String text);
    void EnterPassword(String text);
    String GetLoginErrorMessage();
    void ClickLoginButton();
    void ClickRegisterLink();
    void ClearUsername();
    void ClearPassword();
}
