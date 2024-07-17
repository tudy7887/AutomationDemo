package fetraining.actions;

import fetraining.elements.CustomerTrainingElements;
import fetraining.elements.LoginElements;
import fetraining.interfaces.ICustomerTrainingPageActions;
import fetraining.interfaces.ILoginPageActions;
import org.openqa.selenium.WebDriver;

public class CustomerTrainingPageActions extends BaseActions implements ICustomerTrainingPageActions {
    private CustomerTrainingElements elements;

    public CustomerTrainingPageActions(WebDriver driver){
        super(driver);
        elements = new CustomerTrainingElements(driver);
        SetBaseElements(elements);
    }

}
