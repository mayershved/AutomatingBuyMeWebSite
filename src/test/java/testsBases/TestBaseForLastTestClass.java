package testsBases;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Extras;
import commonMethods.ScreenShot;
import commonMethods.UserActions;
import org.junit.AfterClass;
import singleton.SingletonDriver;
import singleton.SingletonReport;

/**
 * Automation to setUp preparations for the
 * last test from suite list,
 * only last test from suite list can extends TestBaseForLastTestClass class
 *
 * annotations @BeforeClass / @Before / @AfterClass
 *
 * @author Meir Shved
 */
public class TestBaseForLastTestClass {

    //instantinate new singletonDriver object, to use common WebDriver
    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    //instantinate new singletonReport object, to use common ExtentReport
    protected static SingletonReport singletonReport = SingletonReport.getInstance();
    // instance of class that implements common project methods
    protected static UserActions userAction = new UserActions();
    // instance of class that implements Extras assignments
    protected static Extras extras = new Extras();

    protected static ScreenShot screenShot = new ScreenShot();
    protected static ExtentTest testReport;

    @AfterClass
    public static void tearDownHomeScreenTest() throws InterruptedException {
        singletonReport.extentReport.flush();
        Thread.sleep(500);
        singletonDriver.driver.quit();
    }
}
