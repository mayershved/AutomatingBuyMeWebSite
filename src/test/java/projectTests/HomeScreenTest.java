package projectTests;

import com.aventstack.extentreports.Status;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.HomeScreen;
import testsBases.CommonTestBase;
import java.io.IOException;

/**
 * QA Automation tests for Home Screen
 *
 * @author Mayer Shved
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomeScreenTest extends CommonTestBase {

    private HomeScreen homeScreen = new HomeScreen();

    /**
     * sets ExtentTest object for SignUp report
     * @result Object of ExtentTest type must be created
     * for SignUp test reports
     */
    @Test
    public void test_01_SetUpExtentTest(){
        testReport = userAction
                .createExtentTest
                ("Home Screen Reports",
                 "Choose from drop menus price, area, category and submit for search");
    }

    /**
     * click on price drop menu
     * @result must open price drop menu
     * @throws IOException
     */
    @Test
    public void test_02_clickPriceDropMenu() throws IOException {
        screenShot.setScreenShotToReportDetails("BuyMe user home page", testReport);
        userAction.clickElement(homeScreen.priceDropMenu);
    }

    /**
     * click on price option from drop menu
     * @result choose price amount option
     */
    @Test
    public void test_03_clickPriceOption(){
        userAction.clickElement(homeScreen.priceOption);
    }

    /**
     * click on area drop menu
     * @result must open area drop menu
     * @throws IOException
     */
    @Test
    public void test_04_clickAreaDropMenu() throws IOException {
        userAction.clickElement(homeScreen.areaDropMenu);
    }

    /**
     * click on area option from drop menu
     * @result choose area option
     */
    @Test
    public void test_05_clickAreaOption(){
        userAction.clickElement(homeScreen.areaOption);
    }

    /**
     * click on category drop menu
     * @result must open category drop menu
     * @throws IOException
     */    @Test
    public void test_06_clickCategoryDropMenu() throws IOException {
         userAction.clickElement(homeScreen.categoryDropMenu);
    }

    /**
     * click on category option from drop menu
     * @result choose category option
     */
    @Test
    public void test_07_clickCategoryOption() {
        userAction.clickElement(homeScreen.categoryOption);
    }

    /**
     * @result click button to submit user chosen options
     * @throws IOException
     */
    @Test
    public void test_08_clickSubmitUserSearch() throws IOException {
        screenShot.setScreenShotToReportDetails("gift card search info", testReport);
        try{
            userAction.clickElement(homeScreen.submitUserChoose);
            isClicked = true;
        }catch (Exception e){
            testReport.log(Status.FAIL, "not succeeded to click button to submit gift card search info");
            testReport.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReport.log(Status.PASS, "gift card search info submitted successfully");
        }
    }
}
