package testsBases;

import commonMethods.Extras;
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
    protected static SingletonReport singletonReport;
    // instance of class that implements generic project methods
    protected static UserActions userAction;
    // instance of class that implements Extras assignments
    protected static Extras extras;
    protected boolean isClicked;

    @BeforeClass
    public static void testBaseForHomeScreen(){
        //instance for global ExtentReport
        singletonReport = SingletonReport.getInstance();
        userAction = new UserActions(singletonDriver.driver,singletonReport.extentReport);
        extras = new Extras(singletonDriver.driver, singletonReport.extentReport);
    }

    @Before
    public void beforeEachTest(){
        isClicked = false;
    }

    @AfterClass
    public static void tearDownHomeScreenTest(){
        singletonReport.extentReport.flush();
    }
}
