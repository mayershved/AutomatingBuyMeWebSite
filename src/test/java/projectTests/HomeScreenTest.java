package projectTests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.HomeScreen;
import testsBases.CommonTestBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomeScreenTest extends CommonTestBase {

    private HomeScreen homeScreen = new HomeScreen();

    @Test
    public void test_1_PriceDropMenu(){
        userAction.clickElement(homeScreen.priceDropMenu);
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
