package WebDriverTutorialGuru99;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocateElementsbyLinkTextPartialLinkTextinSeleniumWebdriver {



    @Test
    public void SauceDemoTest () {

        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.ultimateqa.com/dummy-automation-websites/";
        driver.get(baseUrl);

        driver.findElement(By.linkText("SauceDemo E-Commerce")).click();
        System.out.println("title of page is  " + driver.getTitle());
        driver.close();
        }

    @Test
    public void SauceDemoTest1 () {

        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.ultimateqa.com/dummy-automation-websites/";
        driver.get(baseUrl);

        driver.findElement(By.partialLinkText("Ultimate QA")).click();
        System.out.println("title of page is  " + driver.getTitle());
        driver.close();
        }

    @Test
    public void SauceDemoTest3 () {

        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.ultimateqa.com/dummy-automation-websites/";
        driver.get(baseUrl);

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            System.out.println(link.getText());
        }
        driver.close();
        }

    }
