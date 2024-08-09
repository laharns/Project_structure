package projectStructure.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {
    private WebDriver driver;

    @FindBy(id = "userEmail")
    private WebElement usernameField;

    @FindBy(id = "userPassword")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
