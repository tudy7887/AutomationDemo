package pageobjectmodel.freetraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// user: tudor.niculae@email.com
// parola: tudor7887

public class LoginPage {
    private WebDriver driver;
    private By Mail = By.id("userEmail");
    private By Password = By.id("userPassword");
    private By Login = By.id("submitButton");
    private By Error = By.id("errorForbiddenAccess");
    private By App = By.cssSelector("body > app-root > app-login");
    private String Link = "http://apptest.go.ro:9999/login";


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public String GetPageLink(){return Link;}
    public void SetMail(String text){
        driver.findElement(Mail).sendKeys(text);
    }
    public void SetPassword(String text){
        driver.findElement(Password).sendKeys(text);
    }
    public void ClickLogin(){
        driver.findElement(Login).click();
    }
    public String GetErrorMessage(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.findElement(Error).isEnabled());
        return driver.findElement(Error).getText();
    }
    public void WaitUntilLoaded()
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.findElement(App).isEnabled());
    }
}
