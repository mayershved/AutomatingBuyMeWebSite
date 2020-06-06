package pageObjects;

import commonMethods.UserActions;
import org.openqa.selenium.By;
import singleton.SingletonDriver;

public class HomeScreen extends UserActions {

    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();

    public By  priceDropMenu = By.xpath("//span[text() = 'סכום']");

    public  By priceOption = By.xpath("//li[contains(text(),'300-499')]");

    public By areaDropMenu = By.xpath("//span[text() = 'אזור']");

    public By areaOption = By.xpath("//li[text() = 'מרכז']");;

    public By categoryDropMenu = By.xpath("//span[text() = 'קטגוריה']");

    public By categoryOption = By.xpath("//li[text() = 'גיפט קארד למסעדות שף']");

    public By submitUserChoose = By.cssSelector("a.ui-btn.search.ember-view");

    public HomeScreen(){
        super(singletonDriver.driver);
    }
}
