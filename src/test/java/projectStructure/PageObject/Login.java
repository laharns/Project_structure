package projectStructure.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectStructure.Locators.PageLocators;


public class Login {
   // public WebDriver driver;
    public PageLocators locators;

   /* @FindBy(id = "userEmail")
    private WebElement usernameField;

    @FindBy(id = "userPassword")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;*/

    public Login(WebDriver driver) {
       // this.driver = driver;
        //PageFactory.initElements(driver, this);
        locators = PageFactory.initElements(driver, PageLocators.class);
    }

    public void login(String username, String password) {
       locators.usernameField.sendKeys(username);
        locators.passwordField.sendKeys(password);
        locators.loginButton.click();
    }
}
