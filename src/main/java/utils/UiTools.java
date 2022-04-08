package utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class UiTools {

    protected final Logger log = Logger.getLogger(getClass());

    public void makeScreenShot(WebDriver webDriver,  String screenShotName) {
        TakesScreenshot scrShot = ((TakesScreenshot)webDriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("C:\\comPecode\\results\\" + screenShotName + ".jpg");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            log.info("Something happened when making screenshot with message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
