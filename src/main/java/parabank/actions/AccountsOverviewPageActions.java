package parabank.actions;

import org.openqa.selenium.WebDriver;
import parabank.elements.AccountsOverviewPageElements;
import parabank.interfaces.IAccountsOverviewPageActions;

import java.util.List;

public class AccountsOverviewPageActions extends UserBaseActions implements IAccountsOverviewPageActions {
    AccountsOverviewPageElements elements;

    public AccountsOverviewPageActions(WebDriver driver) {
        super(driver);
        elements = new AccountsOverviewPageElements(driver);
    }

    public void ClickAccountList(int index){
        elements.GetAccountList().get(index).click();
    }

    public List<String> GetAccountList(){
        return GetWebElementList(elements.GetAccountList());
    }
    public List<String> GetBalanceList(){
        var result = GetWebElementList(elements.GetBalanceListPlusTotal());
        result.removeLast();
        return result;
    }
    public String GetTotal(){
        return GetWebElementList(elements.GetBalanceListPlusTotal()).getLast();
    }
    public List<String> GetAvailableList(){
        return GetWebElementList(elements.GetAvailableList());
    }
}
