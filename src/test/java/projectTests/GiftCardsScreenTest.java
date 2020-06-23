package projectTests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.GiftCardsScreen;
import testsBases.CommonTestBase;
import java.io.IOException;

/**
 * Automation tests for GiftCards Screen
 *
 * @author Meir Shved
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardsScreenTest extends CommonTestBase {

    private GiftCardsScreen giftCardsScreen = new GiftCardsScreen();

    /**
     * sets ExtentTest object for SignUp test extent report
     *
     * @result Object of ExtentTest type must be created
     * for SignUp report
     */
    @Test
    public void test_01_SetUpExtentTest() {
        testReport = userAction.createExtentTest
            ("GiftCardsScreen",
            "choose gift card company");
    }

    /**
     * sets ExtentTest object for Extras assignments reports
     *
     * @result Object of ExtentTest type must be created
     * for Extras tests reports
     */
    @Test
    public void test_02_ExtrasReports() {
        extras.setExtrasTestReports("Extras for GiftCardsScreen", "scroll down, scroll up");
    }

    /**
     * scroll down and take screenshot / Extras assignments
     *
     * @throws InterruptedException
     * @throws IOException
     * @result scroll to the bottom of the page, screenshot on the bottom of the page
     */
    @Test
    public void test_03_scrollDownExtras() throws InterruptedException, IOException {
        Thread.sleep(1000);
        userAction.scrollPage(0, 3000);
        screenShot.setScreenShotToReportDetails("scroll to bottom of the GiftCardsScreen", extras.getTestReportsForExtras());
    }

    /**
     * scroll up and take screenshot / Extras assignments
     *
     * @throws IOException
     * @result scroll to the up of the page, screenshot on the up of the page
     */
    @Test
    public void test_04_scrolUpExtras() throws IOException {
        userAction.scrollPage(0, -5000);
        screenShot.setScreenShotToReportDetails("scroll up GiftCardsScreen", extras.getTestReportsForExtras());
    }

    @Test
    public void test_05_clickGiftCardCompany() throws IOException {
        screenShot.setScreenShotToReportDetails("Gift cards screen", testReport);
        userAction.clickElement(giftCardsScreen.giftCardCompany);
    }
}