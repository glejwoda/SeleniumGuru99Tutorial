package WebDriverTutorialGuru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*test scenario
    1.	fetch Mercury Tours' homepage
    2.	verify its title
    3.	print out the result of the comparison
    4.	close it before ending the entire program.
.*/


public class FirstWebdriverScript {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        String baseUrl = "https://www.ultimateqa.com/complicated-page";
        String expectedTitle = "Home - Ultimate QA";
        String actualTitle = "";

        driver.get(baseUrl);
        actualTitle = driver.getTitle();
        System.out.println(expectedTitle);

        /*compare the actual title of the page with the expected one and print the result as "Passed" or "Failed" */

        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        driver.getPageSource();

        WebElement element = driver.findElement(By.id("user_pass_5c579a076faf7"));
        WebElement element_1 = driver.findElement(By.id("user_pass_5c579a076faf7"));
        element.sendKeys("janusz123");


//        driver.close();
    }
}
