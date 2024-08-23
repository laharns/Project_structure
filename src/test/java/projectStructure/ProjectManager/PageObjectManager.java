package projectStructure.ProjectManager;

import org.openqa.selenium.WebDriver;
import projectStructure.PageObject.Forgot;
import projectStructure.PageObject.Login;
import projectStructure.PageObject.Registration;

public class PageObjectManager  {
    public WebDriver driver;
    public Login loginPage;
    public Registration registrationPage;
    public Forgot forgotPage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }
    public Login getLoginPage() {
        if (loginPage == null) {
            loginPage = new Login(driver);
        }
        return loginPage;
    }
    public Registration geregistrationtPage() {
        if (registrationPage == null) {
            registrationPage = new Registration(driver);
        }
        return registrationPage;
    }
    public Forgot getforgotPage() {
        if (forgotPage == null) {
            forgotPage = new Forgot(driver);
        }
        return forgotPage;
    }

}
