package parabank.interfaces;

public interface IBillPayPageActions extends IBaseActions {
    void SetFromAccountCombobox(String account);
    void EnterName(String text);
    void EnterAddress(String text);
    void EnterState(String text);
    void EnterCity(String text);
    void EnterZipCode(String text);
    void EnterAccount(String text);
    void EnterAccountVerification(String text);
    void EnterPhone(String text);
    void EnterAmount(String text);
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
    void ClearName();
    void ClearAddress();
    void ClearState();
    void ClearCity();
    void ClearZipCode();
    void ClearAccount();
    void ClearAccountVerification();
    void ClearPhone();
    void ClearAmount();
    void WaitUntilDataIsLoaded();
}
