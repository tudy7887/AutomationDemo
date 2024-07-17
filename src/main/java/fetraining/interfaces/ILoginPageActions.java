package fetraining.interfaces;

public interface ILoginPageActions extends IBaseActions{
    void SetMail(String text);
    void SetPassword(String text);
    void ClickLogin();
    String GetErrorMessage();
    void ClearMail();
    void ClearPassword();
}
