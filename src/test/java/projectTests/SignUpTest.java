package projectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.ProjectConfigData;
import commonMethods.ScreenShot;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.SignUp;
import testsBases.SignIn_SignUp_TestBase;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignUpTest extends SignIn_SignUp_TestBase {

    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    private ProjectConfigData configData = new ProjectConfigData();
    private static SignUp signUp = new SignUp();

    protected static ExtentTest testReportForSignUp;
    private String url = "https://buyme.co.il/";

    @Test
    public void test_0_SetUpExtentTest(){
        testReportForSignUp = singletonReport.extentReport
                .createTest("SingUp new user", "open BuyMeLandingPage, singUp new user ");
    }

    @Test
    public void test_1_OpenBuyMeLandingPage() throws IOException {

        userAction.navigateToWebPage(configData.getBuyMeLandingPageUrl());

        if (url.equals(singletonDriver.driver.getCurrentUrl())) {
            testReportForSignUp.log(Status.PASS, "BuyMe landing page is oppened");
            screenShot.setScreenShotToReportDetails("BuyMeLandingPage", testReportForSignUp);
        }else {
            testReportForSignUp.log(Status.FAIL, "BuyMe landing page is not oppened");
            screenShot.setScreenShotToReportDetails("BuyMeLandingPage", testReportForSignUp);
        }
    }

    @Test
    public void test_2_ClickSignInSignUp() throws IOException {
        try{
            userAction.clickElement(signUp.signInSignUpButton);
            isClicked = true;
        }catch(Exception e){
            testReportForSignUp.log(Status.ERROR, "SignInSignUp button was not clicked");
            testReportForSignUp.log(Status.INFO, e.getMessage());
        }finally {
            if (isClicked)
                testReportForSignUp.log(Status.PASS, "SignInSignUp button was clicked");
                screenShot.setScreenShotToReportDetails("SignIn Modal", testReportForSignUp);
        }
    }

    @Test
    public void test_3_StartSignUp() throws IOException {
        try{
            userAction.clickElement(signUp.startSignUp);
            isClicked  = true;
        }catch(Exception e) {
            testReportForSignUp.log(Status.ERROR, "StartSignUp button was not clicked");
            testReportForSignUp.log(Status.INFO, e.getMessage());
        }finally {
            if (isClicked)
                testReportForSignUp.log(Status.PASS, "StartSignUp button was clicked");
                screenShot.setScreenShotToReportDetails("SignUp Modal", testReportForSignUp);
        }
    }

    @Test
    public void test_4_EnterFirstName() {
        try{
            userAction.userInput(signUp.firstNameElement, configData.getUserFirstName());
            isClicked = true;
        }catch(Exception e){
            testReportForSignUp.log(Status.ERROR, "user name input failed");
            testReportForSignUp.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForSignUp.log(Status.PASS, "user name input is passed");
        }
    }

    @Test
    public void test_5_EnterEmail() {
        try {
            userAction.userInput(signUp.emailAdressElement, configData.getUserEmail());
            isClicked = true;
        }catch(Exception e){
            testReportForSignUp.log(Status.ERROR, "email input failed");
            testReportForSignUp.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForSignUp.log(Status.PASS, "user email input is passed");
        }
    }

    @Test
    public void test_6_EnterPassword() {

        try{
            userAction.userInput(signUp.PasswordElement, configData.getUserPassword());
            isClicked = true;
        }catch(Exception e){
            testReportForSignUp.log(Status.ERROR, "password input failed");
            testReportForSignUp.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForSignUp.log(Status.PASS, "user password input is passed");
        }
    }


    @Test
    public void test_7_ConfirmPassword() {
        try{
            userAction.userInput(signUp.confirmPasswordElement, configData.getUserPassword());
            isClicked = true;
        }catch (Exception e){

        }finally {
            if (isClicked)
                testReportForSignUp.log(Status.PASS, "user confirm password input is passed");
        }
    }

    @Test
    public void test_8_SignUpNewUser() throws IOException {
        screenShot.setScreenShotToReportDetails("user info",testReportForSignUp);
        try{
            userAction.clickElement(signUp.signUpNewUserButton);
            isClicked = true;
        }catch(Exception e){
            testReportForSignUp.log(Status.FAIL, "not succeeded to click button to signUp new user");
            testReportForSignUp.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForSignUp.log(Status.PASS, "new user was signedUp succesfully");
                screenShot.setScreenShotToReportDetails("BuyMe landing page", testReportForSignUp);
        }
    }
}
