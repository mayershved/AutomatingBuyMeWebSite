package projectTests;

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

    private GiftCardSupplierScreen giftCardSupplierScreen= new GiftCardSupplierScreen();

    /**
     * create ExtentTest object for GiftCardSupplierScreen report
     * @result Object of ExtentTest type must be created
     * for  GiftCardSupplierScreen test reports
     */
    @Test
    public void test_01_SetUpExtentTest(){
        testReport = userAction.createExtentTest(
           "Gift Card Supplier Screen Reports",
           "submit gift card amount");
    }

   @Test
    public void test_02_inputGiftCardMoneyAmount() throws IOException, InterruptedException {
        userAction.userInput(giftCardSupplierScreen.inputGiftCardAmmount,giftCardSupplierScreen.giftCardMoneyAmount);
        Thread.sleep(1500);
        screenShot.setScreenShotToReportDetails("Gift card supplier screen", testReport);

   }

   @Test
   public void test_03_clickToChoseGiftCard() throws IOException {
       userAction.clickElement(giftCardSupplierScreen.submitGiftCardMoneyAmount);
   }
}
