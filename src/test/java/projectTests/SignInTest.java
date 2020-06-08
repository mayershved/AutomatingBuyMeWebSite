package projectTests;

import commonMethods.ProjectConfigData;
import pageObjects.SignIn;
import org.junit.runners.MethodSorters;
import org.junit.*;
import testsBases.SignIn_SignUp_TestBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignInTest extends SignIn_SignUp_TestBase {

    private static SignIn signIn = new SignIn();
    private ProjectConfigData configData = new ProjectConfigData();

    @Test
    public void test_1_OpenBuyMeLandingPage() {
        userAction.navigateToWebPage(configData.getBuyMeLandingPageUrl());
    }

    @Test
    public void test_2_ClickSignIn(){
        userAction.clickElement(signIn.signUpSignInButton);
    }

    @Test
    public void test_5_EnterEmail() {
        userAction.userInput(signIn.emailAdressElement, configData.getUserEmail());
    }

    @Test
    public void test_6_EnterPassword() {
        userAction.userInput(signIn.passwordElement, configData.getUserPassword());
    }

    @Test
    public void test_8_SubmitUser() {
        userAction.clickElement(signIn.signInUserButton);
    }
}