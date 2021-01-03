package commonLibs.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenShotUtils {

    private TakesScreenshot takesScreenshot;
    public ScreenShotUtils(WebDriver driver){

        takesScreenshot = (TakesScreenshot) driver;
    }

    public void captureAndSaveScreenShot(String filename) throws Exception{
        filename = filename.trim();
        File imageFile;
        File tempFile;
        imageFile = new File(filename);

        if (imageFile.exists()){
            throw  new Exception("File Already Exist");
        }

        tempFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.moveFile(tempFile,imageFile);
    }
}
