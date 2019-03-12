package ATG_Test;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class InternetDomowy20Mb {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,10);
    Actions actions = new Actions(driver);


    @Test
    public void InternetDomowy20MbTest() throws InterruptedException {

    String baseUrl = "http://sit.eplatform.t-mobile.pl/internet-domowy/cat10034.chtml";

    driver.get(baseUrl);
//    driver.manage().deleteAllCookies();
    driver.manage().getCookies();
    driver.manage().window().maximize();

    /*SPRAWDŹ ADRES */
    WebElement city  = driver.findElement(By.xpath("//input[@name='field-city']"));
        city.sendKeys("Gdańsk");



    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("0933016")));
    WebElement city_suggestion = driver.findElement(By.id("0933016"));
        city_suggestion.click();

    WebElement street = driver.findElement(By.cssSelector("#field-street"));
        street.sendKeys("Polna");

    Thread.sleep(2000);
    WebElement street_suggestion = driver.findElement(By.id("17011"));
    street_suggestion.click();


    driver.findElement(By.xpath("//input[@id='field-house-num']")).sendKeys("1");

    driver.findElement(By.xpath("//span[@class='sprawd']")).click();


        /*WYBIERZ OFERTĘ */
    driver.manage().timeouts().pageLoadTimeout(5, SECONDS);
    Thread.sleep(2000);

    WebElement choose_equipment =  driver.findElement(By.xpath("//input[@value='Dobierz sprzęt']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", choose_equipment);
        Thread.sleep(500);


    choose_equipment.click();

 /*       Action mouseOverSubmit = actions
                .moveToElement(choose_equipment).click()
                .build();
        mouseOverSubmit.perform();*/

        driver.manage().timeouts().pageLoadTimeout(60,SECONDS);
        driver.manage().timeouts().setScriptTimeout(100,SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Wybrana oferta:')]")));

//        Thread.sleep(10000);







    }
}
