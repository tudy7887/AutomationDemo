package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindTransactionsPageElements extends BaseElements {
    private By selectAccountCombobox, transactionId, findByIdButton, findByIdError, transactionDate, findByDateButton,
            findByDateError, transactionBetweenDate, transactionToDate, findByDateRangeButton, findByDateRangeError,
            transactionAmount, findByAmountButton, findByAmountError, transactionResultDateList,
            transactionResultTransactionList, transactionResultDebitList, transactionResultCreditList;

    public FindTransactionsPageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("findTransactionPageLink"));
        InitializeElements();
    }

    public WebElement GetSelectAccountCombobox(){
        return driver.findElement(selectAccountCombobox);
    }
    public WebElement GetTransactionId(){
        return driver.findElement(transactionId);
    }
    public WebElement GetFindByIdButton(){
        return driver.findElement(findByIdButton);
    }
    public WebElement GetFindByIdError(){
        return driver.findElement(findByIdError);
    }
    public WebElement GetTransactionDate(){
        return driver.findElement(transactionDate);
    }
    public WebElement GetFindByDateButton(){
        return driver.findElement(findByDateButton);
    }
    public WebElement GetFindByDateError(){
        return driver.findElement(findByDateError);
    }
    public WebElement GetTransactionBetweenDate(){
        return driver.findElement(transactionBetweenDate);
    }
    public WebElement GetTransactionToDate(){
        return driver.findElement(transactionToDate);
    }
    public WebElement GetFindByDateRangeButton(){
        return driver.findElement(findByDateRangeButton);
    }
    public WebElement GetFindByDateRangeError(){
        return driver.findElement(findByDateRangeError);
    }
    public WebElement GetTransactionAmount(){
        return driver.findElement(transactionAmount);
    }
    public WebElement GetFindByAmountButton(){
        return driver.findElement(findByAmountButton);
    }
    public WebElement GetFindByAmountError(){
        return driver.findElement(findByAmountError);
    }
    public List<WebElement> GetTransactionResultDateList() { return driver.findElements(transactionResultDateList); }
    public List<WebElement> GetTransactionResultTransactionList() { return driver.findElements(transactionResultTransactionList); }
    public List<WebElement> GetTransactionResultDebitList() { return driver.findElements(transactionResultDebitList); }
    public List<WebElement> GetTransactionResultCreditList() { return driver.findElements(transactionResultCreditList); }

    private void InitializeElements(){
        selectAccountCombobox = GetElementByCSSSlecetor(configLoader.GetProperties("selectAccountCombobox"));
        transactionId = GetElementByCSSSlecetor(configLoader.GetProperties("transactionId"));
        findByIdButton = GetElementByCSSSlecetor(configLoader.GetProperties("findByIdButton"));
        findByIdError = GetElementByCSSSlecetor(configLoader.GetProperties("findByIdError"));
        transactionDate = GetElementByCSSSlecetor(configLoader.GetProperties("transactionDate"));
        findByDateButton = GetElementByCSSSlecetor(configLoader.GetProperties("findByDateButton"));
        findByDateError = GetElementByCSSSlecetor(configLoader.GetProperties("findByDateError"));
        transactionBetweenDate = GetElementByCSSSlecetor(configLoader.GetProperties("transactionBetweenDate"));
        transactionToDate = GetElementByCSSSlecetor(configLoader.GetProperties("transactionToDate"));
        findByDateRangeButton = GetElementByCSSSlecetor(configLoader.GetProperties("findByDateRangeButton"));
        findByDateRangeError = GetElementByCSSSlecetor(configLoader.GetProperties("findByDateRangeError"));
        transactionAmount = GetElementByCSSSlecetor(configLoader.GetProperties("transactionAmount"));
        findByAmountButton = GetElementByCSSSlecetor(configLoader.GetProperties("findByAmountButton"));
        findByAmountError = GetElementByCSSSlecetor(configLoader.GetProperties("findByAmountError"));
        transactionResultDateList = GetElementByCSSSlecetor(configLoader.GetProperties("transactionResultDateList"));
        transactionResultTransactionList = GetElementByCSSSlecetor(configLoader.GetProperties("transactionResultTransactionList"));
        transactionResultDebitList = GetElementByCSSSlecetor(configLoader.GetProperties("transactionResultDebitList"));
        transactionResultCreditList = GetElementByCSSSlecetor(configLoader.GetProperties("transactionResultCreditList"));
    }
}
