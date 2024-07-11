package parabank.interfaces;

public interface IRegisterPageActions extends IBaseActions {
    void EnterFirstName(String text);
    void EnterLastName(String text);
    void EnterAddress(String text);
    void EnterState(String text);
    void EnterCity(String text);
    void EnterZipCode(String text);
    void EnterSsn(String text);
    void EnterPhone(String text);
    void EnterUsername(String text);
    void EnterPassword(String text);
    void EnterPasswordConfirmation(String text);
    void ClickRegisterButtonButton();
    void ClearFirstName();
    void ClearLastName();
    void ClearAddress();
    void ClearState();
    void ClearCity();
    void ClearZipCode();
    void ClearSSn();
    void ClearPhone();
    void ClearUsername();
    void ClearPassword();
    void ClearPasswordConfirmation();
}
