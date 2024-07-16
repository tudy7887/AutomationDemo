package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundsPageElements extends BaseElements {
    private By amount, fromAccountCombobox, toAccountCombobox, transferButton, transferFundsError, transferFundSuccessful;

    public TransferFundsPageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("transferFoundsPageLink"));
        InitializeElements();
    }

    public WebElement GetAmount(){
        return driver.findElement(amount);
    }
    public WebElement GetFromAccountCombobox(){
        return driver.findElement(fromAccountCombobox);
    }
    public WebElement GetToAccountCombobox(){
        return driver.findElement(toAccountCombobox);
    }
    public WebElement GetTransferButton(){
        return driver.findElement(transferButton);
    }
    public WebElement GetTransferFundsError(){
        return driver.findElement(transferFundsError);
    }
    public WebElement GetTransferFundSuccessful(){
        return driver.findElement(transferFundSuccessful);
    }
    public void WaitUntilDataIsLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> !d.findElement(fromAccountCombobox).getText().isEmpty());
        wait.until(d -> !d.findElement(toAccountCombobox).getText().isEmpty());
    }
    public void WaitUntilSuccessfulIsLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(transferFundSuccessful).isDisplayed());
    }
    public void WaitUntilErrorsLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(transferFundsError).isDisplayed());
    }

    private void InitializeElements(){
        amount = GetElementByCSSSlecetor(configLoader.GetProperties("amount"));
        fromAccountCombobox = GetElementByCSSSlecetor(configLoader.GetProperties("fromAccountCombobox"));
        toAccountCombobox = GetElementByCSSSlecetor(configLoader.GetProperties("toAccountCombobox"));
        transferButton = GetElementByCSSSlecetor(configLoader.GetProperties("transferButton"));
        transferFundsError = GetElementByCSSSlecetor(configLoader.GetProperties("transferFundsError"));
        transferFundSuccessful = GetElementByCSSSlecetor(configLoader.GetProperties("transferFundSuccessful"));
    }
}
