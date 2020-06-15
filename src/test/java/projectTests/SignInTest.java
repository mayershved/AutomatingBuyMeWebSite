package projectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.Extras;
import commonMethods.ProjectConfigData;
import commonMethods.ScreenShot;
import pageObjects.SignIn;
import org.junit.runners.MethodSorters;
import org.junit.*;
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
    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    private static Extras extras = new Extras(singletonDriver.driver, singletonReport.extentReport);
    private ProjectConfigData configData = new ProjectConfigData();
    private static SignIn signIn = new SignIn();
    private static ExtentTest testReportForSignIn;
    private String url = "https://buyme.co.il/";

    /**
     * sets ExtentTest object for SignIn report
     * @result Object of ExtentTest type must be created
     * for SignIn test reports
     */
    @Test
    public void test_01_SetUpSignInExtentTest() {
        testReportForSignIn = userAction.createExtentTest
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
    public void test_03_OpenBuyMeLandingPage() throws IOException {
        userAction.navigateToWebPage(configData.getBuyMeLandingPageUrl());
        if (url.equals(singletonDriver.driver.getCurrentUrl())) {
            testReportForSignIn.log(Status.PASS, "BuyMe landing page is oppened");
            screenShot.setScreenShotToReportDetails("BuyMe landing page", testReportForSignIn);
        } else {
            testReportForSignIn.log(Status.FAIL, "BuyMe landing page is not opened");
            screenShot.setScreenShotToReportDetails("BuyMe landing page is not opened", testReportForSignIn);
        }
    }

    /**
     * @result open SignIn modal
     * @throws IOException
     */
    @Test
    public void test_04_clickSignInSignUp() throws IOException {
        try {
            userAction.clickElement(signIn.signUpSignInButton);
            isClicked = true;
        } catch (Exception e) {
            testReportForSignIn.log(Status.ERROR, "SignInSignUp button was not clicked");
            testReportForSignIn.log(Status.INFO, e.getMessage());
        } finally {
            if (isClicked)
                testReportForSignIn.log(Status.PASS, "SignInSignUp button was clicked");
                screenShot.setScreenShotToReportDetails("SignIn Modal", testReportForSignIn);
        }
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
        try {
            userAction.userInput(signIn.emailAdressElement, configData.getUserEmail());
            isClicked = true;
        } catch (Exception e) {
            testReportForSignIn.log(Status.ERROR, "email input failed");
            testReportForSignIn.log(Status.INFO, e.getMessage());
        } finally {
            if (isClicked)
                testReportForSignIn.log(Status.PASS, "email input is passed");
        }
    }

    @Test
    public void test_10_inputEnterPassword() throws IOException {

        try {
            userAction.userInput(signIn.passwordElement, configData.getUserPassword());
            isClicked = true;
        } catch (Exception e) {
            testReportForSignIn.log(Status.ERROR, "password input failed");
            testReportForSignIn.log(Status.INFO, e.getMessage());
        } finally {
            if (isClicked)
                testReportForSignIn.log(Status.PASS, "password input is passed");
                screenShot.setScreenShotToReportDetails("user info", testReportForSignIn);
        }
    }

    @Test
    public void test_11_clickButtonToSignInUser(){
        clickButtonToSignInUser();
    }

    //check if it is good implementation and clean code
    /**
     * @result click button to submit existing user
     */
    private void clickButtonToSignInUser(){
        try {
            userAction.clickElement(signIn.signInUserButton);
            isClicked = true;
        } catch (Exception e) {
            testReportForSignIn.log(Status.FAIL, "not succeeded to click button to signIn user");
            testReportForSignIn.log(Status.INFO, e.getMessage());
        } finally {
            if (isClicked)
                testReportForSignIn.log(Status.PASS, "signIn button is pressed");
        }
    }
}