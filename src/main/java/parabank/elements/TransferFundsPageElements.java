package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferFundsPageElements extends BaseElements {
    private By amount, fromAccountCombobox, toAccountCombobox, transferButton, transferFundsError, transferFundSuccessful;

    public TransferFundsPageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("transferFoundsPageLink"));
        InitializeElements();
    }

    public WebElement GetAmount(){
        return driver.findElement(amount);
    }
    public WebElement GetFromAccountCombobox(){
        return driver.findElement(fromAccountCombobox);
    }
    public WebElement GetToAccountCombobox(){
        return driver.findElement(toAccountCombobox);
    }
    public WebElement GetTransferButton(){
        return driver.findElement(transferButton);
    }
    public WebElement GetTransferFundsError(){
        return driver.findElement(transferFundsError);
    }
    public WebElement GetTransferFundSuccessful(){
        return driver.findElement(transferFundSuccessful);
    }

    private void InitializeElements(){
        amount = GetElementByCSSSlecetor(configLoader.GetProperties("amount"));
        fromAccountCombobox = GetElementByCSSSlecetor(configLoader.GetProperties("fromAccountCombobox"));
        toAccountCombobox = GetElementByCSSSlecetor(configLoader.GetProperties("toAccountCombobox"));
        transferButton = GetElementByCSSSlecetor(configLoader.GetProperties("transferButton"));
        transferFundsError = GetElementByCSSSlecetor(configLoader.GetProperties("transferFundsError"));
        transferFundSuccessful = GetElementByCSSSlecetor(configLoader.GetProperties("transferFundSuccessful"));
    }
}
