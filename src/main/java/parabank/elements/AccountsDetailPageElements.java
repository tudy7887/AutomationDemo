package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountsDetailPageElements extends BaseElements {
    private By accountNumber, accountType, accountBalance, accountAvailable, accountTransactionDatesList,
            accountTransactionTransactionList, accountTransactionDebitList, accountTransactionCreditList;

    public AccountsDetailPageElements(WebDriver driver) {
        super(driver);
        InitializeElements();
    }

    public void SetLinkId(String id) {SetLink(configLoader.GetProperties("accountDetailsPageLink") + id);}

    public WebElement GetAccountNumber(){
        return driver.findElement(accountNumber);
    }
    public WebElement GetAccountType(){
        return driver.findElement(accountType);
    }
    public WebElement GetAccountBalance(){
        return driver.findElement(accountBalance);
    }
    public WebElement GetAccountAvailable(){
        return driver.findElement(accountAvailable);
    }
    public List<WebElement> GetAccountTransactionDatesList() { return driver.findElements(accountTransactionDatesList); }
    public List<WebElement> GetAccountTransactionTransactionList() { return driver.findElements(accountTransactionTransactionList); }
    public List<WebElement> GetAccountTransactionDebitList() { return driver.findElements(accountTransactionDebitList); }
    public List<WebElement> GetAccountTransactionCreditList() { return driver.findElements(accountTransactionCreditList); }

    private void InitializeElements(){
        accountNumber = GetElementByCSSSlecetor(configLoader.GetProperties("accountNumber"));
        accountType = GetElementByCSSSlecetor(configLoader.GetProperties("accountType"));
        accountBalance = GetElementByCSSSlecetor(configLoader.GetProperties("accountBalance"));
        accountAvailable = GetElementByCSSSlecetor(configLoader.GetProperties("accountAvailable"));
        accountTransactionDatesList = GetElementByCSSSlecetor(configLoader.GetProperties("accountTransactionDatesList"));
        accountTransactionTransactionList = GetElementByCSSSlecetor(configLoader.GetProperties("accountTransactionTransactionList"));
        accountTransactionDebitList = GetElementByCSSSlecetor(configLoader.GetProperties("accountTransactionDebitList"));
        accountTransactionCreditList = GetElementByCSSSlecetor(configLoader.GetProperties("accountTransactionCreditList"));
    }
}
