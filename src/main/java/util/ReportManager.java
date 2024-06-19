package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import net.thucydides.core.reports.ExtendedReport;

public class ReportManager {
    private static ExtentReports reports;

    public static ExtentReports Report()
    {
        var pathLocation = "TestReport.html";
        if(reports == null){
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(pathLocation);
            reports = new ExtentReports();
            reports.attachReporter(sparkReporter);
        }

        return reports;
    }

    public static ExtentTest createTest(String testName){
        return Report().createTest(testName);
    }
}
