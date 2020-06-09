package projectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.ScreenShot;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.GiftCardsScreen;
import testsBases.CommonTestBase;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardsScreenTest extends CommonTestBase {

    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    private GiftCardsScreen giftCardsScreen = new GiftCardsScreen();
    private static ExtentTest testReportForGiftCardsScreen;

    @Test
    public void test_0_setExtendTest(){
        testReportForGiftCardsScreen = singletonReport.extentReport
                .createTest("Gift Cards Screen test reports", "choose gift card company");
    }

    @Test
    public void test_1_ChooseGiftCardCompany() throws IOException, InterruptedException {

        screenShot.setScreenShotToReportDetails("Gift cards screen",testReportForGiftCardsScreen);

        try{
            userAction.clickElement(giftCardsScreen.giftCardCompany);
            isClicked = true;
        }catch (Exception e){
            testReportForGiftCardsScreen.log(Status.ERROR, "gift card company was not clicked");
            testReportForGiftCardsScreen.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportForGiftCardsScreen.log(Status.PASS, "gift card company was clicked");
        }
        Thread.sleep(1500);
        screenShot.setScreenShotToReportDetails("Gift Card",testReportForGiftCardsScreen);
    }
}
