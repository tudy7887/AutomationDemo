package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionDetailsPageElements extends BaseElements {
    private By transactionDetailsId, transactionDetailsDate, transactionDetailsType, transactionDetailsAmount;

    public TransactionDetailsPageElements(WebDriver driver) {
        super(driver);
        InitializeElements();
    }

    public void SetLinkId(String id) {SetLink(configLoader.GetProperties("transactionDetailsPageLink") + id);}

    public WebElement GetTransactionDetailsId(){
        return driver.findElement(transactionDetailsId);
    }
    public WebElement GetTransactionDetailsDate(){
        return driver.findElement(transactionDetailsDate);
    }
    public WebElement GetTransactionDetailsType(){
        return driver.findElement(transactionDetailsType);
    }
    public WebElement GetTransactionDetailsAmount(){
        return driver.findElement(transactionDetailsAmount);
    }

    private void InitializeElements(){
        transactionDetailsId = GetElementByCSSSlecetor(configLoader.GetProperties("transactionDetailsId"));
        transactionDetailsDate = GetElementByCSSSlecetor(configLoader.GetProperties("transactionDetailsDate"));
        transactionDetailsType = GetElementByCSSSlecetor(configLoader.GetProperties("transactionDetailsType"));
        transactionDetailsAmount = GetElementByCSSSlecetor(configLoader.GetProperties("transactionDetailsAmount"));
    }
}
