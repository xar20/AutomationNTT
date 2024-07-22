package utile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getInstance(){
        if (extentReports == null)
        {
            String reportName = "test-report.html";
            ExtentSparkReporter SparkReporter = new ExtentSparkReporter(reportName);
            extentReports = new ExtentReports();
            extentReports.attachReporter(SparkReporter);

            ////added by Calpagiu Raul
            //configuration items to change the look and feel
            //add content, manage tests etc
            SparkReporter.config().setDocumentTitle("Simple Automation Report");
            SparkReporter.config().setReportName("Test Report");
            SparkReporter.config().setTheme(Theme.STANDARD);
            SparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        }
        return extentReports;
    }
    public static ExtentTest createTest(String testName)
    {
        return getInstance().createTest(testName);
    }
}
