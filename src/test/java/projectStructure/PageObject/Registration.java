package projectStructure.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import projectStructure.Locators.PageLocators;

import java.time.Duration;

public class Registration {
    public PageLocators locators;

   /* @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement btnregister;

    @FindBy(id = "firstName")
    private WebElement firstnamefiled;

    @FindBy(id = "lastName")
    private WebElement lastnamefiled;

    @FindBy(id = "userEmail")
    private WebElement useremailfiled;

    @FindBy(id = "userMobile")
    private WebElement usermobilefiled;

    @FindBy(id = "userPassword")
    private WebElement userpasswordfiled;

    @FindBy(id = "confirmPassword")
    private WebElement userconfirmpasswordfiled;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement usercheckboxfiled;

    @FindBy(id = "login")
    private WebElement RegisterButton;*/

    public Registration(WebDriver driver) {
        //this.driver = driver;
        //PageFactory.initElements(driver, this);
        locators = PageFactory.initElements(driver, PageLocators.class);

    }

    public void clickRegisterButton() {
        locators.btnregister.click();
    }
    public void register(String firstName, String lastName, String email, String mobile, String Rpassword, String confirmPassword, boolean acceptTerms) {
        locators.firstnamefiled.sendKeys(firstName);
        locators.lastnamefiled.sendKeys(lastName);
        locators.useremailfiled.sendKeys(email);
        locators.usermobilefiled.sendKeys(mobile);
        locators.userpasswordfiled.sendKeys(Rpassword);
        locators.userconfirmpasswordfiled.sendKeys(confirmPassword);
        if (acceptTerms) {
            if (!locators.usercheckboxfiled.isSelected()) {
                locators.usercheckboxfiled.click();
            }
        }
        locators.RegisterButton.click();
    }














}
