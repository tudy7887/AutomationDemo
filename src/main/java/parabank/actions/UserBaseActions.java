package parabank.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import parabank.elements.UserBaseElements;
import parabank.elements.WelcomePageElements;
import parabank.interfaces.IUserBaseActions;

import java.util.ArrayList;
import java.util.List;

public class UserBaseActions extends BaseActions implements IUserBaseActions {
    private UserBaseElements elements;
    public UserBaseActions(WebDriver driver) {
        super(driver);
        elements = new UserBaseElements(driver);
    }

    public void ClickOpenNewAccountMenu() { elements.GetOpenNewAccountMenu().click(); }
    public void ClickAccountOverviewMenu() { elements.GetAccountOverviewMenu().click(); }
    public void ClickTransferFundsMenu(){ elements.GetTransferFundsMenu().click(); }
    public void ClickBillPayMenu() { elements.GetBillPayMenu().click(); }
    public void ClickFindTransactionsMenu() { elements.GetFindTransactionsMenu().click(); }
    public void ClickUpdateContractInfoMenu() { elements.GetUpdateContractInfoMenu().click(); }
    public void ClickRequestLoanMenu() { elements.GetRequestLoanMenu().click(); }
    public void ClickLogOutMenu() { elements.GetLogOutMenu().click(); }

    protected List<String> GetWebElementList(List<WebElement> webElementList){
        var result = new ArrayList<String>();
        for (var e : webElementList) { result.add(e.getText()); }
        return result;
    }
}
