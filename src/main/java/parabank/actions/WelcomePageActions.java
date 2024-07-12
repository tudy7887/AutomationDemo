package parabank.actions;

import org.openqa.selenium.WebDriver;
import parabank.elements.WelcomePageElements;
import parabank.interfaces.IWelcomePageActions;

public class WelcomePageActions extends BaseActions implements IWelcomePageActions {
    WelcomePageElements elements;

    public WelcomePageActions(WebDriver driver) {
        super(driver);
        elements =  new WelcomePageElements(driver);
        SetBaseElements(elements);
    }

    public String GetWelcomeNewUserMessage(){
        return elements.GetWelcomeMessage().getText();
    }
}
