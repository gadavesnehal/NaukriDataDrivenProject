package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import testbase.WebTestBase;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtility extends WebTestBase {

    public static void takeScreenshotUtility(String filename) {

        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(f , new File("C:\\Users\\Rahul\\Desktop\\Edubridge\\Selenium\\Selenium codes\\NaukriComProject4\\src\\test\\screenshotsfolder\\" + filename +  ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public ScreenshotUtility() throws IOException {
    }
}
