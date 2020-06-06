package projectTests.giftCardTests;

import commonMethods.UserActions;
import org.junit.BeforeClass;
import singleton.SingletonDriver;

public class GiftCardSupplierBaseForTest {

    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    protected static UserActions userActions;

    @BeforeClass
    public static void testBaseForGiftCardSupplier(){
        userActions = new UserActions(singletonDriver.driver);
    }
}
