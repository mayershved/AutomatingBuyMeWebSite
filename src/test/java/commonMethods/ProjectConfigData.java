package commonMethods;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * ProjectConfigData class implements to read data from xml file
 * by calling getDataFromXml method, and getters to access class fields
 * where is stored data from xml file
 *
 * @author Meir Shved
 */
public class ProjectConfigData {

    // variable that stores path to xml file
    private static final String CONFIGFILEPATH = "/Users/igor_shved/Documents/Java/QA_Experts/QA_Projects/Selenium/AutomatingBuyMeWebSite/config_buy_me.xml";

    // class variables that contain data from xml file
    private String browserType = getDataFromXml("browserType");
    private String chromeDriverPath = getDataFromXml("chromeDriverPath");
    private String firefoxDriverPath = getDataFromXml("firefoxDriverPath");
    private String buyMeLandingPageUrl = getDataFromXml("buyMeLandingPageUrl");
    private String extentReportsFilePath = getDataFromXml("extentReportsFilePath");
    private String screenShotPath = getDataFromXml("screenShotPath");
    private String userFirstName = getDataFromXml("userFirstName");
    private String userEmail = getDataFromXml("userEmail");
    private String userPassword = getDataFromXml("userPassword");

    /***
     * class field getter
     * @return
     */
    public String getBrowserType(){
        return this.browserType;
    }

    /**
     *class field getter
     * @return
     */
    public String getChromeDriverPath(){
        return this.chromeDriverPath;
    }

    /**
     *class field getter
     * @return
     */
    public String getFirefoxDriverPath(){
        return this.firefoxDriverPath;
    }

    /**
     *class field getter
     * @return
     */
    public String getBuyMeLandingPageUrl(){
        return  this.buyMeLandingPageUrl;
    }

    /**
     *class field getter
     * @return
     */
    public String getExtentReportsFilePath(){
        return this.extentReportsFilePath;
    }

    /**
     *class field getter
     * @return
     */
    public String getScreenShotPath(){
        return this.screenShotPath;
    }

    /**
     *class field getter
     * @return
     */
    public String getUserFirstName(){
        return this.userFirstName;
    }

    /**
     *class field getter
     * @return
     */
    public String getUserEmail(){
        return this.userEmail;
    }

    /**
     *class field getter
     * @return
     */
    public String getUserPassword(){
        return this.userPassword;
    }

    /***
     * This method is used to read data from XML file
     * @param tagName tag name from XML project data file
     * @return string from tagName
     */
    private static String getDataFromXml(String tagName) {

        File configXmlFile = new File(CONFIGFILEPATH);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            assert dBuilder != null;
            doc = dBuilder.parse(configXmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(tagName).item(0).getTextContent();
    }
}
