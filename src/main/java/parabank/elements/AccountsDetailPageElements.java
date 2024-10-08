package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    public void WaitUntilDataIsLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(accountNumber).isDisplayed());
        wait.until(d -> d.findElement(accountType).isDisplayed());
        wait.until(d -> d.findElement(accountBalance).isDisplayed());
        wait.until(d -> d.findElement(accountAvailable).isDisplayed());
    }
    public void WaitForTransactionDatesList(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> !d.findElements(accountTransactionDatesList).isEmpty());
    }
    public void WaitForTransactionTransactionList(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> !d.findElements(accountTransactionTransactionList).isEmpty());
    }
    public void WaitForTransactionDebitListList(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> !d.findElements(accountTransactionDebitList).isEmpty());
    }
    public void WaitForTransactionCreditList(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> !d.findElements(accountTransactionCreditList).isEmpty());
    }

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
