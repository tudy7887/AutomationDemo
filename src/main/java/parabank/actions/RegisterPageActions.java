package parabank.actions;

import org.openqa.selenium.WebDriver;
import parabank.elements.RegisterPageElements;
import parabank.interfaces.IRegisterPageActions;

public class RegisterPageActions extends BaseActions implements IRegisterPageActions {
    RegisterPageElements elements;

    public RegisterPageActions(WebDriver driver) {
        super(driver);
        elements = new RegisterPageElements(driver);
        SetBaseElements(elements);
    }

    public void EnterFirstName(String text){
        elements.GetFirstName().sendKeys(text);
    }
    public void EnterLastName(String text){
        elements.GetLastName().sendKeys(text);
    }
    public void EnterAddress(String text){
        elements.GetAdress().sendKeys(text);
    }
    public void EnterState(String text){
        elements.GetState().sendKeys(text);
    }
    public void EnterCity(String text){
        elements.GetCity().sendKeys(text);
    }
    public void EnterZipCode(String text){
        elements.GetZipCode().sendKeys(text);
    }
    public void EnterSsn(String text){
        elements.GetSsn().sendKeys(text);
    }
    public void EnterPhone(String text){
        elements.GetPhone().sendKeys(text);
    }
    public void EnterUsername(String text){
        elements.GetUsername().sendKeys(text);
    }
    public void EnterPassword(String text){
        elements.GetPassword().sendKeys(text);
    }
    public void EnterPasswordConfirmation(String text){
        elements.GetPasswordConfirmation().sendKeys(text);
    }

    public void ClickRegisterButtonButton(){
        elements.GetRegisterButton().click();
    }

    public void ClearFirstName(){
        elements.GetFirstName().clear();
    }
    public void ClearLastName(){
        elements.GetLastName().clear();
    }
    public void ClearAddress(){
        elements.GetAdress().clear();
    }
    public void ClearState(){
        elements.GetState().clear();
    }
    public void ClearCity(){
        elements.GetCity().clear();
    }
    public void ClearZipCode(){
        elements.GetZipCode().clear();
    }
    public void ClearSSn(){
        elements.GetSsn().clear();
    }
    public void ClearPhone(){
        elements.GetPhone().clear();
    }
    public void ClearUsername(){
        elements.GetUsername().clear();
    }
    public void ClearPassword(){
        elements.GetPassword().clear();
    }
    public void ClearPasswordConfirmation(){
        elements.GetPasswordConfirmation().clear();
    }
}
