package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    private void InitializeElements(){
        welcomeMessage = GetElementByCSSSlecetor(configLoader.GetProperties("welcomeMessage"));
    }
}
