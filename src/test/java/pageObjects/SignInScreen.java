package pageObjects;

import org.openqa.selenium.By;

public class SignInScreen{

    public By signInButton = By.cssSelector(".seperator-link");
    public By startSignIn = By.xpath("//*[text() = 'להרשמה']");
    public By firstNameElement = By.xpath("//input[@type ='text']");
    public By emailAdressElement = By.xpath("//input[@type ='email']");
    public By confirmPasswordElement = By.xpath("//input[@placeholder = 'אימות סיסמה']");
    public By sPasswordElement = By.xpath("//input[@placeholder = 'סיסמה']");
    public By passwordElement = By.cssSelector("input#valPass");
    public By submitButton = By.cssSelector("button.ui-btn.orange.large");
}