package parabank.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import parabank.elements.RequestLoanPageElements;
import parabank.interfaces.IRequestLoanPageActions;

public class RequestLoanPageActions extends BaseActions implements IRequestLoanPageActions {
    RequestLoanPageElements elements;

    public RequestLoanPageActions(WebDriver driver) {
        super(driver);
        elements =  new RequestLoanPageElements(driver);
        SetBaseElements(elements);
    }

    public void EnterAmount(String text){
        elements.GetLoanAmount().sendKeys(text);
    }
    public void EnterDownPayment(String text){
        elements.GetLoanDownPayment().sendKeys(text);
    }
    public void SetFromAccountCombobox(String account){
        new Select(elements.GetLoanFromAccountCombobox()).selectByVisibleText(account);
    }
    public void ClickApplyButton(){
        elements.GetLoanApplyButton().click();
    }
    public String GetErrorRequestMessage(){
        elements.WaitUntilErrorLoaded();
        return elements.GetLoanRequestError().getText();
    }
    public String GetStatusMessage(){
        elements.WaitUntilStatusLoaded();
        return elements.GetLoanStatus().getText();
    }
    public String GetApprovedMessage(){
        elements.WaitUntilStatusLoaded();
        return elements.GetLoanAccountApproved().getText();
    }
    public String GetDeniedMessage(){
        elements.WaitUntilStatusLoaded();
        return elements.GetLoanAccountDenied().getText();
    }
    public String GetAccountNumber(){
        elements.WaitUntilStatusLoaded();
        return elements.GetLoanAccountNumber().getText();
    }
    public void ClickOnAccountNumber(){
        elements.GetLoanAccountNumber().click();
    }
    public void ClearAmount(){
        elements.GetLoanAmount().clear();
    }
    public void ClearDownPayment(){
        elements.GetLoanDownPayment().clear();
    }
    public void WaitUntilDataIsLoaded() { elements.WaitUntilDataIsLoaded(); }
}
