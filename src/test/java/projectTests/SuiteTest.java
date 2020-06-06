package projectTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import projectTests.giftCardTests.GiftCardSupplierTest;
import projectTests.signInTest.SignInTest;
import projectTests.giftCardTests.GiftCardsScreenTest;
import projectTests.homeScreenTest.HomeScreenTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        SignInTest.class,
        HomeScreenTest.class,
        GiftCardsScreenTest.class,
        GiftCardSupplierTest.class,
})

public class SuiteTest {
    // This class remains empty, it is used only as a holder for the above annotations
}
