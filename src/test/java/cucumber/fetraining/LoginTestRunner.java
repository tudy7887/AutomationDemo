package cucumber.fetraining;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue={"stepdefs/fetraining"},
        features = "src/test/resources/feature/fetraining/Login.feature")

public class LoginTestRunner extends AbstractTestNGCucumberTests {
}
