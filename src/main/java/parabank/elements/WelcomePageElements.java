package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePageElements extends BaseElements {
    private By welcomeMessage;

    public WelcomePageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("welcomePageLink"));
        InitializeElements();
    }

    public WebElement GetWelcomeMessage(){
        return driver.findElement(welcomeMessage);
    }
    public void WaitUntilDataIsLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(welcomeMessage).isDisplayed());
    }
    private void InitializeElements(){
        welcomeMessage = GetElementByCSSSlecetor(configLoader.GetProperties("welcomeMessage"));
    }
}
