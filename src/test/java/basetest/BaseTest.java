package basetest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import util.ConfigLoader;
import util.ReportManager;
import util.ScreenShotManager;
import webdriver.Chrome;

import java.io.File;

public class BaseTest {
    private Chrome chrome;
    protected WebDriver driver;
    private ExtentTest extentTest;
    private ScreenShotManager screenShotManager;
    protected ConfigLoader configLoader;

    private String baseTestPropertyFilePath = "src/test/resources/properties/BaseTest.properties";
    private String pased, failed, skipped;

    public void InuitTest (String testName){
        extentTest = ReportManager.CreateTest(GetReportName(), testName);
    }

    @BeforeSuite (alwaysRun = true)
    public void Setup(){
        chrome = new Chrome();
        driver =  chrome.GetChromeDriver();
        driver.manage().window().maximize();
        screenShotManager = new ScreenShotManager(driver);
        InitializeProperties();
    }

    @AfterSuite (alwaysRun = true)
    public void Teardown(){
        ReportManager.GenerateReport();
        if(driver != null){
            driver.quit();
        }
    }

    @AfterMethod
    public void AfterMethod(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            AddScreenshot(result.getMethod().getMethodName(), failed);
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(failed + result.getName(),  ExtentColor.RED));
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(pased + result.getName(),  ExtentColor.GREEN));
        }
        else {
            AddScreenshot(result.getMethod().getMethodName(), skipped);
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(skipped + result.getName(),  ExtentColor.YELLOW));
        }
    }

    // Asserts
    protected void HardAssertEqual(Object actualResult, Object expectedResult, String errorMessage){
        var name = "ACTUAL vs EXPECTED";
        var description = String.format("ACTUAL: %s <br> EXPECTED: %s", actualResult, expectedResult);
        AddScreenshot(name, description);
        Assert.assertEquals(actualResult, expectedResult, errorMessage);
    }
    protected void HardAssertTrue(boolean condition, String errorMessage, String description){
        var name = String.format("EXPECTED TRUE %s", description);
        AddScreenshot(name, description);
        Assert.assertTrue(condition, errorMessage);
    }
    protected void HardAssertFalse(boolean condition, String errorMessage, String description){
        var name = String.format("EXPECTED FALSE %s", description);
        AddScreenshot(name, description);
        Assert.assertFalse(condition, errorMessage);
    }
    protected void SoftAssertEqual(Object actualResult, Object expectedResult, String errorMessage){
        var softAssert =  new SoftAssert();
        var name = "ACTUAL vs EXPECTED";
        var description = String.format("ACTUAL: %s <br> EXPECTED: %s", actualResult, expectedResult);
        AddScreenshot(name, description);
        softAssert.assertEquals(actualResult, expectedResult, errorMessage);
        softAssert.assertAll();
    }
    protected void SoftAssertTrue(boolean condition, String errorMessage, String description){
        var softAssert =  new SoftAssert();
        var name = String.format("EXPECTED TRUE %s", description);
        AddScreenshot(name, description);
        softAssert.assertTrue(condition, errorMessage);
        softAssert.assertAll();
    }
    protected void SoftAssertFalse(boolean condition, String errorMessage, String description){
        var softAssert =  new SoftAssert();
        var name = String.format("EXPECTED FALSE %s", description);
        AddScreenshot(name, description);
        softAssert.assertFalse(condition, errorMessage);
        softAssert.assertAll();
    }

    protected void AddScreenshot(String name, String description){
        var screenShotFile = SaveScreenShot(name);
        extentTest.addScreenCaptureFromPath(screenShotFile.getPath(), description);
        AddDetails(description);
    }

    protected void AddDetails(String details){
        extentTest.log(Status.INFO, details);
    }

    protected String GetReportName() {
        return "BaseTestReport.html";
    }

    private File SaveScreenShot(String name){
        // Create folder for screenshot
        File screenShotDirectory = new File("Results/ScreenShots");
        if(!screenShotDirectory.exists()){
            screenShotDirectory.mkdir();
        }
        // Capture + Save
        return screenShotManager.CaptureAndSaveScreenShot(name);
    }

    private void InitializeProperties(){
        configLoader = new ConfigLoader(baseTestPropertyFilePath);
        failed = configLoader.GetProperties("TESTFAILED");
        pased = configLoader.GetProperties("TESTPASSED");
        skipped = configLoader.GetProperties("TESTSKIPPED");
    }
}
