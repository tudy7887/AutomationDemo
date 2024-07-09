package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ReportManager {
    private static ExtentReports reports;

    public static ExtentReports Report(String reportName)
    {
        var pathLocation = new File("Results" , reportName).getPath();
        if(reports == null){
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(pathLocation);
            reports = new ExtentReports();
            reports.attachReporter(sparkReporter);
        }

        return reports;
    }

    public static ExtentTest CreateTest(String reportName, String testName){
        return Report(reportName).createTest(testName);
    }

    public static void GenerateReport(){
        reports.flush();
    }
}
