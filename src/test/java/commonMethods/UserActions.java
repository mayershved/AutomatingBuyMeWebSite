package commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * UserActions class implements user interactions
 * and contain methods to execute user events,
 * also some methods used in project
 *
 * @author Mayer Shved
 */
public class UserActions {

    private WebDriver driver;

    /**
     * go/ navigate to web page
     * @param URL
     */
    public void navigateToWebPage(String URL){
        driver.get(URL);
    }

    /**
     * provide web element on return
     * taking By element as parameter
     * @param element  By element
     * @return
     */
    public WebElement getWebElement(By element) {
        return driver.findElement(element);
    }

    /**
     * handle user click
     * @param element By element
     */
    public void clickElement( By element){
        driver.findElement(element).click();
    }

    /**
     * handle user input
     *
     * @param element By element
     * @param userInput
     */
    public void userInput(By element, String userInput){
        driver.findElement(element).sendKeys(userInput);
    }

    /**
     * handle to clear info from tags like textarea and input
     *
     * @param element By element
     */
    public void clearFromText(By element){
        driver.findElement(element).clear();
    }

    /**
     * handle page scrolling according
     * to x, y coordinates
     * @param x axis
     * @param y axis
     */
    public void scrollPage(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("javascript:window.scrollBy("+x+","+y+")");
    }

    /**
     * class constructor
     * @param driver
     */
    public UserActions(WebDriver driver){
        this.driver = driver;
    }
}
