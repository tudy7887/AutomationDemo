package parabank.actions;

import org.openqa.selenium.WebDriver;
import parabank.elements.TransactionDetailsPageElements;
import parabank.interfaces.ITransactionDetailsPageActions;

public class TransactionDetailsPageActions extends BaseActions implements ITransactionDetailsPageActions {
    TransactionDetailsPageElements elements;

    public TransactionDetailsPageActions(WebDriver driver) {
        super(driver);
        elements = new TransactionDetailsPageElements(driver);
        SetBaseElements(elements);
    }

    public void ChooseTransaction(String id) {
        elements.SetLinkId(id);
    }

    public String GetTransactionId(){
        return elements.GetTransactionDetailsId().getText();
    }
    public String GetTransactionDate(){
        return elements.GetTransactionDetailsDate().getText();
    }
    public String GetTransactionType(){
        return elements.GetTransactionDetailsType().getText();
    }
    public String GetTransactionAmount(){
        return elements.GetTransactionDetailsAmount().getText();
    }
}
