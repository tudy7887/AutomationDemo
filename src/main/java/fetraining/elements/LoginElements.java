package fetraining.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginElements extends BaseElements {
    private By email = By.id("userEmail");
    private By password = By.id("userPassword");
    private By login = By.id("submitButton");
    private By error = By.id("errorForbiddenAccess");

    public LoginElements(WebDriver driver){
        super(driver);
        SetLink("http://apptest.go.ro:9999/login");
    }

    public WebElement MailInput(){
        return driver.findElement(email);
    }
    public WebElement PasswordInput(){
        return driver.findElement(password);
    }
    public WebElement LoginButton(){
        return driver.findElement(login);
    }
    public WebElement ErrorMesage(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.findElement(error).isEnabled());
        return driver.findElement(error);
    }
}
