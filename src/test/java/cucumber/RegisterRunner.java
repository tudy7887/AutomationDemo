package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(glue={"stepdefs"}, features = "src/test/resources/feature", plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json" })
public class RegisterRunner {
    private WebDriver driver;
    @Before
    public void Setup(){

    }
}
