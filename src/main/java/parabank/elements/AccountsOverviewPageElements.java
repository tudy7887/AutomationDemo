package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountsOverviewPageElements extends BaseElements {
    private By accountList, balanceListPlusTotal, availableList, accountsOverviewTitle;

    public AccountsOverviewPageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("accountsOverviewPageLink"));
        InitializeElements();
    }

    public WebElement GetAccountsOverviewTitle(){
        return driver.findElement(accountsOverviewTitle);
    }
    public List<WebElement> GetAccountList(){
        return driver.findElements(accountList);
    }
    public List<WebElement> GetBalanceListPlusTotal(){
        return driver.findElements(balanceListPlusTotal);
    }
    public List<WebElement> GetAvailableList(){
        return driver.findElements(availableList);
    }
    public void WaitUntilDataIsLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(accountList).isDisplayed());
    }

    private void InitializeElements(){
        accountList = GetElementByCSSSlecetor(configLoader.GetProperties("accountList"));
        accountsOverviewTitle = GetElementByCSSSlecetor(configLoader.GetProperties("accountsOverviewTitle"));
        balanceListPlusTotal = GetElementByCSSSlecetor(configLoader.GetProperties("balanceListPlusTotal"));
        availableList = GetElementByCSSSlecetor(configLoader.GetProperties("availableList"));
    }
}
