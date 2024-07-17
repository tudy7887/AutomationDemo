package fetraining.interfaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public interface IBaseActions {
    void WaitUntilLoaded();
    void GotoPage();
}
