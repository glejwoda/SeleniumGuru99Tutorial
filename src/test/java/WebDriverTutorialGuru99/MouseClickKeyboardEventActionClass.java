package WebDriverTutorialGuru99;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseClickKeyboardEventActionClass {

    @Test
    public void clickMouse() {
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://demo.guru99.com/test/newtours";
        driver.get(baseUrl);

        WebElement link_Home = driver.findElement(By.linkText("Home"));
        WebElement td_Home = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]"));

        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(link_Home)
                .build();

        String bgColor = td_Home.getCssValue("background-color");
        System.out.println("before hover :  " + bgColor);
        mouseOverHome.perform();
        bgColor = td_Home.getCssValue("color");
        System.out.println("after hover :  " + bgColor);

    }

    @Test
    public void seriesOfActions() {
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://www.facebook.com";
        driver.get(baseUrl);

        WebElement email = driver.findElement(By.id("email"));

        Actions builder= new Actions(driver);
        Action seriesOfActions = builder
                .moveToElement(email)
                .click()
                .keyDown(email, Keys.SHIFT)
                .sendKeys(email,"hello")
                .keyUp(email,Keys.SHIFT)
                .doubleClick(email)
                .contextClick()
                .build();

        seriesOfActions.perform();
    }
}
