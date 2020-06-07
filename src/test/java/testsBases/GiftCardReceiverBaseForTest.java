package testsBases;

import commonMethods.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import singleton.SingletonDriver;

public class GiftCardReceiverBaseForTest {

    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    protected static UserActions userAction;

    @BeforeClass
    public static void testBaseForGiftCardReceiver() throws InterruptedException {
        Thread.sleep(300);
        userAction = new UserActions(singletonDriver.driver);
    }

    @AfterClass
    public static void tearDownGiftCardReceiverTest(){
    }

}
