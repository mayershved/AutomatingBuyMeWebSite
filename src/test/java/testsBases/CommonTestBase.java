package testsBases;

import commonMethods.UserActions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import singleton.SingletonDriver;

public class CommonTestBase {

    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    protected static UserActions userAction;

    @BeforeClass
    public static void testBaseForHomeScreen(){
        userAction = new UserActions(singletonDriver.driver);
    }


    @After
    public void afterEach() throws InterruptedException {
        Thread.sleep(100);
    }

    @AfterClass
    public static void tearDownHomeScreenTest() throws InterruptedException {
    Thread.sleep(300);
    }
}
