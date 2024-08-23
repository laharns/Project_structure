package projectStructure.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projectStructure.Utils.ConfigReader;


public class Login {
    public WebDriver driver;
   // public PageLocators locators; // locatore file in java class
   // private LocatorReader locatorReader; // locatore file in properties
       private ConfigReader configReader;

   /* @FindBy(id = "userEmail")
    private WebElement usernameField;

    @FindBy(id = "userPassword")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;*/

    public Login(WebDriver driver) {
       this.driver = driver;
        //PageFactory.initElements(driver, this);
        //locators = PageFactory.initElements(driver, PageLocators.class); //locatore file in java class
        this.configReader = new ConfigReader(System.getProperty("user.dir") + "/src/test/java/projectStructure/locators.properties");
    }

    public void login(String email, String pass) {
        /*locators.usernameField.sendKeys(username);
        locators.passwordField.sendKeys(password);
        locators.loginButton.click();*/
        WebElement usernameField = configReader.getElement(driver, "login.usernameField.id");
        WebElement passwordField = configReader.getElement(driver, "login.passwordField.id");
        WebElement loginButton = configReader.getElement(driver, "login.loginButton.id");

        usernameField.sendKeys(email);
        passwordField.sendKeys(pass);
        loginButton.click();
        driver.quit();

    }
}
    