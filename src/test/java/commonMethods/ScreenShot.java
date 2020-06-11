package commonMethods;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

/**
 * This class contrain methods to take ScreenShot
 * and add it to certain test report
 * @author Mayer Shved
 */
public class ScreenShot {

    // class fields
    private static ProjectConfigData configData = new ProjectConfigData();
    private static final String pathToSaveScreenShot = configData.getScreenShotPath();
    private WebDriver driver;

    /***
     *
     * This method on calling take screenshot and return it
     * @param pahtToScreenShot path where to save screenshot
     * @return screenshot
     */
    private String takeScreenShot(String pahtToScreenShot) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(pahtToScreenShot+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return pahtToScreenShot+".png";
    }

    /**
     * this method take screenshot
     * and place to test report
     * specified by method parameter testReport
     * @param details screenshot case description
     * @param testReport specifies ExtentTest report place for screenshot
     * @throws IOException
     */
    public void setScreenShotToReportDetails(String details, ExtentTest testReport) throws IOException {
        String currentTime = String.valueOf(System.currentTimeMillis());
        testReport.pass(details, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(pathToSaveScreenShot + currentTime)).build());
    }

    /**
     * class constructor
     * @param driver
     */
    public ScreenShot(WebDriver driver){
        this.driver = driver;
    }
}
