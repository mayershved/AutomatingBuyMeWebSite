package projectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.ScreenShot;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.GiftCardSupplierScreen;

import testsBases.CommonTestBase;

import java.io.IOException;

/**
 * QA Automation tests for GiftCardSupplierScreen
 * enter Gift card amount and choose gift card
 *
 * @author Mayer Shved
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardSupplierTest extends CommonTestBase {

    // class fields
    private GiftCardSupplierScreen giftCardSupplierScreen= new GiftCardSupplierScreen();
    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    private static ExtentTest testReportForGiftCardSupplierScreen;

    /**
     * create ExtentTest object for GiftCardSupplierScreen report
     * @result Object of ExtentTest type must be created
     * for  GiftCardSupplierScreen test reports
     */
    @Test
    public void test_01_SetUpExtentTest(){
        testReportForGiftCardSupplierScreen = userAction.createExtentTest(
           "Gift Card Supplier Screen Reports",
           "submit gift card amount");
    }

   @Test
    public void test_02_inputGiftCardMoneyAmount() throws IOException, InterruptedException {
        Thread.sleep(1500);
        screenShot.setScreenShotToReportDetails("Gift card supplier screen", testReportForGiftCardSupplierScreen);
        try{
            userAction.userInput(giftCardSupplierScreen.inputGiftCardAmmount,giftCardSupplierScreen.giftCardMoneyAmount);
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardSupplierScreen.log(Status.ERROR, "Gift card amount input is failed");
            testReportForGiftCardSupplierScreen.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardSupplierScreen.log(Status.PASS, "gift card amount input succeeded");
                screenShot.setScreenShotToReportDetails("Gift card amount modal", testReportForGiftCardSupplierScreen);
        }
    }

   @Test
   public void test_03_clickToChooseGiftCard(){
       try{
           userAction.clickElement(giftCardSupplierScreen.submitGiftCardMoneyAmount);
           isClicked = true;
       }catch (Exception e){
           testReportForGiftCardSupplierScreen.log(Status.ERROR, "Gift card was not choosen");
           testReportForGiftCardSupplierScreen.log(Status.INFO, e.getMessage());
       }finally {
           if(isClicked)
               testReportForGiftCardSupplierScreen.log(Status.PASS, "gift card was choosen");
       }
   }
}
