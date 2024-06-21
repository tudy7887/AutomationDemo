package pageobjectmodel.freetraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private By FirstName = By.id("firstName");
    private By LastName = By.id("lastName");
    private By Phone = By.id("phoneNumber");
    private By Mail = By.id("email");
    private By Password = By.id("password");
    private By City = By.id("city");
    private By Customer = By.id("customer");
    private By Trainer = By.id("trainer");
    private By SignUp = By.id("submit");
    private By Error = By.cssSelector("body > div > div > form > div.customerAlreadyRegistered");
    private By App = By.cssSelector("body > app-root > app-register");
    private String Link = "http://apptest.go.ro:9999/register";


    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }


    public String GetPageLink(){return Link;}
    public void SetFirstName(String text){
        driver.findElement(FirstName).sendKeys(text);
    }
    public void SetLastName(String text){
        driver.findElement(LastName).sendKeys(text);
    }
    public void SetPhone(String text){
        driver.findElement(Phone).sendKeys(text);
    }
    public void SetMail(String text){
        driver.findElement(Mail).sendKeys(text);
    }
    public void SetPassword(String text){
        driver.findElement(Password).sendKeys(text);
    }
    public void SetCity(String text){
        driver.findElement(City).sendKeys(text);
    }
    public void ClickCustomerCheckBox(){
        driver.findElement(Customer).click();
    }
    public void ClickTrainerCheckBox(){
        driver.findElement(Trainer).click();
    }
    public void ClickSignup() {
        driver.findElement(SignUp).click();
    }
    public String GetErrorMessage() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.findElement(Error).isEnabled());
        return driver.findElement(App).getText();
    }
    public void WaitUntilLoaded()
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.findElement(App).isEnabled());
    }
}
