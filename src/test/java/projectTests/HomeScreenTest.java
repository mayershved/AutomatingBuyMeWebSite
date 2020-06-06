package projectTests;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.HomeScreen;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomeScreenTest extends HomeScreen{

    private HomeScreen homeScreen = new HomeScreen();

    @Test
    public void test_1_PriceDropMenu(){
        homeScreen.clickElement(homeScreen.priceDropMenu);
    }

    @Test
    public void test_2_ChoosePrice(){
        homeScreen.clickElement(homeScreen.priceOption);
    }

    @Test
    public void test_3_AreaDropMenu(){
        homeScreen.clickElement(homeScreen.areaDropMenu);
    }

    @Test
    public void test_4_ChoseArea(){
        homeScreen.clickElement(homeScreen.areaOption);
    }

    @Test
    public void test_5_CategoryDropMenu(){
        homeScreen.clickElement(homeScreen.categoryDropMenu);
    }

    @Test
    public void test_6_ChooseCategory(){
        homeScreen.clickElement(homeScreen.categoryOption);
    }

    @Test
    public void test_7_SubmitUserSearch(){
        homeScreen.clickElement(homeScreen.submitUserChoose);
    }
}
