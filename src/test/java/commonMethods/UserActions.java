package commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public void submit(By element){
        driver.findElement(element).submit();
    }

    public UserActions(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> findElements(By elements){
        return  driver.findElements(elements);
    }
}
