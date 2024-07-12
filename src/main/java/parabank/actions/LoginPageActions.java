package parabank.actions;

import org.openqa.selenium.WebDriver;
import parabank.elements.LoginPageElements;
import parabank.interfaces.ILoginPageActions;

public class LoginPageActions extends BaseActions implements ILoginPageActions {
    LoginPageElements elements;

    public LoginPageActions(WebDriver driver) {
        super(driver);
        elements = new LoginPageElements(driver);
        SetBaseElements(elements);
    }

    public void EnterUsername(String text){
        elements.GetUsername().sendKeys(text);
    }
    public void EnterPassword(String text){
        elements.GetPassword().sendKeys(text);
    }
    public String GetLoginErrorMessage(){
        return elements.GetLoginError().getText();
    }
    public void ClickLoginButton(){
        elements.GetLoginButton().click();
    }
    public void ClickRegisterLink(){
        elements.GetRegisterLink().click();
    }
    public void ClearUsername(){
        elements.GetUsername().clear();
    }
    public void ClearPassword(){
        elements.GetPassword().clear();
    }
}
