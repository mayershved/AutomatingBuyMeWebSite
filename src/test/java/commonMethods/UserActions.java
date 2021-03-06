package commonMethods;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import singleton.SingletonDriver;
import singleton.SingletonReport;

/**
 *
 * UserActions class implements user interactions
 * and contain methods to execute user events,
 * also some methods used in project
 *
 * @author Meir Shved
 */
public class UserActions {

    private SingletonDriver singletonDriver = SingletonDriver.getInstance();
    private SingletonReport singletonReport = SingletonReport.getInstance();
    //private ExtentReports extentReports;
    private final String IMAGEPATH = "/Users/igor_shved/Desktop/image.png";

    /**
     * go / navigate to web page
     * @param URL
     */
    public void navigateToWebPage(String URL){
        singletonDriver.driver.navigate().to(URL);
    }

    /**
     * provide web element on return
     * taking By element as parameter
     * @param element  By element
     * @return
     */
    public WebElement getWebElement(By element) {
        return singletonDriver.driver.findElement(element);
    }

    public String getImagePath(){
        return IMAGEPATH;
    }

    /**
     * handle user click
     * @param element By element
     */
    public void clickElement( By element){
        singletonDriver.driver.findElement(element).click();
    }

    /**
     * handle user input
     *
     * @param element By element
     * @param userInput
     */
    public void userInput(By element, String userInput){
        singletonDriver.driver.findElement(element).sendKeys(userInput);
    }

    /**
     * handle to clear info from tags like textarea and input
     *
     * @param element By element
     */
    public void clearFromText(By element){
        singletonDriver.driver.findElement(element).clear();
    }

    /**
     * handle page scrolling according
     * to x, y coordinates
     * @param x axis
     * @param y axis
     */
    public void scrollPage(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor)singletonDriver.driver;
        js.executeScript("javascript:window.scrollBy("+x+","+y+")");
    }

    /**
     *
     * @param testReportTitle
     * @param testReportDscription
     * @return object of class ExtentTest
     */
    public ExtentTest createExtentTest(String testReportTitle, String testReportDscription){
        return singletonReport.extentReport.createTest(testReportTitle, testReportDscription);
    }

//    /**
//     * class constructor
//     * @param driver
//     */
//    public UserActions(){
//
//    }
}
