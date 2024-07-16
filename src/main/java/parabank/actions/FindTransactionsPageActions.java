package parabank.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import parabank.elements.FindTransactionsPageElements;
import parabank.interfaces.IFindTransactionsPageActions;

import java.util.List;

public class FindTransactionsPageActions extends BaseActions implements IFindTransactionsPageActions {
    FindTransactionsPageElements elements;

    public FindTransactionsPageActions(WebDriver driver) {
        super(driver);
        elements = new FindTransactionsPageElements(driver);
        SetBaseElements(elements);
    }

    public void SetFromAccountCombobox(String account){
        new Select(elements.GetSelectAccountCombobox()).selectByVisibleText(account);
    }

    public void EnterSearchTransactionId(String text){
        elements.GetTransactionId().sendKeys(text);
    }
    public void EnterSearchTransactionDate(String text){
        elements.GetTransactionDate().sendKeys(text);
    }
    public void EnterSearchTransactionFromDate(String text){
        elements.GetTransactionBetweenDate().sendKeys(text);
    }
    public void EnterSearchTransactionToDate(String text){
        elements.GetTransactionToDate().sendKeys(text);
    }
    public void EnterSearchTransactionAmount(String text){
        elements.GetTransactionAmount().sendKeys(text);
    }

    public String GetFindByIdErrorErrorMessage(){
        return elements.GetFindByIdError().getText();
    }
    public String GetFindByDateErrorErrorMessage(){
        return elements.GetFindByDateError().getText();
    }
    public String GetFindByDateRangeErrorErrorMessage(){
        return elements.GetFindByDateRangeError().getText();
    }
    public String GetFindByAmountErrorErrorMessage(){
        return elements.GetFindByAmountError().getText();
    }

    public void ClickFindByIdButton(){
        elements.GetFindByIdButton().click();
    }
    public void ClickFindByDateButton(){
        elements.GetFindByDateButton().click();
    }
    public void ClickFindByDateRangeButton(){
        elements.GetFindByDateRangeButton().click();
    }
    public void ClickFindByAmountButton(){
        elements.GetFindByAmountButton().click();
    }

    public void ClearSearchTransactionId(){
        elements.GetTransactionId().clear();
    }
    public void ClearSearchTransactionDate(){
        elements.GetTransactionDate().clear();
    }
    public void ClearSearchTransactionFromDate(){
        elements.GetTransactionBetweenDate().clear();
    }
    public void ClearSearchTransactionToDate(){
        elements.GetTransactionToDate().clear();
    }
    public void ClearSearchTransactionAmount(){
        elements.GetTransactionAmount().clear();
    }

    public void ClickResultTransactionList(int index){
        elements.GetTransactionResultTransactionList().get(index).click();
    }

    public List<String> GetResultDateList(){
        elements.WaitUntilResultIsLoaded();
        return GetWebElementList(elements.GetTransactionResultDateList());
    }
    public List<String> GetResultTransactionList(){
        elements.WaitUntilResultIsLoaded();
        return GetWebElementList(elements.GetTransactionResultTransactionList());
    }
    public List<String> GetResultDebitList(){
        elements.WaitUntilResultIsLoaded();
        return GetWebElementList(elements.GetTransactionResultDebitList());
    }
    public List<String> GetResultCreditList(){
        elements.WaitUntilResultIsLoaded();
        return GetWebElementList(elements.GetTransactionResultCreditList());
    }
    public void WaitUntilDataIsLoaded() { elements.WaitUntilDataIsLoaded(); }
}
