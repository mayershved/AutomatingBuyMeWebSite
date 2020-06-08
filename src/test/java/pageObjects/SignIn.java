package pageObjects;

import org.openqa.selenium.By;

public class SignIn {

    public By signUpSignInButton = By.xpath("//span[text() = 'הרשמה']");

    public By emailAdressElement = By.xpath("//input[@placeholder ='מייל']");

    public By passwordElement = By.xpath("//input[@placeholder = 'סיסמה']");

    public By signInUserButton = By.xpath("//button[text() = 'כניסה ל-BUYME']");
}
