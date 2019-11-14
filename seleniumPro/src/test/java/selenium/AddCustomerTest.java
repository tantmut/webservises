package selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String postCode, String alertText) throws InterruptedException {

        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("addCusBtn"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();

//          wait.until(ExpectedConditions.alertIsPresent());
//
//        Assert.assertTrue(alert.getText().contains(alertText));

        Assert.fail();
    }

    @DataProvider
    public Object[][] getData(){

        return new Object[][] {
                {"nazar","yaremko", "dldll", "Customer added successfully with customer id"}
        };

    }
}
