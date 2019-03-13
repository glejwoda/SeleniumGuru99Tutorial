package SwsObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class NameSurnameGenerator {

    WebDriver driver;

    @FindBy(xpath = "//div[10]//div[1]//p[1]//button[3]")
    WebElement generatedName;
    @FindBy(xpath = "//div[11]//div[1]//p[1]//button[3]")
    WebElement generatedSurname;
    @FindBy(id = "rc:0:di0:ts:0:rc:5:di1:sltr")
    WebElement nameField;
    @FindBy(id = "rc:0:di0:ts:0:rc:6:di1:sltr")
    WebElement surnameField;

    public NameSurnameGenerator(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void switchToNewTab (){
        ((JavascriptExecutor)driver).executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://generuj.co.pl/");
    }

    public String getGeneratedName() {
        String text = generatedName.getText();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        nameField.sendKeys(text);
        return text;
    }

    public void backToNewTab (){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public String getGeneratedSurame() {
        String text = generatedSurname.getText();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        surnameField.sendKeys(text + "Testowy");
        return text;
    }

}
