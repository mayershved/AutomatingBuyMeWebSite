package testsBases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.UserActions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import singleton.SingletonDriver;
import singleton.SingletonReport;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

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
            singletonDriver.driver.manage().window().maximize();
            singletonDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            establishedDriver = ((RemoteWebDriver) singletonDriver.driver).getCapabilities().getBrowserName().toLowerCase();
            testReportsForWebDriverSetUp.log(Status.INFO, "in this project it is used " +establishedDriver+" webDriver");
            isDriverEstablished = true;
        } catch (Exception e) {
            e.printStackTrace();
            fail("Cant connect to"+" "+establishedDriver);
            testReportsForWebDriverSetUp.log(Status.FATAL, establishedDriver +" "+"driver Connection Failed! " + e.getMessage());
            isDriverEstablished = false;
        } finally {
            if (isDriverEstablished) {
                testReportsForWebDriverSetUp.log(Status.PASS, establishedDriver +" "+"driver established successfully");
            }
        }
        userAction = new UserActions(singletonDriver.driver);
    }

    @After
    public void afterEach() throws InterruptedException {
        isClicked = false;
        Thread.sleep(100);
    }

    @AfterClass
    public static void tearDown_SignIn_SignUp_Test() throws InterruptedException {
        singletonReport.extentReport.flush();
        Thread.sleep(300);
    }
}
