package testsBases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.Extras;
import commonMethods.ProjectConfigData;
import commonMethods.ScreenShot;
import commonMethods.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import singleton.SingletonDriver;
import singleton.SingletonReport;

/**
 * Automation to setUp preparations for
 * SignIn, SignUp tests included to Suite test,
 * only first test from suite list can extend from SignIn_SignUp_TestBase class
 *
 * annotations @BeforeClass / @Before / @AfterClass
 *
 * @author Meir Shved
 */
public class SignIn_SignUp_TestBase {

    //instantinate new singletonDriver object, to use common WebDriver
    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    //instantinate new singletonReport object, to use common ExtentReport
    protected static SingletonReport singletonReport = SingletonReport.getInstance();

    // instances that implements common project methods
    protected static ProjectConfigData configData = new ProjectConfigData();
    protected static ScreenShot screenShot;
    protected static UserActions userAction;
    protected static ExtentTest testReport;
    protected static Extras extras;

    /**
     * this method sets WebDriver that will be used
     * in the project
     */
    @BeforeClass
    public static void testBaseFor_SignIn_SignUp(){

        String establishedDriver = null;
        singletonReport.setExtentReports();

        testReport = singletonReport.extentReport.createTest("WebDriver SetUp",
                "SetUp WebDriver for the project");
        try {
            singletonDriver.setProjectDriver();
            establishedDriver = ((RemoteWebDriver) singletonDriver.driver).getCapabilities().getBrowserName().toLowerCase();
            testReport.log(Status.INFO, "In this project it is used " +establishedDriver+" WebDriver");
            testReport.log(Status.PASS, establishedDriver + " driver is set successfully");
        } catch (Exception e) {
            e.printStackTrace();
            testReport.log(Status.FATAL, establishedDriver +" "+"WebDriver Connection Failed! ");
            testReport.log(Status.INFO, e.getMessage());
        }

        userAction = new UserActions();
        screenShot = new ScreenShot();
        extras = new Extras();
    }

    @AfterClass
    public static void tearDown_SignIn_SignUp_Test() throws InterruptedException {
        Thread.sleep(1000);
        singletonReport.extentReport.flush();
    }
}
