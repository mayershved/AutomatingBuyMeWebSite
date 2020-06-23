package projectTests;

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
 * Automation tests for GiftCardReceiverScreen
 * enter Gift card amount and choose gift card
 *
 * @author Meir Shved
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardReceiverTest extends TestBaseForLastTestClass {

    //class fields
    private GiftCardReceiverScreen  giftReceiver= new GiftCardReceiverScreen();
    private JavascriptExecutor js = (JavascriptExecutor)singletonDriver.driver;

    /**
     * create ExtentTest object for GiftCardReceiverScreen report
     * @result Object of ExtentTest type must be created
     * for  GiftCardReceiverScreen test reports
     */
    @Test
    public void test_01_SetUpExtentTest() {
        testReport = userAction.createExtentTest(
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
        userAction.clickElement(giftReceiver.receiverOption);
    }

    @Test
    public void test_04_inputReceiverName(){
        userAction.clearFromText(giftReceiver.receiverNameElement);
        userAction.userInput(giftReceiver.receiverNameElement,giftReceiver.getReceiverName());
    }

    @Test
    public void test_05_inputSenderName(){
        userAction.clearFromText(giftReceiver.senderNameElement);
        userAction.userInput(giftReceiver.senderNameElement,giftReceiver.getSender_Name());
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
        userAction.clickElement(giftReceiver.giftCardReasonDropMenu);
    }

    @Test
    public void test_09_clickGiftCardReasonOption() {
            userAction.clickElement(giftReceiver.giftCardReasonOption);
    }

    @Test
    public void test_10_inputBlessingTextForGiftCard(){
        userAction.clearFromText(giftReceiver.blessingTextElement);
        userAction.userInput(giftReceiver.blessingTextElement,giftReceiver.getBlesingText());
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
        userAction.clickElement(giftReceiver.GiftPaymentTime);
    }

    @Test
    public void test_13_inputLoadImage() throws InterruptedException {
        userAction.userInput(giftReceiver.loadImage,userAction.getImagePath());
        Thread.sleep(9000);
    }

    @Test
    public void test_14_clickSendGiftCardByEmail(){
        js.executeScript("arguments[0].click();", userAction.getWebElement(giftReceiver.sendGiftCardByEmail));
    }

    @Test
    public void test_15_inputEmailForGiftCard(){
        userAction.clearFromText(giftReceiver.emailForGiftCard);
        userAction.userInput(giftReceiver.emailForGiftCard,"ughruvghr@jefkh.com");
    }
    @Test
    public void test_16_clickConfirmGiftEmail() throws InterruptedException, IOException {
        //Thread.sleep(1000);
        js.executeScript("arguments[0].click();", userAction.getWebElement(giftReceiver.confirmGiftEmail));
        userAction.scrollPage(0,-500);
        Thread.sleep(1000);
        screenShot.setScreenShotToReportDetails("gift card details", testReport);
        screenShot.setScreenShotToReportDetails(
           "asserts for Receiver Name, Sender Name, Blessing Text",
                extras.getTestReportsForExtras());
    }
    @Test
    public void test_17_clickSubmitReceiverScreen() throws IOException, InterruptedException {
//        Thread.sleep(3000);
        userAction.clickElement(giftReceiver.submitGiftCardReceiverDetails);
        Thread.sleep(3000);
        screenShot.setScreenShotToReportDetails("final Screen",testReport);
    }
}
