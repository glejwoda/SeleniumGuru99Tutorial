package WebDriverTutorialGuru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTutorialHowtoClickonImageinSeleniumWebdriver {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";

        driver.get(baseUrl);
        driver.findElement(By.xpath("//i[@class='fb_logo img sp_h-X7hbBos5D sx_ca0659']")).click();

        System.out.println(driver.getTitle());

        if (driver.getTitle().equals("Facebook – zaloguj się lub zarejestruj")){
            System.out.println("We are back at hompage");
        }else{
            System.out.println("We are not at FB homepage");
        }
        driver.close();
    }
}
