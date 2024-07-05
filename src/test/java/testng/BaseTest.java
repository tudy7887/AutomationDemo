package testng;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import fetraining.actions.CustomerDashBoardActions;
import fetraining.actions.LoginActions;
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

    private String baseTestPropertyFilePath = "D:\\Learning\\SelfLearning\\Training\\src\\test\\resources\\properties\\BaseTest.properties";
    private String pased, failed, skipped;

    @BeforeSuite (alwaysRun = true)
    public void Setup(){
        chrome = new Chrome();
        driver =  chrome.GetChromeDriver();
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

    public void InuitTest (String testName){
        extentTest = ReportManager.createTest(getReportName(), testName);
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
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(failed + result.getName(),  ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(pased + result.getName(),  ExtentColor.GREEN));
        }
        else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(skipped + result.getName(),  ExtentColor.YELLOW));
        }
    }

    protected String getReportName() {
        return "BaseTestReport.html";
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

    private void InitializeProperties(){
        configLoader = new ConfigLoader(baseTestPropertyFilePath);
        failed = configLoader.getProperties("TESTFAILED");
        pased = configLoader.getProperties("TESTPASSED");
        skipped = configLoader.getProperties("TESTSKIPPED");
    }
}
