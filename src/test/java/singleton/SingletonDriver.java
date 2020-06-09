package singleton;

import commonMethods.ProjectConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 *SingletonDriver class wrapes driver instance of WebDrive class that is used globaly in the project
 */
public class SingletonDriver {

    // static variable instance of type SingletonDriver
    private static SingletonDriver instance = null;

    // instance of WebDriver class
    public WebDriver driver;

    // static method to create instance of SingletonDriver class
    public static synchronized SingletonDriver getInstance()
    {
        if (instance == null) {
            instance = new SingletonDriver();
        }
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
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
