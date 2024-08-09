package projectStructure.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import projectStructure.PageObject.Forgot;
import projectStructure.PageObject.Registration;
import projectStructure.ProjectManager.PageObjectManager;
import projectStructure.Utils.ConfigReader;


public class ForgotStepDefinitions {
    public WebDriver driver;
    public Forgot forgotPage;
    public ConfigReader configReader;
    public PageObjectManager pageObjectManager;

    public ForgotStepDefinitions() {
       // configReader = new ConfigReader();
    }

    @Given("I forgot open the browser")
    public void I_forgot_open_the_browser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @When("I navigate to the forgot page")
    public void I_navigate_to_the_forgot_page() {
        driver.get("https://rahulshettyacademy.com/client/");
        pageObjectManager = new PageObjectManager(driver);
        forgotPage = pageObjectManager.getforgotPage();

    }
    @And("I click on the forgot button")
    public void I_click_on_the_forgot_button() {
      //  forgotPage = new Forgot(driver);
        forgotPage.clickforgotButton();
    }
    @And("I enter valid forgot details")
    public void I_enter_valid_forgot_details(){
        configReader = new ConfigReader();
        String testemail = configReader.getProperty("emailfiled");
        String tesfpassword = configReader.getProperty("fopasswordfiled");
        String tesfcpassword = configReader.getProperty("focpasswordfiled");
        forgotPage.forgot(testemail,tesfpassword,tesfcpassword);

    }
    @Then("I submit the Forgot form")
    public void I_submit_the_Forgot_form(){
        driver.quit();

    }


}
