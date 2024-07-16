package parabank.actions;

import org.openqa.selenium.WebDriver;
import parabank.elements.AccountsOverviewPageElements;
import parabank.interfaces.IAccountsOverviewPageActions;

import java.util.List;

public class AccountsOverviewPageActions extends BaseActions implements IAccountsOverviewPageActions {
    AccountsOverviewPageElements elements;

    public AccountsOverviewPageActions(WebDriver driver) {
        super(driver);
        elements = new AccountsOverviewPageElements(driver);
        SetBaseElements(elements);
    }

    public void ClickAccountList(int index){
        elements.GetAccountList().get(index).click();
    }
    public List<String> GetAccountList(){
        return GetWebElementList(elements.GetAccountList());
    }
    public String GetAccountOverviewTitle() { return elements.GetAccountsOverviewTitle().getText(); }
    public List<String> GetBalanceList(){
        var result = GetWebElementList(elements.GetBalanceListPlusTotal());
        result.remove(result.size() - 1);
        return result;
    }
    public String GetTotal(){
        var result = GetWebElementList(elements.GetBalanceListPlusTotal());
        return result.get(result.size() - 1);
    }
    public List<String> GetAvailableList(){
        return GetWebElementList(elements.GetAvailableList());
    }
    public void WaitUntilDataIsLoaded() { elements.WaitUntilDataIsLoaded(); }
}
