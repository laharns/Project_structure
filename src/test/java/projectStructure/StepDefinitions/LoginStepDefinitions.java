package projectStructure.StepDefinitions;

import projectStructure.PageObject.Login;
import projectStructure.Utils.ConfigReader;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginStepDefinitions {

    public WebDriver driver;
    public Login loginPage;
    public ConfigReader configReader;

    public LoginStepDefinitions() {
        configReader = new ConfigReader();
    }

    @When("I navigate to the login page")
    public void I_navigate_to_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client/");
        loginPage = new Login(driver);
    }

    @When("^I login with username (.+) and password (.+)$")
    public void I_login_with_username_and_password(String emailkey,String passkey) {
        configReader = new ConfigReader();
       // String testUsername = (username.equals("username")) ? configReader.getProperty("username") : username;
        //String testPassword = (password.equals("password")) ? configReader.getProperty("password") : password;
        String testUsername = configReader.getProperty(emailkey);
        String testPassword = configReader.getProperty(passkey);
        loginPage.login(testUsername, testPassword);
    }

    @Then("I should see the homepage")
    public void I_should_see_the_homepage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("homepage"), "Login was not successful. Current URL: " + currentUrl);
        driver.quit();
    }
}
