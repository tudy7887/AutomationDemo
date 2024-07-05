package fetraining.actions;

import fetraining.elements.BaseElements;
import fetraining.elements.CustomerDashBoardElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseActions {
    private BaseElements baseElements;
    private WebDriver driver;

    public BaseActions(WebDriver driver){
        this.driver = driver;
    }

    protected void SetBaseElements(BaseElements elements) {
        this.baseElements = elements;
    }

    public void WaitUntilLoaded()
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getCurrentUrl().contains(baseElements.GetLink()));
    }

    public void GotoPage()
    {
        driver.get(baseElements.GetLink());
    }
}
