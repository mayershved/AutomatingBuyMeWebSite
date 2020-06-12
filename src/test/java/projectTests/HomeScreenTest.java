package projectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commonMethods.ScreenShot;
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

    //class fields
    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    private HomeScreen homeScreen = new HomeScreen();
    private static ExtentTest testReportsForHomeScreen;

    /**
     * sets ExtentTest object for SignUp report
     * @result Object of ExtentTest type must be created
     * for SignUp test reports
     */
    @Test
    public void test_01_SetUpExtentTest(){
        testReportsForHomeScreen = userAction
                .createExtentTest
                ("Home Screen Reports",
                 "Open BuyMe landing page, singUp new user");
    }

    /**
     * click on price drop menu
     * @result must open price drop menu
     * @throws IOException
     */
    @Test
    public void test_02_clickPriceDropMenu() throws IOException {
        screenShot.setScreenShotToReportDetails("BuyMe landing page", testReportsForHomeScreen);
        try{
            userAction.clickElement(homeScreen.priceDropMenu);
            isClicked = true;
        }catch (Exception e){
            testReportsForHomeScreen.log(Status.ERROR, "price drop menu is not clicked");
            testReportsForHomeScreen.log(Status.INFO, e.getMessage());
        }finally {
            if (isClicked)
                testReportsForHomeScreen.log(Status.PASS, "priced drop menu is clicked");
                screenShot.setScreenShotToReportDetails("price drop menu", testReportsForHomeScreen);
        }
    }

    /**
     * click on price option from drop menu
     * @result choose price amount option
     */
    @Test
    public void test_03_clickPriceOption(){
        try{
            userAction.clickElement(homeScreen.priceOption);
            isClicked = true;
        }catch(Exception e){
            testReportsForHomeScreen.log(Status.ERROR, "price option from drop menu is not clicked");
            testReportsForHomeScreen.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportsForHomeScreen.log(Status.PASS, "priced option from drop menu is clicked");
        }
    }

    /**
     * click on area drop menu
     * @result must open area drop menu
     * @throws IOException
     */
    @Test
    public void test_04_clickAreaDropMenu() throws IOException {
        try{
            userAction.clickElement(homeScreen.areaDropMenu);
            isClicked = true;
        }catch(Exception e){
            testReportsForHomeScreen.log(Status.ERROR, "area drop menu is not clicked");
            testReportsForHomeScreen.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportsForHomeScreen.log(Status.PASS, "area drop menu is clicked");
                screenShot.setScreenShotToReportDetails("area drop menu", testReportsForHomeScreen);
        }
    }

    /**
     * click on area option from drop menu
     * @result choose area option
     */
    @Test
    public void test_05_clickAreaOption(){
        try{
            userAction.clickElement(homeScreen.areaOption);
            isClicked = true;
        }catch (Exception e){
            testReportsForHomeScreen.log(Status.ERROR, "area option from drop menu is not clicked");
            testReportsForHomeScreen.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportsForHomeScreen.log(Status.PASS, "area option from drop menu is clicked");
        }
    }

    /**
     * click on category drop menu
     * @result must open category drop menu
     * @throws IOException
     */    @Test
    public void test_06_clickCategoryDropMenu() throws IOException {
        try{
            userAction.clickElement(homeScreen.categoryDropMenu);
            isClicked = true;
        }catch (Exception e){
            testReportsForHomeScreen.log(Status.ERROR, "category drop menu is not clicked");
            testReportsForHomeScreen.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportsForHomeScreen.log(Status.PASS, "category drop menu is clicked");
                screenShot.setScreenShotToReportDetails("category drop menu", testReportsForHomeScreen);
        }
    }

    /**
     * click on category option from drop menu
     * @result choose category option
     */
    @Test
    public void test_07_clickCategoryOption() {
        try{
            userAction.clickElement(homeScreen.categoryOption);
            isClicked = true;
        }catch(Exception e){
            testReportsForHomeScreen.log(Status.ERROR, "category option from drop menu is not clicked");
            testReportsForHomeScreen.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportsForHomeScreen.log(Status.PASS, "category option from drop menu is clicked");
        }
    }

    /**
     * @result click button to submit user chosen options
     * @throws IOException
     */
    @Test
    public void test_08_clickSubmitUserSearch() throws IOException {
        screenShot.setScreenShotToReportDetails("gift card search info", testReportsForHomeScreen);
        try{
            userAction.clickElement(homeScreen.submitUserChoose);
            isClicked = true;
        }catch (Exception e){
            testReportsForHomeScreen.log(Status.FAIL, "not succeeded to click button to submit gift card search info");
            testReportsForHomeScreen.log(Status.INFO, e.getMessage());
        }finally {
            if(isClicked)
                testReportsForHomeScreen.log(Status.PASS, "gift card search info submitted successfully");
        }
    }
}
