package sws_objects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MainMenuPage {

    WebDriver driver;

    public MainMenuPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Zapraszamy ponownie!')]")  WebElement welcomeBtn;
    @FindBy(xpath = "//a[@id='naviButtonsWidget:j_idt390']") WebElement newOrderBtn;
    @FindBy(name = "taskCreator") WebElement taskCreatorBtn;



    public void clickWelcomeBtn() {
        welcomeBtn.click();
    }

    public void setNewOrderBtn() {
        newOrderBtn.click();
    }

    public void setTaskCreatorBtn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(taskCreatorBtn));
        System.out.println("taskCreatorBtn element enabled is : "+ taskCreatorBtn.isEnabled());
        taskCreatorBtn.click();
    }

    public void setDrpCustomerType() {
        driver.manage().timeouts().implicitlyWait(15, SECONDS);
        Select dropdown = new Select(driver.findElement(By.id("rc:0:di0:ts:0:rc:1:di0:value")));
        dropdown.selectByVisibleText("Klient prywatny");
    }



}
