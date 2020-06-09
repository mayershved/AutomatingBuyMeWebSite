package testsBases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.UserActions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import singleton.SingletonDriver;
import singleton.SingletonReport;

public class SignIn_SignUp_TestBase {

    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    protected static SingletonReport singletonReport = SingletonReport.getInstance();
    private static ExtentTest testReportsForWebDriverSetUp;
    protected static UserActions userAction;

    protected static boolean isClicked = false;

    @BeforeClass
    public static void testBaseFor_SignIn_SignUp(){

        String establishedDriver = null;
        boolean isDriverEstablished = false;

        singletonReport.setExtentReports();

        testReportsForWebDriverSetUp = singletonReport.extentReport.createTest("WebDriver SetUp",
                "SetUp WebDriver for the project");

        try {
            singletonDriver.setProjectDriver();
            establishedDriver = ((RemoteWebDriver) singletonDriver.driver).getCapabilities().getBrowserName().toLowerCase();
            testReportsForWebDriverSetUp.log(Status.INFO, "In this project it is used " +establishedDriver+" WebDriver");
            isDriverEstablished = true;
        } catch (Exception e) {
            e.printStackTrace();
            testReportsForWebDriverSetUp.log(Status.FATAL, establishedDriver +" "+"WebDriver Connection Failed! ");
            testReportsForWebDriverSetUp.log(Status.INFO, e.getMessage());
            isDriverEstablished = false;
        } finally {
            if (isDriverEstablished) {
                testReportsForWebDriverSetUp.log(Status.PASS, establishedDriver +" "+"WebDriver established successfully");
            }
        }
        userAction = new UserActions(singletonDriver.driver);
    }

    @Before
    public void beforeEachTest(){
        isClicked = false;
    }

    @After
    public void afterEach(){
    }

    @AfterClass
    public static void tearDown_SignIn_SignUp_Test(){
        singletonReport.extentReport.flush();
    }
}
