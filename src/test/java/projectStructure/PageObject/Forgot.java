package projectStructure.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgot {
    private WebDriver driver;

    @FindBy(xpath = "//a[@class='forgot-password-link']")
    private WebElement btnforgot;

    @FindBy(xpath = "//input[@placeholder='Enter your email address']")
    private WebElement emailfiled;

    @FindBy(xpath = "//input[@id='userPassword']")
    private WebElement fopasswordfiled;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement focpasswordfiled;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement forgotButton;

    public Forgot(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickforgotButton() {
        btnforgot.click();
    }

    public void forgot(String femail,String fpassword, String fcpassword){
        emailfiled.sendKeys(femail);
        fopasswordfiled.sendKeys(fpassword);
        focpasswordfiled.sendKeys(fcpassword);
        forgotButton.click();
    }
}
