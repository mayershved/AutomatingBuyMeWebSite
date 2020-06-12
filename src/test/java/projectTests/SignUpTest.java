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

/**
 * QA Automation tests for SignUp
 *
 * @author Mayer Shved
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignUpTest extends SignIn_SignUp_TestBase {

    // class fields
    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    private ProjectConfigData configData = new ProjectConfigData();
    private static SignUp signUp = new SignUp();
    private static ExtentTest testReportForSignUp;
    private String url = "https://buyme.co.il/";

    /**
     * create ExtentTest object for SignUp report
     * @result Object of ExtentTest type must be created
     * for SignUp test reports
     */
    @Test
    public void test_01_SetUpExtentTest(){
        testReportForSignUp = userAction.createExtentTest("SingUp new user","Open BuyMe landing page, singUp new user ");
    }

    /**
     * open BuyMe landing page
     * @throws IOException
     */
    @Test
    public void test_02_OpenBuyMeLandingPage() throws IOException {

        userAction.navigateToWebPage(configData.getBuyMeLandingPageUrl());

        if (url.equals(singletonDriver.driver.getCurrentUrl())) {
            testReportForSignUp.log(Status.PASS, "BuyMe landing page it is oppened successfully");
            screenShot.setScreenShotToReportDetails("BuyMe landing page", testReportForSignUp);
        }else {
            testReportForSignUp.log(Status.FAIL, "BuyMe landing page is not oppened");
            screenShot.setScreenShotToReportDetails("BuyMeLandingPage not oppened", testReportForSignUp);
        }
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void test_03_clickSignInSignUp() throws IOException {
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

    /**
     * @result must transfer user to SignUp modal
     * @throws IOException
     */
    @Test
    public void test_04_clickStartSignUp() throws IOException {
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
    public void test_05_inputEnterFirstName() {
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
    public void test_06_inputEnterEmail() {
        try {
            userAction.userInput(signUp.emailAdressElement, configData.getUserEmail());
            isClicked = true;
        }catch(Exception e){
            testReportForSignUp.log(Status.ERROR, "email input failed");
            testReportForSignUp.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForSignUp.log(Status.PASS, "email input is passed");
        }
    }

    @Test
    public void test_07_inputEnterPassword() {

        try{
            userAction.userInput(signUp.PasswordElement, configData.getUserPassword());
            isClicked = true;
        }catch(Exception e){
            testReportForSignUp.log(Status.ERROR, "password input failed");
            testReportForSignUp.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForSignUp.log(Status.PASS, "password input is passed");
        }
    }

    @Test
    public void test_08_inputConfirmPassword() {
        try{
            userAction.userInput(signUp.confirmPasswordElement, configData.getUserPassword());
            isClicked = true;
        }catch (Exception e){
            testReportForSignUp.log(Status.ERROR, "confirm password input failed");
            testReportForSignUp.log(Status.INFO, e.getMessage());
        }finally {
            if (isClicked)
                testReportForSignUp.log(Status.PASS, "confirm password input is passed");
        }
    }

    /**
     * @result must click button to sign in existing user user
     * according to input information
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void test_09_clickSignUpNewUser() throws IOException, InterruptedException {
        screenShot.setScreenShotToReportDetails("user info",testReportForSignUp);
        try{
            userAction.clickElement(signUp.signUpNewUserButton);
            isClicked = true;
        }catch(Exception e){
            testReportForSignUp.log(Status.FAIL, "not succeeded to click button to signUp new user");
            testReportForSignUp.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForSignUp.log(Status.PASS, "signUp button is pressed, new user was signedUp successfully");
        }
        Thread.sleep(2000);
        screenShot.setScreenShotToReportDetails("BuyMe user home page", testReportForSignUp);
    }
}
