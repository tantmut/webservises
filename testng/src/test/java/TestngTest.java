import org.testng.annotations.*;

public class TestngTest {


    @BeforeSuite
    public void setUp(){
        System.out.println("BeforeSuite setup system property for chrome");
    }


    @BeforeClass
    public void launchBrowser(){
        System.out.println("BeforeClass launch chrome Browser");
    }

    @BeforeTest
    public void login(){
        System.out.println("BeforeTest login to app");
    }

    @BeforeMethod
    public void enterUrl(){
        System.out.println("BeforeMethod enter an url");
    }

    @Test
    public void googleTitleTest(){
        System.out.println("Google title test");
    }

    @Test
    public void booTitileTest(){
        System.out.println("Boo title test");
    }

    @AfterMethod
    public void logut(){
        System.out.println("AfterMethod logout from app");
    }

    @AfterTest
    public void deleteAllCookies(){
        System.out.println("AfterTest delete all cookies");
    }

    @AfterClass
    public void closeBrowser(){
        System.out.println("AfterClass close browser");
    }

    @AfterSuite
    public void generateTestReport(){
        System.out.println("AfterSuite generateTestReport");
    }
}
