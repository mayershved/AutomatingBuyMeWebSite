package commonMethods;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Extras class contains variables and methods to implement
 * Extras assignments of the project
 * @author Meir Shved
 */
public class Extras {

    // class variables
    private WebDriver driver;
    private ExtentReports extentReports;
    private static ExtentTest testReportsForExtras;

    // class constants
    private static final String ERRORMESSAGE = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
    private static final String STEPNAMECOLOR = "#fab442";

    // class By elements variables
    public By spinerElement = By.xpath("//body/div/img");
    public By emptyEmailAndPasswordWarning = By.xpath("//li[text() = 'כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה']");
    public By stepNameColorElement = By.cssSelector("div.step-title.highlighted");
    public By receiverNamePreview = By.xpath("//div[@class = 'receiver']/span[2]");
    public By senderNamePreview = By.xpath("//div[@class = 'sender']/span[2]");
    public By blessingElement = By.cssSelector("p.card-text.cut-greeting");

    //class lists of web elements
    private static List<WebElement> webElements;

    /**
     * class field getter
     * @return
     */
    public String getErrorMessage(){
        return ERRORMESSAGE;
    }

    /**
     * class field getter
     * @return
     */
    public String getStepNameColor(){
        return STEPNAMECOLOR;
    }

    /**
     * class field getter
     * @return
     */
    public ExtentTest getTestReportsForExtras(){
        return testReportsForExtras;
    }


    /**
     * This method sets List webElements from By element that receive as parameter
     *
     * @param element By element
     */
    public void setListOfWebElements(By element){
        webElements  = driver.findElements(element);
    }


    /**
     * This method create test ExtentsReport variable
     * for Extras assignments test reports
     * @param testReporsTitle
     * @param description
     */
    public void setExtrasTestReports(String testReporsTitle, String description) {
        testReportsForExtras = extentReports.createTest(testReporsTitle, description);
    }

    /**
     * this method receive By element as parameter
     * and return WebElement
     * @param element By element
     * @return
     */
    public WebElement getWebElement(By element){
        return driver.findElement(element);
    }

    public List<WebElement> getWebElements(){
        return webElements;
    }

    /**
     * Extras class constructor
     * @param driver
     * @param extentReports
     */
    public Extras(WebDriver driver, ExtentReports extentReports){
        this.driver = driver;
        this.extentReports = extentReports;
    }
}
