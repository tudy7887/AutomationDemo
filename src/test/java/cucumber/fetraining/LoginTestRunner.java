package cucumber.fetraining;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"stepdefs/fetraining"},
        features = "src/test/resources/feature/fetraining/Login.feature")
public class LoginTestRunner {
}
