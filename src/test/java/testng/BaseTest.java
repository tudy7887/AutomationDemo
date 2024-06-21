package testng;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import util.ReportManager;
import util.ScreenShotManager;
import webdriver.Chrome;

import java.io.File;

public class BaseTest {
    private Chrome chrome;
    protected WebDriver driver;
    private ExtentTest extentTest;
    private ScreenShotManager screenShotManager;

    @BeforeSuite
    public void Setup(){
        chrome = new Chrome();
        driver =  chrome.GetChromeDriver();
        screenShotManager = new ScreenShotManager(driver);
    }

    @AfterSuite
    public void Teardown(){
        ReportManager.GenerateReport();
        if(driver != null){
            driver.quit();
        }
    }

    public void InuitTest (String testName){
        extentTest = ReportManager.createTest(testName);
    }

    /**
     *  Report the result
     * @param result
     */
    @AfterMethod
    public void AfterMethod(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            SaveFailueScreenShot(result.getMethod().getMethodName());
        }
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test Failed: " + result.getName(),  ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel("Test Passed: " + result.getName(),  ExtentColor.GREEN));
        }
        else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test Skipped: " + result.getName(),  ExtentColor.YELLOW));
        }
    }

    private void SaveFailueScreenShot(String name){
        // Create folder for screenshot
        File screenShotDirectory = new File("ScreenShots");
        if(!screenShotDirectory.exists()){
            screenShotDirectory.mkdir();
        }

        // Capture + Save
        screenShotManager.CaptureAndSaveScreenShot(name);
    }

}
