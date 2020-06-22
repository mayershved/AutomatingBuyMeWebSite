package testsBases;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Extras;
import commonMethods.ScreenShot;
import commonMethods.UserActions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import singleton.SingletonDriver;
import singleton.SingletonReport;

/**
 * QA Automation to setUp preparations for tests
 * included to Suite test,
 * first test and last test from Suite
 * do not extends CommonTestBase
 * annotations @BeforeClass / @Before / @AfterClass
 *
 * @author Mayer Shved
 */
public class CommonTestBase {

    //class fields
    //tests preparetions for each class that extends CommonTestBase class,

    //instantinate new singletonDriver object, to use common WebDriver
    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    //instantinate new singletonReport object, to use common ExtentReport
    protected static SingletonReport singletonReport = SingletonReport.getInstance();

    // instance of class that implements generic project methods
    protected static UserActions userAction = new UserActions(singletonDriver.driver,singletonReport.extentReport);
    protected static ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    protected static Extras extras = new Extras(singletonDriver.driver, singletonReport.extentReport);
    protected static ExtentTest testReport;

    protected boolean isClicked;

    @Before
    public void beforeEachTest(){
        isClicked = false;
    }

    @AfterClass
    public static void tearDownHomeScreenTest(){
        singletonReport.extentReport.flush();
    }
}
