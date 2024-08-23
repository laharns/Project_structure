package projectStructure.StepDefinitions;

import projectStructure.PageObject.Login;
import projectStructure.ProjectManager.PageObjectManager;
import projectStructure.Utils.ConfigReader;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginStepDefinitions {

    public WebDriver driver;
   public Login loginPage;
   public PageObjectManager pageObjectManager;
    public ConfigReader configReader;

    public LoginStepDefinitions() {
       // configReader = new ConfigReader();
    }

    @When("I navigate to the login page")
    public void I_navigate_to_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client/");
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
       // loginPage = new Login(driver);
    }

    @When("^I login with username (.+) and password (.+)$")
    public void I_login_with_username_and_password(String email,String pass) throws InterruptedException {
        configReader = new ConfigReader(System.getProperty("user.dir") + "/src/test/java/projectStructure/testdata.properties");
       // String testUsername = (username.equals("username")) ? configReader.getProperty("username") : username;
        //String testPassword = (password.equals("password")) ? configReader.getProperty("password") : password;
        String testUsername = configReader.getProperty(email);
        String testPassword = configReader.getProperty(pass);

        loginPage.login(testUsername, testPassword);
    }

    @Then("I should see the homepage")
    public void I_should_see_the_homepage()  {
        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("homepage"), "Login was not successful. Current URL: " + currentUrl);
        driver.close();
    }
}
