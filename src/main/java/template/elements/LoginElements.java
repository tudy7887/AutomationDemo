package template.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginElements {
    private WebDriver driver;
    private By Mail = By.id("userEmail");
    private By Password = By.id("userPassword");
    private By Login = By.id("submitButton");
    private By Error = By.id("errorForbiddenAccess");


    public LoginElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement MailInput(){
        return driver.findElement(Mail);
    }
    public WebElement PasswordInput(){
        return driver.findElement(Password);
    }
    public WebElement LoginButton(){
        return driver.findElement(Login);
    }
    public WebElement ErrorMesage(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.findElement(Error).isEnabled());
        return driver.findElement(Error);
    }
}
