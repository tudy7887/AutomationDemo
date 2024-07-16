package parabank.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import parabank.elements.BillPayPageElements;
import parabank.interfaces.IBillPayPageActions;

public class BillPayPageActions extends BaseActions implements IBillPayPageActions {
    BillPayPageElements elements;

    public BillPayPageActions(WebDriver driver) {
        super(driver);
        elements = new BillPayPageElements(driver);
        SetBaseElements(elements);
    }

    public void SetFromAccountCombobox(String account){
        new Select(elements.GetFromAccountBillPaymentCombobox()).selectByVisibleText(account);
    }

    public void EnterName(String text){
        elements.GetPlayeeName().sendKeys(text);
    }
    public void EnterAddress(String text){
        elements.GetPlayeeAddress().sendKeys(text);
    }
    public void EnterState(String text){
        elements.GetPlayeeState().sendKeys(text);
    }
    public void EnterCity(String text){
        elements.GetPlayeeCity().sendKeys(text);
    }
    public void EnterZipCode(String text){
        elements.GetPlayeeZip().sendKeys(text);
    }
    public void EnterAccount(String text){
        elements.GetPlayeeAccount().sendKeys(text);
    }
    public void EnterAccountVerification(String text){
        elements.GetPlayeeVerifyAccount().sendKeys(text);
    }
    public void EnterPhone(String text){
        elements.GetPlayeePhone().sendKeys(text);
    }
    public void EnterAmount(String text){
        elements.GetPlayeeAmount().sendKeys(text);
    }

    public void ClickSendPaymentButton(){
        elements.GetSendPaymentButton().click();
    }
    public String GetBillCompletedMessage(){
        elements.WaitUntilPayCompletedLoaded();
        return elements.GetBillPayCompleted().getText();
    }

    public String GetNameErrorMessage(){
        return elements.GetPlayeeNameError().getText();
    }
    public String GetAddressErrorMessage(){
        return elements.GetPlayeeAddressError().getText();
    }
    public String GetCityErrorMessage(){
        return elements.GetPlayeeCityError().getText();
    }
    public String GetStateErrorMessage(){
        return elements.GetPlayeeStateError().getText();
    }
    public String GetZipCodeErrorMessage(){
        return elements.GetPlayeeZipError().getText();
    }
    public String GetPhoneErrorMessage(){
        return elements.GetPlayeePhoneError().getText();
    }
    public String GetAccountErrorMessage(){
        return elements.GetPlayeeAccountError().getText();
    }
    public String GetAccountVerificationErrorMessage(){
        return elements.GetPlayeeVerifyAccountError().getText();
    }
    public String GetAmountErrorMessage(){
        return elements.GetPlayeeAmountError().getText();
    }

    public void ClearName(){
        elements.GetPlayeeName().clear();
    }
    public void ClearAddress(){
        elements.GetPlayeeAddress().clear();
    }
    public void ClearState(){
        elements.GetPlayeeState().clear();
    }
    public void ClearCity(){
        elements.GetPlayeeCity().clear();
    }
    public void ClearZipCode(){
        elements.GetPlayeeZip().clear();
    }
    public void ClearAccount(){
        elements.GetPlayeeAccount().clear();
    }
    public void ClearAccountVerification(){
        elements.GetPlayeeVerifyAccount().clear();
    }
    public void ClearPhone(){
        elements.GetPlayeePhone().clear();
    }
    public void ClearAmount(){
        elements.GetPlayeeAmount().clear();
    }

    public void WaitUntilDataIsLoaded() { elements.WaitUntilDataIsLoaded(); }
}
