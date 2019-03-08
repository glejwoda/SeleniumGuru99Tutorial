package WebDriverTutorialGuru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesAndRadioButtons {

    private static  WebDriver driver = null;

    public static void main(String[] args) {

        driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/test/radio.html");
        driver.manage().window().fullscreen();

        WebElement radio_1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radio_2 = driver.findElement(By.id("vfb-7-2"));
        WebElement radio_3 = driver.findElement(By.id("vfb-7-3"));

        radio_1.click();
        System.out.println("Radio button one is selected");

        radio_2.click();
        System.out.println("Radio button two is selected");

        driver.close();


    }
}
