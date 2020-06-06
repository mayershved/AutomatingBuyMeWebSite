package projectTests.giftCardTests;

import commonMethods.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import singleton.SingletonDriver;

public class GiftCardsBaseForTest {

    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    protected static UserActions userAction;

    @BeforeClass
    public static void testBaseForHomeScreen() throws InterruptedException {
        Thread.sleep(300);
        userAction = new UserActions(singletonDriver.driver);
        System.out.println("before class gift");
    }

    @AfterClass
    public static void tearDownHomeScreenTest(){
    }
}
