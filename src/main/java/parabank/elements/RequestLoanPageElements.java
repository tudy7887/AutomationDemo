package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestLoanPageElements extends UserBaseElements {
    private By loanAmount, loanDownPayment, loanFromAccountCombobox, loanApplyButton, loanRRequestError,
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
    public WebElement GetLoanRequestError() { return driver.findElement(loanRRequestError); }
    public WebElement GetLoanStatus() { return driver.findElement(loanStatus); }
    public WebElement GetLoanAccountDenied() { return driver.findElement(loanAccountDenied); }
    public WebElement GetLoanAccountApproved() { return driver.findElement(loanAccountApproved); }
    public WebElement GetLoanAccountNumber(){ return driver.findElement(loanAccountNumber); }

    private void InitializeElements(){
        loanAmount = GetElementByCSSSlecetor(configLoader.GetProperties("loanAmount"));
        loanDownPayment = GetElementByCSSSlecetor(configLoader.GetProperties("loanDownPayment"));
        loanFromAccountCombobox = GetElementByCSSSlecetor(configLoader.GetProperties("loanFromAccountCombobox"));
        loanApplyButton = GetElementByCSSSlecetor(configLoader.GetProperties("loanApplyButton"));
        loanRRequestError = GetElementByCSSSlecetor(configLoader.GetProperties("loanRRequestError"));
        loanStatus = GetElementByCSSSlecetor(configLoader.GetProperties("loanStatus"));
        loanAccountDenied = GetElementByCSSSlecetor(configLoader.GetProperties("loanAccountDenied"));
        loanAccountApproved = GetElementByCSSSlecetor(configLoader.GetProperties("loanAccountApproved"));
        loanAccountNumber = GetElementByCSSSlecetor(configLoader.GetProperties("loanAccountNumber"));
    }
}
