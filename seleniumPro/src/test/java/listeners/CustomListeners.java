package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utils.TestUtil;

import java.io.IOException;

public class CustomListeners implements ITestListener {

    public void onTestFailure(ITestResult arg0)
    {
        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.log("Capturing screenshot");
        Reporter.log("<a target=\"_blank\" href=\""+TestUtil.screenName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=\""+TestUtil.screenName+"><img src="+TestUtil.screenName+" height=200 width=200</img></a>");
    }
}
