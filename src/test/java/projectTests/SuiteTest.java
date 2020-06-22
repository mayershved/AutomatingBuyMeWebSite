package projectTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * this class implements JUnit Suite as a runner
 * to bundle tests classes in one place to run them together
 *
 * @author Mayer Shved
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        //option to test SignIn
        SignInTest.class,

        //option to test SignUp
       // SignUpTest.class,

//        HomeScreenTest.class,
//        GiftCardsScreenTest.class,
//        GiftCardSupplierTest.class,
//        GiftCardReceiverTest.class,
})

public class SuiteTest {
    // This class remains empty, it is used only as a holder for the above annotations
}
