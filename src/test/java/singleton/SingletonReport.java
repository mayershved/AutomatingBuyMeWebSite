package singleton;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import commonMethods.ProjectConfigData;

/**
 * SingletonReport class wrapes extentReport instance of ExtentReport class that is used globaly in the project
 */
public class SingletonReport {

    // static variable instance of type SingletonReport
    private static SingletonReport instance = null;

    // instance of ExtentReports class
    public ExtentReports extentReport;

    /**
     * Get instance singleton report.
     *
     * @return the singleton report
     */
// static method to create instance of SingletonReport class
    public static synchronized SingletonReport getInstance(){
        if(instance == null){
            instance = new SingletonReport();
        }
        return instance;
    }

    private static ProjectConfigData configData = new ProjectConfigData();

    /**
     * setExtentReports() method instantinate variable extentReport of ExtentReports class
     */
    public void setExtentReports(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(configData.getExtentReportsFilePath());
        // attach reporter
        extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter);
        // add custom system info
        extentReport.setSystemInfo("Environment", "Production");
        extentReport.setSystemInfo("Developer", "Mayer Shved");
    }
}

