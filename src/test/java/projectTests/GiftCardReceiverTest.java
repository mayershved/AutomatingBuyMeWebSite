package projectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.ScreenShot;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.Color;
import pageObjects.GiftCardReceiverScreen;
import testsBases.CommonTestBase;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardReceiverTest extends CommonTestBase {

    private GiftCardReceiverScreen  giftReceiver= new GiftCardReceiverScreen();
    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    public static ExtentTest testReportForGiftCardReceiver;

    @Test
    public void test_01_SetUpExtentTest() {
        testReportForGiftCardReceiver = singletonReport.extentReport
                .createTest("Gift Card Receiver Screen Reports", "open BuyMeLandingPage, signIn existing user ");
    }

    @Test
    public void test_02_ExtrasReports() throws IOException {
        extras.setExtrasTestReports("Extras for Receiver Screen", "Extras Gift Cards Screen assignment");
    }


    @Test
    public void test_03_assertStepNameColor(){
        final Color colour = Color.fromString(extras.getElement(extras.stepNameColorElement).getCssValue("color"));
        Assert.assertEquals(extras.STEPNAMECOLOR, colour.asHex());
    }

    @Test
    public void test_04_ChooseReceiver(){

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
    public void test_05_inputReceiverName(){
        try{
            userAction.clearFromText(giftReceiver.receiverNameElement);
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
    public void test_06_inputSenderName(){
        try{
            userAction.clearFromText(giftReceiver.senderNameElement);
            userAction.userInput(giftReceiver.senderNameElement,giftReceiver.senedrName);
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "sender name input failed");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "sender name input succeeded");
        }
    }

    @Test
    public void test_07_assertReceiverName(){
        Assert.assertEquals(giftReceiver.receiverName,extras.getElement(extras.receiverNamePreview).getText());
    }

    @Test
    public void test_08_assertSenderName(){
        Assert.assertEquals(giftReceiver.senedrName,extras.getElement(extras.senderNamePreview).getText());
    }

    @Test
    public void test_09_BlessingTextForGiftCard(){
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
    public void test_10_assertBlessingText(){
        Assert.assertEquals(giftReceiver.blessingText, extras.getElement(extras.blessingElement).getText());
    }

    @Test
    public void test_11_GiftCardPaymentTime() {
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
    public void test_12_LoadImage() throws InterruptedException {
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
