package projectStructure.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/projectStructure", // Update with the actual path to your feature files
        glue = "projectStructure.StepDefinitions", // Packages containing step definitions
        tags = "@logindyna",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json"
        }
               // "io.qameta.allure.cucumber7jvm.AllureCucumber7Jv
)
public class LoginRunner  extends AbstractTestNGCucumberTests {
}
