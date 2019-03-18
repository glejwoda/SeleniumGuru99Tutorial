package WebDriverTutorialGuru99;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.logging.Level;

public class JSErrorsLogging {

        private WebDriver driver;

    public JSErrorsLogging(WebDriver driver) {
        this.driver=driver;
    }

    @BeforeMethod
        public void setUp() {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            LoggingPreferences loggingprefs = new LoggingPreferences();
            loggingprefs.enable(LogType.BROWSER, Level.ALL);
            capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
            driver = new ChromeDriver(capabilities);
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
        public void ExtractJSLogs() {
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logEntries) {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            }
        }
        @Test
        public void testMethod() {
            driver.get("https://sit.eplatform.t-mobile.pl/internet-domowy/cat10034.chtml?_DARGS=/blocks/lists/plans/postpaid/fms_address_form.jsp#");
            ExtractJSLogs();
        }
    }
