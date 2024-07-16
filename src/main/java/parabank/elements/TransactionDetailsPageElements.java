package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    public void WaitUntilDataIsLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(transactionDetailsId).isDisplayed());
    }

    private void InitializeElements(){
        transactionDetailsId = GetElementByCSSSlecetor(configLoader.GetProperties("transactionDetailsId"));
        transactionDetailsDate = GetElementByCSSSlecetor(configLoader.GetProperties("transactionDetailsDate"));
        transactionDetailsType = GetElementByCSSSlecetor(configLoader.GetProperties("transactionDetailsType"));
        transactionDetailsAmount = GetElementByCSSSlecetor(configLoader.GetProperties("transactionDetailsAmount"));
    }
}
