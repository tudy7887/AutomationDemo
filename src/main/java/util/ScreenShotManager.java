package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotManager {
    private WebDriver driver;

    public ScreenShotManager(WebDriver driver){
        this.driver = driver;
    }

    public void CaptureAndSaveScreenShot(String testName) {
        try {
            var file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            var timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            var screenShot = testName + "_" + timestamp + ".png";
            var directory = "ScreenShots";

            var targetFile = new File(directory, screenShot);
            FileUtils.copyFile(file, targetFile);

            System.out.println(screenShot + "saved to " + targetFile.getAbsolutePath());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
