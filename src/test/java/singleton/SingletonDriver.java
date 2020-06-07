package singleton;

import commonMethods.ProjectConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class SingletonDriver {

    // static variable single_instance of type Singleton
    private static SingletonDriver instance = null;

    // variable of type String
    public WebDriver driver;

    // private constructor restricted to this class itself
    private SingletonDriver() {
    }

    // static method to create instance of Singleton class
    public static synchronized SingletonDriver getInstance()
    {
        if (instance == null)
            instance = new SingletonDriver();

        return instance;
    }

    private static ProjectConfigData configData = new ProjectConfigData();

    /**
     * This method sets WebDriver for Project
     */
    public void setProjectDriver(){
        if(configData.getBrowserType().equals("Chrome")){
            setChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }else if(configData.getBrowserType().equals("firefox")){
            setFirefoxDriver();
        }
    }

    /**
     * Instantinatig Firefox driver object
     */
    private void setFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver",configData.getFirefoxDriverPath());
        driver = new FirefoxDriver();
    }

    /**
     * Instantinatig Chrome driver object
     */
    private void setChromeDriver(){
        System.setProperty("webdriver.chrome.driver",configData.getChromeDriverPath());
        driver = new ChromeDriver();
    }
}
