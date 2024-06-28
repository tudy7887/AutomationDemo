package fetraining.actions;

import fetraining.elements.LoginElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginActions extends BaseActions {
    private WebDriver driver;
    private LoginElements elements;

    public LoginActions(WebDriver driver){
        super(driver);
        elements = new LoginElements(driver);
        SetBaseElements(elements);
    }

    public void SetMail(String text){
        elements.MailInput().sendKeys(text);
    }
    public void SetPassword(String text){
        elements.PasswordInput().sendKeys(text);
    }
    public void ClickLogin(){
        elements.LoginButton().click();
    }
    public String GetErrorMessage() {
        return elements.ErrorMesage().getText();
    }
    public void ClearMail(){
        elements.MailInput().clear();
    }
    public void ClearPassword(){
        elements.PasswordInput().clear();
    }
}