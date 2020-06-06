package projectTests.signInTest;

import commonMethods.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import singleton.SingletonDriver;

public class SignInBaseForTest {

    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    protected static UserActions userAction;

    @BeforeClass
    public static void testBaseForSignIScreen(){
        singletonDriver.setProjectDriver();
        userAction = new UserActions(singletonDriver.driver);
    }

    @AfterClass
    public static void tearDownSignInTest(){

    }
}
