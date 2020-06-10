package projectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.ScreenShot;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;
import pageObjects.GiftCardReceiverScreen;
import testsBases.TestBaseForLastTestClass;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardReceiverTest extends TestBaseForLastTestClass {

    private GiftCardReceiverScreen  giftReceiver= new GiftCardReceiverScreen();
    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    public static ExtentTest testReportForGiftCardReceiver;
    JavascriptExecutor js = (JavascriptExecutor)singletonDriver.driver;

    @Test
    public void test_01_SetUpExtentTest() {
        testReportForGiftCardReceiver = singletonReport.extentReport
                .createTest("Gift Card Receiver Screen Reports", "open BuyMeLandingPage, signIn existing user ");
    }

    @Test
    public void test_02_assertStepNameColor(){
        final Color colour = Color.fromString(extras.getElement(extras.stepNameColorElement).getCssValue("color"));
        Assert.assertEquals(extras.STEPNAMECOLOR, colour.asHex());
    }

    @Test
    public void test_03_ChooseReceiver(){

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
    public void test_04_inputReceiverName(){
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
    public void test_05_inputSenderName(){
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
    public void test_06_assertReceiverName(){
        Assert.assertEquals(giftReceiver.receiverName,extras.getElement(extras.receiverNamePreview).getText());
    }

    @Test
    public void test_07_assertSenderName(){
        Assert.assertEquals(giftReceiver.senedrName,extras.getElement(extras.senderNamePreview).getText());
    }

    @Test
    public void test_08_GiftCardReasonDropMenu(){
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
    public void test_09_ChooseGiftCardReasonOption() {
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
    public void test_10_BlessingTextForGiftCard(){
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
    public void test_11_assertBlessingText(){
        Assert.assertEquals(giftReceiver.blessingText, extras.getElement(extras.blessingElement).getText());
    }

    @Test
    public void test_12_GiftCardPaymentTime() {
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
    public void test_13_LoadImage() throws InterruptedException {
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

    @Test
    public void test_14_SendGiftCardByEmail(){
        try{
            js.executeScript("arguments[0].click();", userAction.getWebElement(giftReceiver.sendGiftCardByEmail));
            isClicked = true;
        }catch(Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "email option was not clicked");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked){
                testReportForGiftCardReceiver.log(Status.PASS, "email option clicked succesfully");
            }
        }
    }

    @Test
    public void test_15_EmailForGiftCard(){
        try{
            userAction.clearFromText(giftReceiver.emailForGiftCard);
            userAction.userInput(giftReceiver.emailForGiftCard,"ughruvghr@jefkh.com");
            isClicked = true;
        }catch (Exception e){
           testReportForGiftCardReceiver.log(Status.ERROR, "receiver email input failed");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "receiver email input succeeded");

        }
    }
    @Test
    public void test_16_ConfirmGiftEmail() throws InterruptedException, IOException {
        Thread.sleep(2000);
        try{
            js.executeScript("arguments[0].click();", userAction.getWebElement(giftReceiver.confirmGiftEmail));
            isClicked = true;
        }catch(Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "receiver email has not been confirmed");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "receiver email confirmed succesfully");
        }

        userAction.scrollPage(0,-500);
        Thread.sleep(2000);
        screenShot.setScreenShotToReportDetails("gift card details", testReportForGiftCardReceiver);
    }
    @Test
    public void test_17_GiftReceiverCoinfirm() throws IOException, InterruptedException {
        Thread.sleep(3000);
        try {
            userAction.clickElement(giftReceiver.submitGiftCardReceiverDetails);
            isClicked = true;
        } catch (Exception e) {
            testReportForGiftCardReceiver.log(Status.ERROR, "gift card submit button was not clicked");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        } finally {
            if (isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "gift card submit button was clicked");
                Thread.sleep(3000);
                screenShot.setScreenShotToReportDetails("final Screen",testReportForGiftCardReceiver);
        }
    }
}
