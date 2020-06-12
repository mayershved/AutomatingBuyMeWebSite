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

/**
 * QA Automation tests for GiftCardReceiverScreen
 * enter Gift card amount and choose gift card
 *
 * @author Mayer Shved
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardReceiverTest extends TestBaseForLastTestClass {

    //class fields
    private GiftCardReceiverScreen  giftReceiver= new GiftCardReceiverScreen();
    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    public static ExtentTest testReportForGiftCardReceiver;
    private JavascriptExecutor js = (JavascriptExecutor)singletonDriver.driver;

    /**
     * create ExtentTest object for GiftCardReceiverScreen report
     * @result Object of ExtentTest type must be created
     * for  GiftCardReceiverScreen test reports
     */
    @Test
    public void test_01_SetUpExtentTest() {
        testReportForGiftCardReceiver = userAction.createExtentTest(
           "Gift Card Receiver Screen Reports",
           "open BuyMeLandingPage, signIn existing user ");
    }

    /**
     * sets ExtentTest object for Extras assignments report
     * @result Object of ExtentTest type must be created
     * for  Extras assignments test reports
     */
    @Test
    public void test_02_ExtrasReports(){
        extras.setExtrasTestReports(
           "Extras GiftCardReceiverScreen",
           "asserts for Receiver Name, Sender Name, Blessing Text");
    }

    /**
     * assert step name color
     * @result assertion pass
     */
    @Test
    public void test_02_assertStepNameColor(){
        final Color colour = Color.fromString(extras.getWebElement(extras.stepNameColorElement).getCssValue("color"));
        Assert.assertEquals(extras.getStepNameColor(), colour.asHex());
    }

    @Test
    public void test_03_clickRadioButtonReceiver(){
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
            userAction.userInput(giftReceiver.receiverNameElement,giftReceiver.getReceiverName());
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
            userAction.userInput(giftReceiver.senderNameElement,giftReceiver.getSender_Name());
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "sender name input failed");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "sender name input succeeded");
        }
    }

    /**
     * assert receiver name
     * @result assertion pass
     */
    @Test
    public void test_06_assertReceiverName(){
        Assert.assertEquals(giftReceiver.getReceiverName(),extras.getWebElement(extras.receiverNamePreview).getText());
    }

    /**
     * assert step sender name
     * @result assertion pass
     */
    @Test
    public void test_07_assertSenderName(){
        Assert.assertEquals(giftReceiver.getSender_Name(),extras.getWebElement(extras.senderNamePreview).getText());
    }

    @Test
    public void test_08_clickGiftCardReasonDropMenu(){
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
    public void test_09_clickGiftCardReasonOption() {
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
    public void test_10_inputBlessingTextForGiftCard(){
        try{
            userAction.clearFromText(giftReceiver.blessingTextElement);
            userAction.userInput(giftReceiver.blessingTextElement,giftReceiver.getBlesingText());
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardReceiver.log(Status.ERROR, "blessing text input failed");
            testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardReceiver.log(Status.PASS, "blessing text input succeeded");
        }
    }

    /**
     * assert step blessing text
     * @result assertion pass
     */
    @Test
    public void test_11_assertBlessingText(){
        Assert.assertEquals(giftReceiver.getBlesingText(), extras.getWebElement(extras.blessingElement).getText());
    }

    @Test
    public void test_12_clickRadioButtonGiftCardPaymentTime() {
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
    public void test_13_inputLoadImage() throws InterruptedException {
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
    public void test_14_clickSendGiftCardByEmail(){
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
    public void test_15_inputEmailForGiftCard(){
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
    public void test_16_clickConfirmGiftEmail() throws InterruptedException, IOException {
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
        screenShot.setScreenShotToReportDetails(
           "asserts for Receiver Name, Sender Name, Blessing Text",
                extras.getTestReportsForExtras());
    }
    @Test
    public void test_17_clickSubmitReceiverScreen() throws IOException, InterruptedException {
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
