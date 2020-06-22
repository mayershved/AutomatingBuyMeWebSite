package projectTests;

import com.aventstack.extentreports.Status;
import pageObjects.SignIn;
import org.junit.runners.MethodSorters;
import org.junit.*;
import testsBases.CommonTestBase;
import testsBases.SignIn_SignUp_TestBase;

import java.io.IOException;

/**
 * QA Automation tests for SignIn
 *
 * @author Mayer Shved
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignInTest extends SignIn_SignUp_TestBase {

    //class fields
    private static SignIn signIn = new SignIn();
    private String url = "https://buyme.co.il/";

    /**
     * sets ExtentTest object for SignIn report
     * @result Object of ExtentTest type must be created
     * for SignIn test reports
     */
    @Test
    public void test_01_SetUpSignInExtentTest() {
        testReport = userAction.createExtentTest
                ("SingIn existing user",
                "open BuyMeLandingPage, signIn existing user ");
    }

    /**
     * sets ExtentTest object for Extras assignments report
     * @result Object of ExtentTest type must be created
     * for  Extras assignments test reports
     */
    @Test
    public void test_02_ExtrasReports(){
        extras.setExtrasTestReports("Extras for SignIn Screen", "assert error messages");
    }


    @Test
    public void test_03_OpenBuyMeLandingPage() throws IOException, InterruptedException {
        userAction.navigateToWebPage(configData.getBuyMeLandingPageUrl());
        if (url.equals(singletonDriver.driver.getCurrentUrl())) {
            testReport.log(Status.PASS, "BuyMe landing page is oppened");
            Thread.sleep(2000);
            screenShot.setScreenShotToReportDetails("BuyMe landing page", testReport);
        } else {
            testReport.log(Status.FAIL, "BuyMe landing page is not opened");
            screenShot.setScreenShotToReportDetails("BuyMe landing page is not opened", testReport);
            System.exit(-1);
        }
    }

    /**
     * @result open SignIn modal
     * @throws IOException
     */
    @Test
    public void test_04_clickSignInSignUp() throws IOException {
        userAction.clickElement(signIn.signUpSignInButton);
        screenShot.setScreenShotToReportDetails("signIn modal",testReport);
    }

    /**
     * get error mesages / Extras asignments
     * @throws IOException
     */
    @Test
    public void test_05_clickSignInUserToGetErrorsForExtras() throws IOException {
        clickButtonToSignInUser();
        extras.getTestReportsForExtras().log(Status.FAIL, "missing user email and password");
        screenShot.setScreenShotToReportDetails("error messages",extras.getTestReportsForExtras());
    }

    @Test
    public void test_06_setWebElementsForEmailPasswordAsserts(){
        extras.setListOfWebElements(extras.emptyEmailAndPasswordWarning);
    }

    /**
     * assert message error for non email input
     * @result assertion pass
     */
    @Test
    public void test_07_assertEmailErrorMessage() {
        Assert.assertEquals(extras.getErrorMessage(),extras.getWebElements().get(0).getText());
    }

    /**
     * assert message error for non password input
     * @result assertion pass
     */
    @Test
    public void test_08_assertPasswordErrorMessage() {
        Assert.assertEquals(extras.getErrorMessage(), extras.getWebElements().get(1).getText());
    }

    @Test
    public void test_09_inputEnterEmail() {
        userAction.userInput(signIn.emailAdressElement, configData.getUserEmail());
    }

    @Test
    public void test_10_inputEnterPassword() throws IOException {
        userAction.userInput(signIn.passwordElement, configData.getUserPassword());
    }

    @Test
    public void test_11_clickButtonToSignInUser(){
        clickButtonToSignInUser();
        testReport.log(Status.PASS, "user signedIn successfully");
    }

    //check if it is good implementation and clean code
    /**
     * @result click button to submit existing user
     */
    private void clickButtonToSignInUser(){
        try {
            userAction.clickElement(signIn.signInUserButton);
        } catch (Exception e) {
            testReport.log(Status.FAIL, "not succeeded to click button to signIn user");
            testReport.log(Status.INFO, e.getMessage());
        }
    }
}