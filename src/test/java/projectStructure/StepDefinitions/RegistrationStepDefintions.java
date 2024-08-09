package projectStructure.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import projectStructure.PageObject.Registration;
import projectStructure.Utils.ConfigReader;

public class RegistrationStepDefintions {
    public WebDriver driver;
    public Registration registrationPage;
    public ConfigReader configReader;

    @Given("I open the browser")
    public void I_open_the_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("I navigate to the registration page")
    public void I_navigate_to_the_registration_page() {
        driver.get("https://rahulshettyacademy.com/client/");
    }

    @And("I click on the register button")
    public void I_click_on_the_register_button() {
        registrationPage = new Registration(driver); // Initialize the page object
        registrationPage.clickRegisterButton(); // Click the register button/link
    }

    @And("I enter valid registration details")
    public void I_enter_valid_registration_details() {
        configReader = new ConfigReader();
        String testfirstname = configReader.getProperty("firstName");
        String testlastname = configReader.getProperty("lastName");
        String testemail = configReader.getProperty("email");
        String testmobile = configReader.getProperty("mobile");
        String testRpassword = configReader.getProperty("Rpassword");
        String testRCpassword = configReader.getProperty("confirmPassword");
        boolean testacceptTerms = configReader.getBooleanProperty("usercheckboxfiled");

        registrationPage.register(testfirstname, testlastname, testemail, testmobile, testRpassword, testRCpassword, testacceptTerms);


    }

    @Then("I submit the registration form")
    public void I_submit_the_registration_form() {

    }

}
