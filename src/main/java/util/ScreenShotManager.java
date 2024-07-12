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

    public File CaptureAndSaveScreenShot(String testName) {
        var timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        var screenShot = testName + "_" + timestamp + ".png";
        var directory = "Results/ScreenShots";
        var targetFile = new File(directory, screenShot);
        try {
            var file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, targetFile);
            System.out.println(screenShot + "saved to " + targetFile.getAbsolutePath());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return new File("ScreenShots", screenShot);
    }
}
