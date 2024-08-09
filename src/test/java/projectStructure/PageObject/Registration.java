package projectStructure.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registration {
    private WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Register']")
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
    private WebElement RegisterButton;

    public Registration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterButton() {
        btnregister.click();
    }
    public void register(String firstName, String lastName, String email, String mobile, String Rpassword, String confirmPassword, boolean acceptTerms) {
        firstnamefiled.sendKeys(firstName);
        lastnamefiled.sendKeys(lastName);
        useremailfiled.sendKeys(email);
        usermobilefiled.sendKeys(mobile);
        userpasswordfiled.sendKeys(Rpassword);
        userconfirmpasswordfiled.sendKeys(confirmPassword);
        if (acceptTerms) {
            if (!usercheckboxfiled.isSelected()) {
                usercheckboxfiled.click();
            }
        }
        RegisterButton.click();
    }














}
