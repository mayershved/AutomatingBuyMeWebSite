package projectTests;

import commonMethods.ProjectConfigData;
import pageObjects.SignInScreen;
import org.junit.runners.MethodSorters;
import org.junit.*;
import singleton.SingletonDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignInTest  {

    private static SingletonDriver singletonDriver = SingletonDriver.getInstance();
    private static SignInScreen signIn;
    private ProjectConfigData configData = new ProjectConfigData();

    @BeforeClass
    public static void beforeClass() {
        singletonDriver.setProjectDriver();
        signIn = new SignInScreen(singletonDriver.driver);
    }

    @Test
    public void test_1_OpenBuyMeLandingPage() {
        signIn.navigateToWebPage(configData.getBuyMeLandingPageUrl());
        System.out.println("test_1_OpenBuyMeLandingPage completted successully");
    }

    @Test
    public void test_2_ClickSignIn() throws InterruptedException {
        signIn.clickElement(signIn.signInButton);
        System.out.println("test_2_ClickSignIn completted successully");
    }
//
////    @Test
////    public void test_3_StartSignIn() {
////        signIn.clickElement(startSignIn);
////        System.out.println("test_3_StartSignIn completted successully");
////    }
//
//    @Test
//    public void test_4_EnterFirstName() {
//        signIn.userInput(firstNameElement, configData.getUserFirstName());
//        System.out.println("test_4_EnterFirstName completted successully");
//    }
//
    @Test
    public void test_5_EnterEmail() {
        signIn.userInput(signIn.emailAdressElement, configData.getUserEmail());
        System.out.println("test_5_EnterEmail completted successully");
    }

    @Test
    public void test_6_EnterPassword() {
        signIn.userInput(signIn.sPasswordElement, configData.getUserPassword());
        System.out.println("test_6_EnterPassword completted successully");
    }


//
//    @Test
//    public void test_6_EnterPassword() {
//        signIn.userInput(passwordElement, configData.getUserPassword());
//        System.out.println("test_6_EnterPassword completted successully");
//    }
//
//    @Test
//    public void test_7_ConfirmPassword() {
//        signIn.userInput(confirmPasswordElement, configData.getUserPassword());
//        System.out.println("test_7_ConfirmPassword completted successully");
//    }
//
    @Test
    public void test_8_SubmitUser() {
        signIn.clickElement(signIn.submitButton);
        System.out.println("test_8_SubmitUser completted successully");
    }
}