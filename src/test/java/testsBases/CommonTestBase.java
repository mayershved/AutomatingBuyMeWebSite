package testsBases;

import commonMethods.Extras;
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
    protected static Extras extras;
    protected boolean isClicked;

    @BeforeClass
    public static void testBaseForHomeScreen(){
        singletonReport = SingletonReport.getInstance();
        userAction = new UserActions(singletonDriver.driver);
        extras = new Extras(singletonDriver.driver, singletonReport.extentReport);
    }

    @Before
    public void beforeEachTest(){
        isClicked = false;
    }

    @After
    public void afterEach(){
    }

    @AfterClass
    public static void tearDownHomeScreenTest(){
        singletonReport.extentReport.flush();
    }
}
