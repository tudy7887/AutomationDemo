package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenNewAccountPageElements extends BaseElements {
    private By accountTypeCombobox, existingAccountCombobox, createNewAccountButton, newAccount;

    public OpenNewAccountPageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("openNewAccountPageLink"));
        InitializeElements();
    }

    public WebElement GetAccountTypeCombobox(){
        return driver.findElement(accountTypeCombobox);
    }
    public WebElement GetExistingAccountCombobox(){
        return driver.findElement(existingAccountCombobox);
    }
    public WebElement GetCreateNewAccountButton(){
        return driver.findElement(createNewAccountButton);
    }
    public WebElement GetNewAccount(){
        return driver.findElement(newAccount);
    }
    public void WaitUntilDataIsLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> !d.findElement(existingAccountCombobox).getText().isEmpty());
    }
    public void WaitUntilNewAccountLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(newAccount).isDisplayed());
    }

    private void InitializeElements(){
        accountTypeCombobox = GetElementByCSSSlecetor(configLoader.GetProperties("accountTypeCombobox"));
        existingAccountCombobox = GetElementByCSSSlecetor(configLoader.GetProperties("existingAccountCombobox"));
        createNewAccountButton = GetElementByCSSSlecetor(configLoader.GetProperties("createNewAccountButton"));
        newAccount = GetElementByCSSSlecetor(configLoader.GetProperties("newAccount"));
    }
}
