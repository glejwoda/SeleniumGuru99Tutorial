package sws_objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class OtherInfoDataGenerator {

    WebDriver driver;

    public OtherInfoDataGenerator(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*   SWS FIELDS TO FILL     */
    @FindBy(id = "rc:0:di0:ts:0:rc:25:di6:ddr")  WebElement birthdayField;
    @FindBy(id = "rc:0:di0:ts:0:rc:26:di1:sltr")  WebElement idCardField;
    @FindBy(id = "rc:0:di0:ts:0:rc:27:di1:sltr")  WebElement peselField;
    @FindBy(id = "rc:0:di0:ts:0:rc:30:di1:sltr")  WebElement emailField;
    @FindBy(linkText = "Utwórz klienta")  WebElement submitField;

    /*Generated data from generator*/
    @FindBy(css = "#idNumberBox")  WebElement generatedIDCard;
    @FindBy(css = "#peselBox")  WebElement generatedPesel;


    public void randomDayOfBirth() throws InterruptedException {
        Long max = 0L;
        Long min = 100000000000L;
        //Use the date format that best suites you
        SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");

        for (int i = 1; i <= 1; i++) {
            Random r = new Random();
            Long randomLong = (r.nextLong() % (max - min)) + min;
            Date dt = new Date(randomLong);

            String dateOfBirth = (spf.format(dt));

            Thread.sleep(2000);
            birthdayField.sendKeys(dateOfBirth);
            birthdayField.sendKeys(Keys.TAB);
                System.out.println("generated DoB is : "+ dateOfBirth);
        }
    }

    public void setSwitchToNewTab (){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://generatory.it/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    public String getGeneratedIDCard() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(generatedIDCard));
        String text = generatedIDCard.getText();
        System.out.println("IDCard is : "+ text);

        //Switch to Old Tab//
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        //fill postalCodeField //
        idCardField.sendKeys(text);
        return text;
    }

    public String getGeneratedPesel () {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String text = generatedPesel.getText();
        System.out.println("generatedPesel  is : "+ text);

        //Switch to Old Tab//
        driver.switchTo().window(tabs.get(0));

        //fill postalCodeField //
        peselField.sendKeys(text);
        return text;
    }

    public void setEmailAddres(){
        emailField.sendKeys("Grzegorz.Lejwoda@external.t-mobile.pl");
    }

    public void submitCreateAccount(){
        submitField.click();
    }

}









