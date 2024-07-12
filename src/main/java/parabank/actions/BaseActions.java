package parabank.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import parabank.elements.BaseElements;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseActions {
    protected WebDriver driver;
    BaseElements baseElements;

    public BaseActions(WebDriver driver){
        this.driver = driver;
    }

    protected void SetBaseElements(BaseElements elements) {
        this.baseElements = elements;
    }

    public void WaitUntilLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getCurrentUrl().contains(baseElements.GetLink()));
    }
    public void GotoPage() {
        driver.get(baseElements.GetLink());
        WaitUntilLoaded();
    }

    protected List<String> GetWebElementList(List<WebElement> webElementList){
        var result = new ArrayList<String>();
        for (var e : webElementList) { result.add(e.getText()); }
        return result;
    }
}
