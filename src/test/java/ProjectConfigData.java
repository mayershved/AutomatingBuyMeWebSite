import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 *
 */
public class ProjectConfigData {

    private static final String CONFIGFILEPATH = "/Users/igor_shved/Documents/Java/QA_Experts/QA_Projects/Selenium/AutomatingBuyMeWebSite/config_buy_me.xml";

    private String browserType = getDataFromXml("browserType");
    private String chromeDriverPath = getDataFromXml("chromeDriverPath");
    private String firefoxDriverPath = getDataFromXml("firefoxDriverPath");
    private String buyMeLandingPageUrl = getDataFromXml("buyMeLandingPageUrl");
    private String extentReportsFilePath = getDataFromXml("extentReportsFilePath");
    private String screenShotPath = getDataFromXml("screenShotPath");


    public String getBrowserType(){
        return this.browserType;
    }

    public String getChromeDriverPath(){
        return this.chromeDriverPath;
    }

    public String getFirefoxDriverPath(){
        return this.firefoxDriverPath;
    }

    public String getBuyMeLandingPageUrl(){
        return  this.buyMeLandingPageUrl;
    }

    public String getExtentReportsFilePath(){
        return this.extentReportsFilePath;
    }

    public String getScreenShotPath(){
        return this.screenShotPath;
    }

    /***
     * This method is used to read data from XML file
     * @param tagName tag name from XML project config file
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
