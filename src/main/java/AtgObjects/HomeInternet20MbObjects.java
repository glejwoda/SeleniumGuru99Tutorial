package AtgObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomeInternet20MbObjects {

     WebDriver driver;
     WebDriverWait wait;

    public HomeInternet20MbObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void setAllElements() throws Exception {
        Actions actions = new Actions(driver);
        driver.get("https://sit.eplatform.t-mobile.pl/");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Polityce Cookies'])[1]/following::button[1]")).click();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Oferta'])[2]/following::span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"ntmMainMenu\"]/div[3]/div/div[1]/a")).click();
        driver.findElement(By.id("field-city")).click();
        driver.findElement(By.id("field-city")).clear();
        driver.findElement(By.id("field-city")).sendKeys("Gdańsk");
        driver.findElement(By.id("0933016")).click();
        driver.findElement(By.id("field-street")).click();
        driver.findElement(By.id("field-street")).clear();
        driver.findElement(By.id("field-street")).sendKeys("Polna");
        driver.findElement(By.id("17011")).click();
        driver.findElement(By.id("field-house-num")).click();
        driver.findElement(By.id("field-house-num")).clear();
        driver.findElement(By.id("field-house-num")).sendKeys("1");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='nr domu:'])[1]/following::button[1]")).click();
        driver.findElement(By.id("select_tariprom_39702")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtruj'])[2]/following::img[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Zamawiam'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Dalej')]")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        WebElement dalej_btn = driver.findElement(By.xpath("//*[@id=\"basket-summary-container\"]/div[2]/button"));

        Action mouseOverSubmit = actions
                .moveToElement(dalej_btn)
                .click(dalej_btn)
                .build();

        mouseOverSubmit.perform();

    }
}
