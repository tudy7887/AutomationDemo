package parabank.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import parabank.elements.UserMenuElements;
import parabank.interfaces.IUserMenuActions;

import java.util.ArrayList;
import java.util.List;

public class UserMenuActions extends BaseActions implements IUserMenuActions {
    private UserMenuElements elements;
    public UserMenuActions(WebDriver driver) {
        super(driver);
        elements = new UserMenuElements(driver);
    }

    public void ClickOpenNewAccountMenu() { elements.GetOpenNewAccountMenu().click(); }
    public void ClickAccountOverviewMenu() { elements.GetAccountOverviewMenu().click(); }
    public void ClickTransferFundsMenu(){ elements.GetTransferFundsMenu().click(); }
    public void ClickBillPayMenu() { elements.GetBillPayMenu().click(); }
    public void ClickFindTransactionsMenu() { elements.GetFindTransactionsMenu().click(); }
    public void ClickUpdateContractInfoMenu() { elements.GetUpdateContractInfoMenu().click(); }
    public void ClickRequestLoanMenu() { elements.GetRequestLoanMenu().click(); }
    public void ClickLogOutMenu() { elements.GetLogOutMenu().click(); }
}
