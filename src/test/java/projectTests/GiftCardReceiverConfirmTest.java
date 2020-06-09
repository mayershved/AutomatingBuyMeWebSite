package projectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.ScreenShot;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.GiftCardReceiverScreen;
import testsBases.TestBaseForLastTestClass;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardReceiverConfirmTest extends TestBaseForLastTestClass {

    private GiftCardReceiverScreen confirmReceiver = new GiftCardReceiverScreen();
    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    private static ExtentTest testReportForConfirmReceiver;

    @Test
    public void test_0_SetUpExtentTest() {
        testReportForConfirmReceiver = singletonReport.extentReport
                .createTest("Test report for gift card submition", "submit gift card");
    }

    @Test
    public void test_1_SendGiftCardByEmail(){

        try{
            userAction.clickElement(confirmReceiver.sendGiftCardByEmail);
            isClicked = true;
        }catch(Exception e){
            testReportForConfirmReceiver.log(Status.ERROR, "email option was not clicked");
            testReportForConfirmReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked){
                testReportForConfirmReceiver.log(Status.PASS, "email option clicked succesfully");
            }
        }
    }

    @Test
    public void test_2_EmailForGiftCard(){
        try{
            userAction.clearFromText(confirmReceiver.emailForGiftCard);
            userAction.userInput(confirmReceiver.emailForGiftCard,confirmReceiver.emailForGift);
            isClicked = true;
        }catch (Exception e){
            testReportForConfirmReceiver.log(Status.ERROR, "receiver email input failed");
            testReportForConfirmReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForConfirmReceiver.log(Status.PASS, "receiver email input succeeded");

        }
    }
    @Test
    public void test_3_ConfirmGiftEmail() {

        try{
            userAction.clickElement(confirmReceiver.confirmGiftEmail);
            isClicked = true;
        }catch(Exception e){
            testReportForConfirmReceiver.log(Status.ERROR, "receiver email has not been confirmed");
            testReportForConfirmReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForConfirmReceiver.log(Status.PASS, "receiver email confirmed succesfully");
        }
    }

    @Test
    public void test_4_GiftReceiverCoinfirm() throws IOException, InterruptedException {

        screenShot.setScreenShotToReportDetails("gift card details", testReportForConfirmReceiver);

        try {
            userAction.clickElement(confirmReceiver.submitGiftCardReceiverDetails);
            isClicked = true;
        } catch (Exception e) {
            testReportForConfirmReceiver.log(Status.ERROR, "gift card submit button was not clicked");
            testReportForConfirmReceiver.log(Status.INFO, e.getMessage());
        } finally {
            if (isClicked)
                testReportForConfirmReceiver.log(Status.PASS, "gift card submit button was clicked");
                Thread.sleep(2000);
                screenShot.setScreenShotToReportDetails("final Screen", testReportForConfirmReceiver);
        }
    }
}
