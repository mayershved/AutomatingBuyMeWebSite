package projectTests;

import commonMethods.ProjectConfigData;
import pageObjects.SignInScreen;
import org.junit.runners.MethodSorters;
import org.junit.*;
import testsBases.SignInBaseForTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignInTest extends SignInBaseForTest {

    private static SignInScreen signIn = new SignInScreen();
    private ProjectConfigData configData = new ProjectConfigData();

    @Test
    public void test_1_OpenBuyMeLandingPage() {
        userAction.navigateToWebPage(configData.getBuyMeLandingPageUrl());
    }

    @Test
    public void test_2_ClickSignIn(){
        userAction.clickElement(signIn.signInButton);
    }

//    @Test
//    public void test_3_StartSignIn() {
//        userAction.clickElement(signIn.startSignIn);
//    }

//    @Test
//    public void test_4_EnterFirstName() {
//        userAction.userInput(signIn.firstNameElement, configData.getUserFirstName());
//    }

    @Test
    public void test_5_EnterEmail() {
        userAction.userInput(signIn.emailAdressElement, configData.getUserEmail());
    }

    @Test
    public void test_6_EnterPassword() {
        userAction.userInput(signIn.sPasswordElement, configData.getUserPassword());
    }

//    @Test
//    public void test_6_EnterPassword() {
//        userAction.userInput(signIn.passwordElement, configData.getUserPassword());
//    }

//    @Test
//    public void test_7_ConfirmPassword() {
//        userAction.userInput(signIn.confirmPasswordElement, configData.getUserPassword());
//    }

    @Test
    public void test_8_SubmitUser() {
        userAction.clickElement(signIn.submitButton);
    }
}