package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import selenium.TestBase;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static String screenName = "error";
    public static void captureScreenshot() throws IOException {
        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs((OutputType.FILE));

        System.out.println("FILEEEEEEEEEEEEEEEEEEE");
        FileUtils.copyFile(screenshotAs, new File("../seleniumPro/target/surefire-reports/html/"+screenName+".jpg"));
    }
}
