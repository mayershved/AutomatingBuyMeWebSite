package projectTests;

import com.aventstack.extentreports.Status;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.SignUp;
import testsBases.CommonTestBase;
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
    private static SignUp signUp = new SignUp();
    private String url = "https://buyme.co.il/";

    /**
     * create ExtentTest object for SignUp report
     * @result Object of ExtentTest type must be created
     * for SignUp test reports
     */
    @Test
    public void test_01_CreateTestReportForSignUp(){
        testReport = userAction.createExtentTest("SingUp new user","Open BuyMe landing page, singUp new user ");
    }

    /**
     * open BuyMe landing page
     * @throws IOException
     */
    @Test
    public void test_02_OpenBuyMeLandingPage() throws IOException, InterruptedException {
        userAction.navigateToWebPage(configData.getBuyMeLandingPageUrl());
        if (url.equals(singletonDriver.driver.getCurrentUrl())) {
            testReport.log(Status.PASS, "BuyMe landing page it is oppened successfully");
            Thread.sleep(2000);
            screenShot.setScreenShotToReportDetails("BuyMe landing page", testReport);
        }else {
            testReport.log(Status.FAIL, "BuyMe landing page is not oppened");
            screenShot.setScreenShotToReportDetails("BuyMeLandingPage not oppened", testReport);
        }
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void test_03_clickSignInSignUp() throws IOException {
        userAction.clickElement(signUp.signInSignUpButton);
    }

    /**
     * @result must transfer user to SignUp modal
     * @throws IOException
     */
    @Test
    public void test_04_clickStartSignUp() throws IOException {
        try{
            userAction.clickElement(signUp.startSignUp);
            testReport.log(Status.PASS, "StartSignUp button was clicked");
            screenShot.setScreenShotToReportDetails("SignUp Modal", testReport);
        }catch(Exception e) {
            testReport.log(Status.ERROR, "StartSignUp button was not clicked");
            testReport.log(Status.INFO, e.getMessage());
        }
    }

    @Test
    public void test_05_inputEnterFirstName() {
        userAction.userInput(signUp.firstNameElement, configData.getUserFirstName());
    }

    @Test
    public void test_06_inputEnterEmail() {
        userAction.userInput(signUp.emailAdressElement, configData.getUserEmail());
    }

    @Test
    public void test_07_inputEnterPassword() {
        userAction.userInput(signUp.PasswordElement, configData.getUserPassword());
    }

    @Test
    public void test_08_inputConfirmPassword() {
        userAction.userInput(signUp.confirmPasswordElement, configData.getUserPassword());
    }

    /**
     * @result must click button to sign in existing user user
     * according to input information
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void test_09_clickSignUpNewUser() throws IOException, InterruptedException {
        try{
            userAction.clickElement(signUp.signUpNewUserButton);
            testReport.log(Status.PASS, "signUp button is pressed, new user was signedUp successfully");
            Thread.sleep(2000);
            screenShot.setScreenShotToReportDetails("BuyMe user home page", testReport);
        }catch(Exception e){
            testReport.log(Status.FAIL, "not succeeded to click button to signUp new user");
            testReport.log(Status.INFO, e.getMessage());
        }
    }
}
