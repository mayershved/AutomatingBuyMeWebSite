package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeScreen{

    public By  priceDropMenu = By.xpath("//span[text() = 'סכום']");

    public  By priceOption = By.xpath("//li[contains(text(),'300-499')]");

    public By areaDropMenu = By.xpath("//span[text() = 'אזור']");

    public By areaOption = By.xpath("//li[text() = 'מרכז']");

    public By categoryDropMenu = By.xpath("//span[text() = 'קטגוריה']");

    public By categoryOption = By.xpath("//li[text() = 'גיפט קארד למסעדות שף']");

    public By submitUserChoose = By.xpath("//a[text() = 'תמצאו לי מתנה']");
}
