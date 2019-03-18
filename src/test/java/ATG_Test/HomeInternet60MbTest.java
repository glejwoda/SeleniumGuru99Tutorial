package ATG_Test;

import AtgObjects.HomeInternet60MbObjects;
import WebDriverTutorialGuru99.JSErrorsLogging;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;


public class HomeInternet60MbTest {
     WebDriver driver;
     WebDriverWait wait;
     Actions actions;
     boolean acceptNextAlert = true;
     StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
/*        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(capabilities); //in cognito mode*/
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,10);
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testIHomeInternet60Mb() throws Exception {

        HomeInternet60MbObjects homeInternet60MbObjects;
        homeInternet60MbObjects = new HomeInternet60MbObjects(driver);

        homeInternet60MbObjects.setAllElements();

    }

    @After
    public void tearDown() throws Exception {
//        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
