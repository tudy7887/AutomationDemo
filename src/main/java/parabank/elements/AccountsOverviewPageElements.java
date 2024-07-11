package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountsOverviewPageElements extends BaseElements {
    private By accountList, balanceListPlusTotal, availableList;

    public AccountsOverviewPageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("accountsOverviewPageLink"));
        InitializeElements();
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

    private void InitializeElements(){
        accountList = GetElementByCSSSlecetor(configLoader.GetProperties("accountList"));
        balanceListPlusTotal = GetElementByCSSSlecetor(configLoader.GetProperties("balanceListPlusTotal"));
        availableList = GetElementByCSSSlecetor(configLoader.GetProperties("availableList"));
    }
}
