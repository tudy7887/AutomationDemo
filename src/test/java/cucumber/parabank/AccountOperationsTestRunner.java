package cucumber.parabank;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue={"stepdefs/parabank"},
        features = "src/test/resources/feature/parabank/Accounts.feature")

public class AccountOperationsTestRunner extends AbstractTestNGCucumberTests {
}
