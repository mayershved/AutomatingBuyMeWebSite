package pageObjects;

import org.openqa.selenium.By;

public class SignInScreen{

    public By signInButton = By.xpath("//span[text() = 'הרשמה']");
    public By startSignIn = By.xpath("//*[text() = 'להרשמה']");
    public By firstNameElement = By.xpath("//input[@type ='text']");
    public By emailAdressElement = By.xpath("//input[@placeholder ='מייל']");
    public By confirmPasswordElement = By.xpath("//input[@placeholder = 'אימות סיסמה']");
    public By sPasswordElement = By.xpath("//input[@placeholder = 'סיסמה']");
    public By passwordElement = By.cssSelector("input#valPass");
    public By submitButton = By.xpath("//button[text() = 'כניסה ל-BUYME']");
}