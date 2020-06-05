package pageObjects;

import commonMethods.UserActions;
import org.openqa.selenium.By;
import singleton.SingletonDriver;

public class HomeScreen extends UserActions {

    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();

    public By price = By.xpath("//*[text() = 'סכום']");
    public By priceOption = By.cssSelector("[data-option-array-index = '2']");
    public By area = By.xpath("//*[text() = 'אזור']");
    // not work properly is clicking index -1
    public By areaOption = By.cssSelector("[data-option-array-index = '3']");
    public By category = By.xpath("//*[text() = 'קטגוריה']");
    public By categoryOption = By.cssSelector("[data-option-array-index = '4']");
    // public By search = By.cssSelector(".ui-btn search ember-view");
    public By search = By.xpath("//a[@class = 'ui-btn search ember-view']");

    public HomeScreen(){
        super(singletonDriver.driver);
    }
}
