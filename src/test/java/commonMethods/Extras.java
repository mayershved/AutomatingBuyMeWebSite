package commonMethods;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Extras {

    public WebDriver driver;
    public  ExtentReports extentReports;
    public  ExtentTest testReportsForExtras;

    // class constants
    public final String ERRORMESSAGE = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
    public final String STEPNAMECOLOR = "#fab442";

    // class By variables
    public By emptyEmailAndPasswordWarning = By.xpath("//li[text() = 'כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה']");

    public By stepNameColorElement = By.cssSelector("div.step-title.highlighted");

    public By receiverNamePreview = By.xpath("//div[@class = 'receiver']/span[2]");

    public By senderNamePreview = By.xpath("//div[@class = 'sender']/span[2]");

    public By blessingElement = By.cssSelector("p.card-text.cut-greeting");


    //class lists of web elements
    public List<WebElement> webElements;

    public void setListOfElements(By element){
        webElements  = driver.findElements(element);
    }


    // class methods

    public void setExtrasTestReports(String testReportstitle, String description) {
        testReportsForExtras = extentReports.createTest(testReportstitle, description);
    }

    public void scrollPage(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("javascript:window.scrollBy("+x+","+y+")");
    }

    public WebElement getElement(By element){
        return driver.findElement(element);
    }



    public Extras(WebDriver driver, ExtentReports extentReports){
        this.driver = driver;
        this.extentReports = extentReports;

    }
}
