package projectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.ProjectConfigData;
import commonMethods.ScreenShot;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.GiftCardSupplierScreen;
import pageObjects.SignUp;
import testsBases.CommonTestBase;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardSupplierTest extends CommonTestBase {

    private GiftCardSupplierScreen giftCardSupplierScreen= new GiftCardSupplierScreen();
    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    private static ExtentTest testReportForGiftCardSupplierScreen;

    @Test
    public void test_0_SetUpExtentTest(){
        testReportForGiftCardSupplierScreen = singletonReport.extentReport
                .createTest("Test report for gift card supplier screen", "submit gift card amount");
    }

   @Test
    public void test_1_giftCardMoneyAmount() throws IOException {

        screenShot.setScreenShotToReportDetails("Gift card supplier screen", testReportForGiftCardSupplierScreen);
        try{
            userAction.userInput(giftCardSupplierScreen.inputGiftCardAmmount,giftCardSupplierScreen.giftCardMoneyAmount);
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardSupplierScreen.log(Status.ERROR, "gift card amount input is failed");
            testReportForGiftCardSupplierScreen.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardSupplierScreen.log(Status.PASS, "gift card amount input succeeded");
                screenShot.setScreenShotToReportDetails("gift card amount modal", testReportForGiftCardSupplierScreen);
        }
    }

   @Test
   public void test_2_chooseGiftCard()  {
       try{
           userAction.clickElement(giftCardSupplierScreen.submitGiftCardMoneyAmount);
           isClicked = true;
       }catch (Exception e){
           testReportForGiftCardSupplierScreen.log(Status.ERROR, "gift card was not choosen");
           testReportForGiftCardSupplierScreen.log(Status.INFO, e.getMessage());
       }finally {
           if(isClicked)
               testReportForGiftCardSupplierScreen.log(Status.PASS, "gift card was choosen");
       }
   }
}
