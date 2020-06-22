package testsBases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.Extras;
import commonMethods.ProjectConfigData;
import commonMethods.ScreenShot;
import commonMethods.UserActions;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import singleton.SingletonDriver;
import singleton.SingletonReport;

/**
 * QA Automation to setUp preparations for
 * SignIn, SignUp tests included to Suite test,
 * only first test from suite list can extend from SignIn_SignUp_TestBase class
 *
 * annotations @BeforeClass / @Before / @AfterClass
 *
 * @author Mayer Shved
 */
public class SignIn_SignUp_TestBase {

    //class fields
    //for each class that extends SignIn_SignUp_TestBase class

    //instantinate new singletonDriver object, to use common WebDriver
    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    //instantinate new singletonReport object, to use common ExtentReport
    protected static SingletonReport singletonReport = SingletonReport.getInstance();


    // instances that implements generic project methods
    protected static ProjectConfigData configData = new ProjectConfigData();
    protected static ScreenShot screenShot;
    protected static UserActions userAction;
    protected static ExtentTest testReport;
    protected static Extras extras;


    protected static boolean isClicked = false;

    /**
     * this method sets WebDriver that will be used
     * in the project
     */
    @BeforeClass
    public static void testBaseFor_SignIn_SignUp(){

        String establishedDriver = null;
        boolean isDriverEstablished = false;

        singletonReport.setExtentReports();

        testReport = singletonReport.extentReport.createTest("WebDriver SetUp",
                "SetUp WebDriver for the project");

        try {
            singletonDriver.setProjectDriver();
            establishedDriver = ((RemoteWebDriver) singletonDriver.driver).getCapabilities().getBrowserName().toLowerCase();
            testReport.log(Status.INFO, "In this project it is used " +establishedDriver+" WebDriver");
            isDriverEstablished = true;
        } catch (Exception e) {
            e.printStackTrace();
            testReport.log(Status.FATAL, establishedDriver +" "+"WebDriver Connection Failed! ");
            testReport.log(Status.INFO, e.getMessage());
            isDriverEstablished = false;
        } finally {
            if (isDriverEstablished) {
                testReport.log(Status.PASS, establishedDriver +" "+"WebDriver established successfully");
            }
        }
        userAction = new UserActions(singletonDriver.driver, singletonReport.extentReport);
        screenShot = new ScreenShot(singletonDriver.driver);
        extras = new Extras(singletonDriver.driver, singletonReport.extentReport);
    }

    @Before
    public void beforeEachTest(){
        isClicked = false;
    }

    @AfterClass
    public static void tearDown_SignIn_SignUp_Test() throws InterruptedException {
        Thread.sleep(1000);
        singletonReport.extentReport.flush();
    }
}
