package projectStructure.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageLocators {

    //Login page Locators
    @FindBy(id = "userEmail") public WebElement usernameField;
    @FindBy(id = "userPassword") public WebElement passwordField;
    @FindBy(id = "login") public WebElement loginButton;

    // Registration Page Locators
    @FindBy(xpath = "//a[normalize-space()='Register']") public WebElement btnregister;
    @FindBy(id = "firstName") public WebElement firstnamefiled;
    @FindBy(id = "lastName")  public WebElement lastnamefiled;
    @FindBy(id = "userEmail") public WebElement useremailfiled;
    @FindBy(id = "userMobile") public WebElement usermobilefiled;
    @FindBy(id = "userPassword") public WebElement userpasswordfiled;
    @FindBy(id = "confirmPassword") public WebElement userconfirmpasswordfiled;
    @FindBy(xpath = "//input[@type='checkbox']") public WebElement usercheckboxfiled;
    @FindBy(id = "login") public WebElement RegisterButton;

}
