import org.openqa.selenium.WebDriver;

/**
 *
 */
public class SingletonDriver {

    // static variable single_instance of type Singleton
    private static SingletonDriver single_instance = null;

    // variable of type String
    public WebDriver driver;

    // private constructor restricted to this class itself
    private SingletonDriver()
    {

    }

    // static method to create instance of Singleton class
    public static SingletonDriver getInstance()
    {
        if (single_instance == null)
            single_instance = new SingletonDriver();

        return single_instance;
    }
}
