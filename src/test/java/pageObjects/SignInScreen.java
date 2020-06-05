package pageObjects;

import commonMethods.UserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import singleton.SingletonDriver;

public class SignInScreen extends UserActions {

    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();

    protected final String userName = "Name";
    protected final String userEmail = "nnfk@vr.com";
    protected final String userPassword = "Q1passwerrvrvrv";

    protected static By signInButton = By.cssSelector(".seperator-link");
    protected static By startSignIn = By.xpath("//*[text() = 'להרשמה']");
    protected static By firstNameElement = By.xpath("//input[@type ='text']");
    protected static By emailAdressElement = By.xpath("//input[@type ='email']");
    protected static By confirmPasswordElement = By.xpath("//input[@placeholder = 'אימות סיסמה']");
    protected static By passwordElement = By.cssSelector("input#valPass");
    protected static By submitButton = By.cssSelector("button.ui-btn.orange.large");

    public SignInScreen(){
        super(singletonDriver.driver);
    }
}
