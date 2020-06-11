package pageObjects;

import org.openqa.selenium.By;

/**
 * SignUp Page Object
 *
 * @author Mayer Shved
 */
public class SignUp {

    //class By elements
    public By signInSignUpButton = By.xpath("//span[text() = 'הרשמה']");
    public By startSignUp = By.xpath("//*[text() = 'להרשמה']");
    public By firstNameElement = By.xpath("//input[@placeholder ='שם פרטי']");
    public By emailAdressElement = By.xpath("//input[@placeholder ='מייל']");
    public By PasswordElement = By.xpath("//input[@placeholder = 'סיסמה']");
    public By confirmPasswordElement = By.xpath("//input[@placeholder = 'אימות סיסמה']");
    public By signUpNewUserButton = By.xpath("//button[text() = 'הרשמה ל-BUYME']");
}
