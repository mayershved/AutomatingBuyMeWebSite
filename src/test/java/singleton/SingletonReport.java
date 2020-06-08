package singleton;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import commonMethods.ProjectConfigData;

public class SingletonReport {

    private static SingletonReport instance = null;

    public ExtentReports extentReport;

    private SingletonReport(){

    }

    public static synchronized SingletonReport getInstance(){
        if(instance == null){
            instance = new SingletonReport();
        }
        return instance;
    }

    private static ProjectConfigData configData = new ProjectConfigData();

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

