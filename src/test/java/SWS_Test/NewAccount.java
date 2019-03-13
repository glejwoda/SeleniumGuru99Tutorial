package SWS_Test;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import SwsObjects.AddressDataGenerator;
import SwsObjects.OtherInfoDataGenerator;
import SwsObjects.MainMenuPage;
import SwsObjects.NameSurnameGenerator;


public class NewAccount {

    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver,10);

    @Test
    public void createNewAccount()  throws Exception {

        String baseUrl = "http://oracloud-123.unx.era.pl:8001/wf13/sessionExpired.iface";
        driver.get(baseUrl);
        driver.manage().window().maximize();

    MainMenuPage mainMenuPage;
    mainMenuPage = new MainMenuPage(driver);

        mainMenuPage.clickWelcomeBtn();
        mainMenuPage.setNewOrderBtn();
        mainMenuPage.setTaskCreatorBtn();
        mainMenuPage.setDrpCustomerType();

    Thread.sleep(2000);

    //--------------------------------Imię i Nazwisko - Nazwa Firmy----------------------------------------------------------//
    NameSurnameGenerator nameSurnameGeneratorObj;
    nameSurnameGeneratorObj = new NameSurnameGenerator(driver);

        nameSurnameGeneratorObj.switchToNewTab();
        nameSurnameGeneratorObj.getGeneratedName();
        nameSurnameGeneratorObj.backToNewTab();
        nameSurnameGeneratorObj.getGeneratedSurame();

    //-------------------------------Dane adresowe (adres stały)------------------------------------------------------------//
    AddressDataGenerator addressDataGenerator;
    addressDataGenerator = new AddressDataGenerator(driver);

        addressDataGenerator.setSwitchToNewTab();
        addressDataGenerator.getGeneratedPostalCode();
        addressDataGenerator.setSwitchToNewTab();
        addressDataGenerator.getGeneratedCity();
        addressDataGenerator.setSwitchToNewTab();
        addressDataGenerator.getGeneratedStreet();
        addressDataGenerator.randomHouseNr();

    //-----------------------------Dane adresowe (adres korespondencyjny - KOPIUJ)-------------------------------------//

    WebElement copyAddress = driver.findElement(By.id("rc:0:di0:ts:0:rc:15:di5:asr"));
    copyAddress.click();



   //------------------------------Inne informacje--------------------------------------------------------------------------------//
    Thread.sleep(2000);
    Select drpTraceCode = new Select(driver.findElement(By.id("rc:0:di0:ts:0:rc:24:di0:value")));
    WebElement traceCode = driver.findElement(By.id("rc:0:di0:ts:0:rc:24:di0:value"));
    wait.until(ExpectedConditions.elementToBeClickable(traceCode));
    drpTraceCode.selectByIndex(1);

        OtherInfoDataGenerator otherInfoDataGenerator;
        otherInfoDataGenerator = new OtherInfoDataGenerator(driver);

        otherInfoDataGenerator.randomDayOfBirth();
        otherInfoDataGenerator.setSwitchToNewTab();
        otherInfoDataGenerator.getGeneratedIDCard();
        otherInfoDataGenerator.getGeneratedPesel();
        otherInfoDataGenerator.setEmailAddres();
        otherInfoDataGenerator.submitCreateAccount();

    }

}
