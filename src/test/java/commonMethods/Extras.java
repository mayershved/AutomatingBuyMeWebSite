package commonMethods;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Extras {

    private WebDriver driver;

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

    public Extras(WebDriver driver){
        this.driver = driver;
    }
}
