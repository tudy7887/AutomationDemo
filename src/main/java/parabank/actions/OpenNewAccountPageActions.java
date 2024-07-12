package parabank.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import parabank.elements.OpenNewAccountPageElements;
import parabank.interfaces.IOpenNewAccountPageActions;

public class OpenNewAccountPageActions extends BaseActions implements IOpenNewAccountPageActions {
    OpenNewAccountPageElements elements;

    public OpenNewAccountPageActions(WebDriver driver) {
        super(driver);
        elements =  new OpenNewAccountPageElements(driver);
        SetBaseElements(elements);
    }

    public void SetTypeAccountCombobox(String type){
        new Select(elements.GetAccountTypeCombobox()).selectByVisibleText(type);
    }
    public void SetFromAccountCombobox(String account){
        new Select(elements.GetExistingAccountCombobox()).selectByVisibleText(account);
    }
    public String GetNewAccount(){
        return elements.GetNewAccount().getText();
    }
    public void ClickCreateNewAccount(){
        elements.GetCreateNewAccountButton().click();
    }
    public void ClickNewAccount(){
        elements.GetNewAccount().click();
    }
}
