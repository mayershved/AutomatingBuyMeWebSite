package projectTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pageObjects.SignIn;
import pageObjects.SignUp;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SignUpTest.class,
//        HomeScreenTest.class,
//        GiftCardsScreenTest.class,
//        GiftCardSupplierTest.class,
//        GiftCardReceiverTest.class,
//        GiftCardReceiverConfirmTest.class,
})

public class SuiteTest {
    // This class remains empty, it is used only as a holder for the above annotations
}
