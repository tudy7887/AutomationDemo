package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserMenuElements extends BaseElements{
    private By openNewAccountMenu, accountOverviewMenu, transferFundsMenu, billPayMenu, findTransactionsMenu,
            updateContractInfoMenu, requestLoanMenu, logOutMenu;

    public UserMenuElements(WebDriver driver) {
        super(driver);
        InitializeElements();
    }

    public WebElement GetOpenNewAccountMenu(){
        return driver.findElement(openNewAccountMenu);
    }
    public WebElement GetAccountOverviewMenu(){
        return driver.findElement(accountOverviewMenu);
    }
    public WebElement GetTransferFundsMenu(){
        return driver.findElement(transferFundsMenu);
    }
    public WebElement GetBillPayMenu(){
        return driver.findElement(billPayMenu);
    }
    public WebElement GetFindTransactionsMenu(){
        return driver.findElement(findTransactionsMenu);
    }
    public WebElement GetUpdateContractInfoMenu(){
        return driver.findElement(updateContractInfoMenu);
    }
    public WebElement GetRequestLoanMenu(){
        return driver.findElement(requestLoanMenu);
    }
    public WebElement GetLogOutMenu(){
        return driver.findElement(logOutMenu);
    }

    private void InitializeElements(){
        openNewAccountMenu = GetElementByCSSSlecetor(configLoader.GetProperties("openNewAccount"));
        accountOverviewMenu = GetElementByCSSSlecetor(configLoader.GetProperties("accountOverview"));
        transferFundsMenu = GetElementByCSSSlecetor(configLoader.GetProperties("transferFunds"));
        billPayMenu = GetElementByCSSSlecetor(configLoader.GetProperties("billPay"));
        findTransactionsMenu = GetElementByCSSSlecetor(configLoader.GetProperties("findTransactions"));
        updateContractInfoMenu = GetElementByCSSSlecetor(configLoader.GetProperties("updateContractInfo"));
        requestLoanMenu = GetElementByCSSSlecetor(configLoader.GetProperties("requestLoan"));
        logOutMenu = GetElementByCSSSlecetor(configLoader.GetProperties("logOut"));
    }
}
