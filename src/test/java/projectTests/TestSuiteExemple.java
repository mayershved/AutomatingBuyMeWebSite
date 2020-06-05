package projectTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import projectTests.Test1;
import projectTests.Test2;

@RunWith(Suite.class)
    @Suite.SuiteClasses({
            Test1.class,
            Test2.class,
    })

    public class TestSuiteExemple {
        // This class remains empty, it is used only as a holder for the above annotations
    }
