package activities;

        import org.testng.Assert;
        import org.testng.annotations.Test;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.AfterClass;
        import io.appium.java_client.MobileBy;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.android.AndroidDriver;
        import java.net.MalformedURLException;
        import java.net.URL;
        import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity1 {
    // Declare Android driver
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(serverURL, caps);
    }

    @Test
    public void multiplicationTest() {
        // find 5
        MobileElement digit5 = driver.findElementById("digit_5");
        //Click 5
        digit5.click();
        // find multiplication
        driver.findElementByAccessibilityId("multiply").click();
        // click 5 again
        digit5.click();
        //find equals
        driver.findElementByAccessibilityId("equals").click();

        // Get Result
        String resultValue = driver.findElementById("result").getText();

        // Assertion
        Assert.assertEquals(resultValue, "25");
    }

    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }
}
