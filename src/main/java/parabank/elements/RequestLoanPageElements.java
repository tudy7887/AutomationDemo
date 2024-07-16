package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RequestLoanPageElements extends BaseElements {
    private By loanAmount, loanDownPayment, loanFromAccountCombobox, loanApplyButton, loanRequestError,
            loanStatus, loanAccountDenied, loanAccountApproved, loanAccountNumber;

    public RequestLoanPageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("requestLoanPageLink"));
        InitializeElements();
    }

    public WebElement GetLoanAmount() { return driver.findElement(loanAmount); }
    public WebElement GetLoanDownPayment() { return driver.findElement(loanDownPayment); }
    public WebElement GetLoanFromAccountCombobox() { return driver.findElement(loanFromAccountCombobox); }
    public WebElement GetLoanApplyButton() { return driver.findElement(loanApplyButton); }
    public WebElement GetLoanRequestError() { return driver.findElement(loanRequestError); }
    public WebElement GetLoanStatus() { return driver.findElement(loanStatus); }
    public WebElement GetLoanAccountDenied() { return driver.findElement(loanAccountDenied); }
    public WebElement GetLoanAccountApproved() { return driver.findElement(loanAccountApproved); }
    public WebElement GetLoanAccountNumber(){ return driver.findElement(loanAccountNumber); }
    public void WaitUntilDataIsLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> !d.findElement(loanFromAccountCombobox).getText().isEmpty());
    }
    public void WaitUntilStatusLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(loanStatus).isDisplayed());
    }
    public void WaitUntilErrorLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(loanRequestError).isDisplayed());
    }

    private void InitializeElements(){
        loanAmount = GetElementByCSSSlecetor(configLoader.GetProperties("loanAmount"));
        loanDownPayment = GetElementByCSSSlecetor(configLoader.GetProperties("loanDownPayment"));
        loanFromAccountCombobox = GetElementByCSSSlecetor(configLoader.GetProperties("loanFromAccountCombobox"));
        loanApplyButton = GetElementByCSSSlecetor(configLoader.GetProperties("loanApplyButton"));
        loanRequestError = GetElementByCSSSlecetor(configLoader.GetProperties("loanRRequestError"));
        loanStatus = GetElementByCSSSlecetor(configLoader.GetProperties("loanStatus"));
        loanAccountDenied = GetElementByCSSSlecetor(configLoader.GetProperties("loanAccountDenied"));
        loanAccountApproved = GetElementByCSSSlecetor(configLoader.GetProperties("loanAccountApproved"));
        loanAccountNumber = GetElementByCSSSlecetor(configLoader.GetProperties("loanAccountNumber"));
    }
}
