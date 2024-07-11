package parabank.actions;

import org.openqa.selenium.WebDriver;
import parabank.elements.UpdateContractInfoPageElements;
import parabank.interfaces.IUpdateContractInfoPageActions;

public class UpdateContractInfoPageActions extends BaseActions implements IUpdateContractInfoPageActions {
    UpdateContractInfoPageElements elements;

    public UpdateContractInfoPageActions(WebDriver driver) {
        super(driver);
        elements =  new UpdateContractInfoPageElements(driver);
    }

    public void EnterFirstName(String text){
        elements.GetFirstNameUpdate().sendKeys(text);
    }
    public void EnterLastName(String text){
        elements.GetLastNameUpdate().sendKeys(text);
    }
    public void EnterAddress(String text){
        elements.GetAddressUpdate().sendKeys(text);
    }
    public void EnterState(String text){
        elements.GetStateUpdate().sendKeys(text);
    }
    public void EnterCity(String text){
        elements.GetCityUpdate().sendKeys(text);
    }
    public void EnterZipCode(String text){
        elements.GetZipCodeUpdate().sendKeys(text);
    }
    public void EnterPhone(String text){
        elements.GetPhoneUpdate().sendKeys(text);
    }

    public void ClickUpdateProfileButton(){
        elements.GetUpdateProfileButton().click();
    }
    public String GetUpdateSuccessfulMessage(){
        return elements.GetUpdateSuccessful().getText();
    }

    public void ClearFirstName(){
        elements.GetFirstNameUpdate().clear();
    }
    public void ClearLastName(){
        elements.GetLastNameUpdate().clear();
    }
    public void ClearAddress(){
        elements.GetAddressUpdate().clear();
    }
    public void ClearState(){
        elements.GetStateUpdate().clear();
    }
    public void ClearCity(){
        elements.GetCityUpdate().clear();
    }
    public void ClearZipCode(){
        elements.GetZipCodeUpdate().clear();
    }
    public void ClearPhone(){
        elements.GetPhoneUpdate().clear();
    }
}
