package parabank.actions;

import org.openqa.selenium.WebDriver;
import parabank.elements.AccountsDetailPageElements;
import parabank.interfaces.IAccountsDetailPageActions;

import java.util.List;

public class AccountsDetailPageActions extends BaseActions implements IAccountsDetailPageActions {
    AccountsDetailPageElements elements;

    public AccountsDetailPageActions(WebDriver driver) {
        super(driver);
        elements = new AccountsDetailPageElements(driver);
        SetBaseElements(elements);
    }

    public void ChooseAccount(String number) {
        elements.SetLinkId(number);
    }

    public String GetNumber(){
        return elements.GetAccountNumber().getText();
    }
    public String GetType(){
        return elements.GetAccountType().getText();
    }
    public String GetBalance(){
        return elements.GetAccountBalance().getText();
    }
    public String GetAvailable(){
        return elements.GetAccountAvailable().getText();
    }

    public void ClickTransactionTransactionList(int index){
        elements.GetAccountTransactionTransactionList().get(index).click();
    }

    public List<String> GetTransactionDatesList(){
        elements.WaitForTransactionDatesList();
        return GetWebElementList(elements.GetAccountTransactionDatesList());
    }
    public List<String> GetTransactionTransactionList(){
        elements.WaitForTransactionTransactionList();
        return GetWebElementList(elements.GetAccountTransactionTransactionList());
    }
    public List<String> GetTransactionDebitList(){
        elements.WaitForTransactionDebitListList();
        return GetWebElementList(elements.GetAccountTransactionDebitList());
    }
    public List<String> GetTransactionCreditList(){
        elements.WaitForTransactionCreditList();
        return GetWebElementList(elements.GetAccountTransactionCreditList());
    }
    public void WaitUntilDataIsLoaded() { elements.WaitUntilDataIsLoaded(); }
}
