package commonMethods;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {

    protected static ExtentReports extentReport;
    protected static ExtentTest testPreconditionsReports;

    private static ProjectConfigData configData = new ProjectConfigData();
    protected static void setExtentReports(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(configData.getExtentReportsFilePath());
        // attach reporter
        extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter);
        // defining name of tests reports and description
        testPreconditionsReports = extentReport.createTest("Test Preparations SetUp", "@BeforeClass , @AfterClass - attached methods");
      //  testOpenBuyMeLogInPageReports = extentReport.createTest("Open BuyMe login page", "Opening BuyMe login page");
        // add custom system info
        extentReport.setSystemInfo("Environment", "Production");
        extentReport.setSystemInfo("Developer", "Mayer Shved");
    }
}
