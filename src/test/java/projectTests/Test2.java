package projectTests;

import commonMethods.ProjectConfigData;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import singleton.SingletonDriver;

public class Test2 {

    private static SingletonDriver singletonDriver;

    private ProjectConfigData configData = new ProjectConfigData();

    @BeforeClass
    public static void before() throws InterruptedException {
        singletonDriver = SingletonDriver.getInstance();
        Thread.sleep(5000);
    }

    @Test
    public void test2(){
        By signInButton = By.cssSelector(".seperator-link");
        singletonDriver.driver.findElement(signInButton).click();
        System.out.println("second test is successfull");
    }
}
