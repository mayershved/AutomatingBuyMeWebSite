package commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserActions {

    WebDriver driver;

    public void navigateToWebPage(String URL){
        driver.get(URL);
    }

     public void clickElement( By element){
        driver.findElement(element).click();
    }

    public void userInput(By element, String userInput){
        driver.findElement(element).sendKeys(userInput);
    }

    public UserActions(WebDriver driver){
        this.driver = driver;
    }
}
