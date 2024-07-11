package parabank.actions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import parabank.elements.TransferFundsPageElements;
import parabank.interfaces.ITransferFundsPageActions;

public class TransferFundsPageActions extends UserBaseActions implements ITransferFundsPageActions {
    TransferFundsPageElements elements;

    public TransferFundsPageActions(WebDriver driver) {
        super(driver);
        elements =  new TransferFundsPageElements(driver);
    }

    public void EnterAmount(String text){
        elements.GetAmount().sendKeys(text);
    }
    public String GetTransferFoundsErrorMessage(){
        return elements.GetTransferFundsError().getText();
    }
    public void ClickTransferButton(){
        elements.GetTransferButton().click();
    }
    public void SetFromAccountComboBox(String account){
        new Select(elements.GetFromAccountCombobox()).selectByVisibleText(account);
    }
    public void SetToAccountComboBox(String account){
        new Select(elements.GetToAccountCombobox()).selectByVisibleText(account);
    }
}