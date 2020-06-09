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
    public ExtentReports extentReports;
    public ExtentTest testReportsForExtras;

    // class constants
    public final String ERRORMESSAGE = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";

    // class By variables
    public By emptyEmailAndPasswordWarning = By.xpath("//li[text() = 'כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה']");

    //class lists of web elements
    public List<WebElement> webElements;


    public void asserExtrasMethod(String expected, String actual){
        Assert.assertEquals(expected, actual);
    }

    public void setListOfElements(By element){
        webElements  = driver.findElements(element);
    }

    public void scrollPage(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("javascript:window.scrollBy("+x+","+y+")");
    }


    public void setExtrasTestReports(String testReportstitle, String description) {
        testReportsForExtras = extentReports.createTest(testReportstitle, description);
    }

    public Extras(WebDriver driver, ExtentReports extentReports){
        this.extentReports = extentReports;
        this.driver = driver;
    }
}
