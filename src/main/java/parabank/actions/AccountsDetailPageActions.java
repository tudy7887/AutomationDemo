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
        return GetWebElementList(elements.GetAccountTransactionDatesList());
    }
    public List<String> GetTransactionTransactionList(){
        return GetWebElementList(elements.GetAccountTransactionTransactionList());
    }
    public List<String> GetTransactionDebitList(){
        return GetWebElementList(elements.GetAccountTransactionDebitList());
    }
    public List<String> GetTransactionCreditList(){
        return GetWebElementList(elements.GetAccountTransactionCreditList());
    }
}
