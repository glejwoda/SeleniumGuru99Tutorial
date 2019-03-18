package WebDriverTutorialGuru99;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class UploadDownloadAFile10Lesson {

    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() throws Exception {
        String baseUrl = "http://demo.guru99.com/test/yahoo.html";
        WebDriver driver = new FirefoxDriver();
    }

    @Test
    public void downloadFileTest() {
        driver.get(baseUrl);
        WebElement downloadButton = driver.findElement(By
                .id("messenger-download"));
        String sourceLocation = downloadButton.getAttribute("href");
        String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

        try {
            Process exec = Runtime.getRuntime().exec(wget_command);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
        driver.close();
    }

}
