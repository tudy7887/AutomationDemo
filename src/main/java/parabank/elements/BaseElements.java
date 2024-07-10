package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ConfigLoader;

public class BaseElements {
    private String propertyFilePath = "src/test/resources/properties/ParaBank.properties";
    private String link;
    protected ConfigLoader configLoader;
    protected WebDriver driver;
    private By openNewAccountMenu, accountOverviewMenu, transferFundsMenu, billPayMenu, findTransactionsMenu, updateContractInfoMenu, requestLoanMenu, logOutMenu;

    public BaseElements(WebDriver driver)
    {
        this.driver =  driver;
        configLoader = new ConfigLoader(propertyFilePath);
        InitializeBaseElements();
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

    public String GetLink(){ return link; }

    protected void SetLink(String link) { this.link = link; }

    private By GetElementByCSSSlecetor(String selector){ return By.cssSelector(selector); }

    private void InitializeBaseElements(){
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
