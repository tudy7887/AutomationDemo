package stepdefs;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.extension.ExtensionContext;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import util.ConfigLoader;
import util.ReportManager;
import util.ScreenShotManager;
import webdriver.Chrome;
import java.io.File;

public class BaseStepDef implements TestWatcher {
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

    public void Setup(){
        chrome = new Chrome();
        driver =  chrome.GetChromeDriver();
        screenShotManager = new ScreenShotManager(driver);
        InitializeProperties();
    }

    public void Teardown(){
        ReportManager.GenerateReport();
        if(driver != null){
            driver.quit();
        }
    }

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
        AddScreenshot(extensionContext.getDisplayName(), skipped);
        extentTest.log(Status.SKIP, MarkupHelper.createLabel(skipped + extensionContext.getDisplayName(),  ExtentColor.YELLOW));
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        AddScreenshot(extensionContext.getDisplayName(), failed);
        extentTest.log(Status.FAIL, MarkupHelper.createLabel(failed + extensionContext.getDisplayName(),  ExtentColor.RED));
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        extentTest.log(Status.PASS, MarkupHelper.createLabel(failed + extensionContext.getDisplayName(),  ExtentColor.GREEN));
    }

    // Asserts
    protected void HardAssertEqual(Object actualResult, Object expectedResult, String errorMessage){
        var name = "ACTUAL vs EXPECTED";
        var description = String.format("ACTUAL: %s <br> EXPECTED: %s", actualResult, expectedResult);
        AddScreenshot(name, description);
        assertEquals(actualResult, expectedResult, errorMessage);
    }
    protected void HardAssertTrue(boolean condition, String errorMessage){
        var name = "EXPECTED TRUE";
        AddScreenshot(name, name);
        assertTrue(condition, errorMessage);
    }
    protected void HardAssertFalse(boolean condition, String errorMessage){
        var name = "EXPECTED FALSE";
        AddScreenshot(name, name);
        assertFalse(condition, errorMessage);
    }
    protected void SoftAssertEqual(Object actualResult, Object expectedResult, String errorMessage){
        var softAssert =  new SoftAssert();
        var name = "ACTUAL vs EXPECTED";
        var description = String.format("ACTUAL: %s <br> EXPECTED: %s", actualResult, expectedResult);
        AddScreenshot(name, description);
        softAssert.assertEquals(actualResult, expectedResult, errorMessage);
        softAssert.assertAll();
    }
    protected void SoftAssertTrue(boolean condition, String errorMessage){
        var softAssert =  new SoftAssert();
        var name = "EXPECTED TRUE";
        AddScreenshot(name, name);
        softAssert.assertTrue(condition, errorMessage);
        softAssert.assertAll();
    }
    protected void SoftAssertFalse(boolean condition, String errorMessage){
        var softAssert =  new SoftAssert();
        var name = "EXPECTED FALSE";
        AddScreenshot(name, name);
        softAssert.assertFalse(condition, errorMessage);
        softAssert.assertAll();
    }

    protected void AddScreenshot(String name, String description){
        var screenShotFile = SaveScreenShot(name);
        extentTest.addScreenCaptureFromPath(screenShotFile.getPath(), description);
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
