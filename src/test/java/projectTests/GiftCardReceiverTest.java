package projectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.ScreenShot;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.GiftCardReceiverScreen;
import testsBases.CommonTestBase;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardReceiverTest extends CommonTestBase {

    private GiftCardReceiverScreen  giftReceiver= new GiftCardReceiverScreen();
    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    public static ExtentTest testReportForGiftCardReceiver;

    @Test
    public void test_0_SetUpExtentTest() {
        testReportForGiftCardReceiver = singletonReport.extentReport
                .createTest("Gift Card Receiver Screen Reports", "open BuyMeLandingPage, signIn existing user ");
    }

    @Test
    public void test_1_ChooseReceiver(){

        try{
            userAction.clickElement(giftReceiver.receiverOption);
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "receiver radio button was not clicked");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }
        finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "receiver radio button was clicked");
        }
    }

    @Test
    public void test_2_inputReceiverName(){
        try{
            userAction.userInput(giftReceiver.receiverNameElement,giftReceiver.receiverName);
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "receiver name input failed");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "receiver name input succeeded");

        }
    }

    @Test
    public void test_3_GiftCardReasonDropMenu(){
        try{
            userAction.clickElement(giftReceiver.giftCardReasonDropMenu);
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "gift card reason drop menu wasnt clicked");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "gift card reason drop menu clicked succesfully");
        }
    }

    @Test
    public void test_4_ChooseGiftCardReasonOption() {
        try{
            userAction.clickElement(giftReceiver.giftCardReasonOption);
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "gift card reason from drop menu wasnt clicked");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "gift card reason option from drop menu clicked succesfully");
        }
    }

    @Test
    public void test_5_BlessingTextForGiftCard(){
        try{
            userAction.clearFromText(giftReceiver.blessingTextElement);
            userAction.userInput(giftReceiver.blessingTextElement,giftReceiver.blessingText);
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "blessing text input failed");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "blessing text input succeeded");
        }
    }

    @Test
    public void test_7_GiftCardPaymentTime() {
        try{
            userAction.clickElement(giftReceiver.GiftPaymentTime);
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "when to pay radio button was not clicked");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "when to pay radio button was clicked succesfully");
        }
    }
    @Test
    public void test_4_LoadImage() throws InterruptedException {
        try{
            userAction.userInput(giftReceiver.loadImage,"/Users/igor_shved/Desktop/image.png");
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "image was not loaded");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "image loaded succesfully");
        }
        Thread.sleep(7000);
    }
}
