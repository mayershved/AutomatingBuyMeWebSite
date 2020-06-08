package projectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.HomeScreen;
import testsBases.CommonTestBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomeScreenTest extends CommonTestBase {

    private HomeScreen homeScreen = new HomeScreen();
    protected static ExtentTest testReportsForHomeScreen;

    @Test
    public void test_0_setExtendTest(){

        testReportsForHomeScreen = singletonReport.extentReport
                .createTest("Test reports for Home Screen", "test reports for Home Screen");
    }

    @Test
    public void test_1_PriceDropMenu(){
        try{
            userAction.clickElement(homeScreen.priceDropMenu);
            isClicked = true;
        }catch (Exception e){
            e.printStackTrace();
            testReportsForHomeScreen.log(Status.FATAL, "priced drop menu is not clicked");
            testReportsForHomeScreen.log(Status.INFO, e.getMessage());
            isClicked = false;
        }
        finally {
            if (isClicked) {
                testReportsForHomeScreen.log(Status.PASS, "priced drop menu is clicked");
            }
        }
    }

    @Test
    public void test_2_ChoosePrice(){
        userAction.clickElement(homeScreen.priceOption);
    }

    @Test
    public void test_3_AreaDropMenu(){
        userAction.clickElement(homeScreen.areaDropMenu);
    }

    @Test
    public void test_4_ChoseArea(){
        userAction.clickElement(homeScreen.areaOption);
    }

    @Test
    public void test_5_CategoryDropMenu(){
        userAction.clickElement(homeScreen.categoryDropMenu);
    }

    @Test
    public void test_6_ChooseCategory(){
        userAction.clickElement(homeScreen.categoryOption);
    }

    @Test
    public void test_7_SubmitUserSearch(){
        userAction.clickElement(homeScreen.submitUserChoose);
    }
}
