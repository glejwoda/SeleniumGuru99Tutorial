package sws_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Random;

public class AddressDataGenerator {

    WebDriver driver;

    public AddressDataGenerator (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //------------------------fields in SWS to fill----------------------------------//
    @FindBy(id = "rc:0:di0:ts:0:rc:9:di1:sltr") WebElement postalCodeField;
    @FindBy(id = "rc:0:di0:ts:0:rc:10:di1:sltr") WebElement cityField;
    @FindBy(id = "rc:0:di0:ts:0:rc:11:di1:sltr") WebElement streetField;
    @FindBy(id = "rc:0:di0:ts:0:rc:12:di1:sltr") WebElement houseNrField;
    //------------------------generated data  from generator -----------------//
    @FindBy(xpath = "//div[17]//div[1]//p[1]//button[2]") WebElement generatedPostalCode;
    @FindBy(xpath = "//div[16]//div[1]//p[1]//button[2]") WebElement generatedCity;
    @FindBy(xpath = "//div[15]//div[1]//p[1]//button[2]") WebElement generatedStreet;


    public void setSwitchToNewTab (){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public String getGeneratedPostalCode() {
        String text = generatedPostalCode.getText();
            System.out.println("generatedPostalCode is : "+ text);

        //Switch to Old Tab//
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

       //fill postalCodeField //
        postalCodeField.sendKeys(text);
        return text;
    }

    public String getGeneratedCity() {
        String text = generatedCity.getText();
        System.out.println("generatedCity is : "+ text);

        //Switch to Old Tab//
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        //fill postalCodeField //
        cityField.sendKeys(text);
        return text;
    }

    public String getGeneratedStreet() {
        String text = generatedStreet.getText();
        System.out.println("generatedStreet is : "+ text);

        //Switch to Old Tab//
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        //fill postalCodeField //
        streetField.sendKeys(text);
        return text;
    }

    public Integer randomHouseNr(){

        Random ran = new Random();
        int x = ran.nextInt(6) + 5;
        houseNrField.sendKeys(String.valueOf(x));
        return x;
    }

}
