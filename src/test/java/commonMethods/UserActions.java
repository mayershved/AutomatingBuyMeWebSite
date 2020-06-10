package commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserActions {

    private WebDriver driver;

    public void navigateToWebPage(String URL){
        driver.get(URL);
    }


    public WebElement getWebElement(By element) {
        return driver.findElement(element);
    }

        public void clickElement( By element){
        driver.findElement(element).click();
    }

    public void userInput(By element, String userInput){
        driver.findElement(element).sendKeys(userInput);
    }

    public void clearFromText(By element){
        driver.findElement(element).clear();
    }

    public void submit(By element){
        driver.findElement(element).submit();
    }

    public void scrollPage(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("javascript:window.scrollBy("+x+","+y+")");
    }

    public UserActions(WebDriver driver){
        this.driver = driver;
    }
}
