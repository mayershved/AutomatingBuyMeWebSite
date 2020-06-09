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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomeScreenTest extends CommonTestBase {

    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
    private HomeScreen homeScreen = new HomeScreen();
    private static ExtentTest testReportsForHomeScreen;

    @Test
    public void test_0_setExtendTest(){
        testReportsForHomeScreen = singletonReport.extentReport
                .createTest("Home Screen test reports", "test reports for Home Screen");
    }

    @Test
    public void test_1_PriceDropMenu() throws IOException {

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

    @Test
    public void test_2_ChoosePrice(){
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

    @Test
    public void test_3_AreaDropMenu() throws IOException {
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

    @Test
    public void test_4_ChoseArea(){
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

    @Test
    public void test_5_CategoryDropMenu() throws IOException {
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

    @Test
    public void test_6_ChooseCategory() {
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

    @Test
    public void test_7_SubmitUserSearch() throws IOException, InterruptedException {
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
        Thread.sleep(2000);
        screenShot.setScreenShotToReportDetails("Gift cards search result screen", testReportsForHomeScreen);
    }
}
