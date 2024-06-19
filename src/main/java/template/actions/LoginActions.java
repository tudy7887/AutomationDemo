package template.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import template.elements.LoginElements;

import java.time.Duration;

public class LoginActions {
    private WebDriver driver;
    private LoginElements elements;

    public LoginActions(WebDriver driver){
        this.driver = driver;
        elements = new LoginElements(driver);
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
}
