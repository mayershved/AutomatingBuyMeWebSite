package testsBases;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.UserActions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import singleton.SingletonDriver;
import singleton.SingletonReport;

public class CommonTestBase {

    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    protected static SingletonReport singletonReport;
    protected static UserActions userAction;
    protected boolean isClicked;

    @BeforeClass
    public static void testBaseForHomeScreen(){
        singletonReport = SingletonReport.getInstance();
        userAction = new UserActions(singletonDriver.driver);
    }

    @Before
    public void beforeEach()  {
        isClicked = false;
    }

    @After
    public void afterEach() throws InterruptedException {
        Thread.sleep(100);
    }

    @AfterClass
    public static void tearDownHomeScreenTest() throws InterruptedException {
    Thread.sleep(300);
    singletonReport.extentReport.flush();
    }
}
