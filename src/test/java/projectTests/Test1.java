package projectTests;

import commonMethods.ProjectConfigData;
import org.junit.*;
import org.junit.runners.MethodSorters;
import singleton.SingletonDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1 {

    private static SingletonDriver singletonDriver = SingletonDriver.getInstance();

    private ProjectConfigData configData = new ProjectConfigData();

    @BeforeClass
    public static void before(){
        singletonDriver.setProjectDriver();
    }

   @Test
   public void test1(){
    singletonDriver.driver.get(configData.getBuyMeLandingPageUrl());
   }

   @AfterClass
    public static void afterClass(){
        System.out.println("first test is successfull");
   }
}
