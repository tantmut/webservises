package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static WebDriverWait wait ;


    @BeforeSuite
    public void setUp() throws IOException {
        if (driver == null) {
            fis = new FileInputStream(System.getProperty("user.home") + "/IdeaProjects/selenium/src/test/resources/Config.properties");
            log.debug("Config file loaded !!!");
            config.load(fis);

            fis = new FileInputStream(System.getProperty("user.home") + "/IdeaProjects/selenium/src/test/resources/OR.properties");
            OR.load(fis);
            log.debug("OR file loaded !!!");

        }
        if (config.getProperty("browser").equals("fireforx")) {
            System.setProperty("webdriver.gecko.driver", "gecko");
            driver = new FirefoxDriver();
        } else if (config.getProperty("browser").equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/IdeaProjects/selenium/src/test/resources/chromedriver");
            driver = new ChromeDriver();
            log.debug("Chrome launch");

        }

        driver.get(config.getProperty("testsiteurl"));
        log.debug("Navigate to :" +config.getProperty("testsiteurl"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,5);

    }

    @AfterSuite
    public void tearDown() {
        if(driver != null){
            driver.quit();
            log.debug("Succesfully execute  Test");

        }
    }

    public boolean isElementPresernt(By by){
        try{
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
