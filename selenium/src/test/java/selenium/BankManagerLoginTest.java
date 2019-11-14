package selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {

        log.debug("inside Login Test");
        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();

        Thread.sleep(3000);

        Assert.assertTrue("Login not successfull",isElementPresernt(By.cssSelector(OR.getProperty("addCusBtn"))));
        log.debug("Succesfully execute  Test");


    }
}
