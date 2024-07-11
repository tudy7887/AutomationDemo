package parabank.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import parabank.classes.User;
import parabank.elements.BaseElements;

import java.time.Duration;

public class BaseActions {
    private BaseElements elements;
    protected WebDriver driver;

    public BaseActions(WebDriver driver){
        this.driver = driver;
        elements =  new BaseElements(driver);
    }

    public void WaitUntilLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getCurrentUrl().contains(elements.GetLink()));
    }
    public void GotoPage() {
        driver.get(elements.GetLink());
    }
}
