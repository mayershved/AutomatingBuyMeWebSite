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
    public void test_01_setExtendTest(){
        testReportForGiftCardsScreen = singletonReport.extentReport
                .createTest("Gift Cards Screen Reports", "choose gift card company");
    }

    @Test
    public void test_02_ExtrasReports() throws IOException {
        extras.setExtrasTestReports("Extras for Gift Cards Screen", "Extras Gift Cards Screen assignment");
    }

    @Test
    public void test_03_ScrollDownExtras() throws InterruptedException, IOException {
        Thread.sleep(1000);
        try {
            extras.scrollPage(0, 3000);
            isClicked = true;
        }catch (Exception e){
            extras.testReportsForExtras.log(Status.ERROR, "page was not scrolled down");
            extras.testReportsForExtras.log(Status.INFO, e.getMessage());
        }finally {
            if (isClicked)
                screenShot.setScreenShotToReportDetails("scroll to bottom of the Home Screen", extras.testReportsForExtras);
        }
    }

    @Test
    public void test_04_ScrolUpExtras() throws InterruptedException, IOException {
        try {
            extras.scrollPage(0, -5000);
            isClicked = true;
        } catch (Exception e) {
            extras.testReportsForExtras.log(Status.ERROR, "page was not scrolled up");
            extras.testReportsForExtras.log(Status.INFO, e.getMessage());
        } finally {
            if (isClicked)
                screenShot.setScreenShotToReportDetails("scroll up the Home Screen", extras.testReportsForExtras);
        }
    }

    @Test
    public void test_05_ChooseGiftCardCompany() throws IOException, InterruptedException {

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
    }
}
