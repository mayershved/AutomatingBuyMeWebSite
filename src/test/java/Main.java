import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import projectTests.SuiteTest;

/**
 * This program implements an application that
 * automate BuyMe WebSite
 *
 * @author  Meir Shved
 */
public class Main {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SuiteTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if(result.wasSuccessful()) {
            System.out.println("BuyMe web site automation test completted successully");
            System.out.println(result.getRunTime());
        }
    }
}
