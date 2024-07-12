package stepdefs.fetraining;

import fetraining.actions.CustomerDashBoardActions;
import fetraining.actions.LoginActions;
import org.testng.annotations.BeforeSuite;
import stepdefs.BaseStepDef;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigLoader;
import webdriver.Chrome;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepdefs extends BaseStepDef implements En {
    protected LoginActions loginActions;
    protected CustomerDashBoardActions customerDashBoardActions;
    protected String feTrainingPropertyFilePath = "src/test/resources/properties/FeTraining.properties";
    private String badUser, badPassword, loginError, wrongErrorMessage, userEmail, loginFailed, goodUser, goodPassword;

    public LoginStepdefs() {
        Before(()->{
            Setup();
            configLoader = new ConfigLoader(feTrainingPropertyFilePath);
            loginActions = new LoginActions(driver);
            customerDashBoardActions =  new CustomerDashBoardActions(driver);
            InitializeProperties();
        });

        After(()->{
            Teardown();
        });

        Given("^I am on the login page of the FeTraining Application$", () -> {
            InuitTest("Given: I am on the login page of the FeTraining Application");
            loginActions.GotoPage();
            AddScreenshot("Login Page", "I'm on Login Page");
        });

        Then("^I should be taken to the Customers Dashboard Page$", () -> {
            InuitTest("I should be taken to the Customers Dashboard Page");
            customerDashBoardActions.WaitUntilLoaded();
            HardAssertEqual(customerDashBoardActions.GetEmail(), userEmail, loginFailed);
        });
        When("^I enter invalid username = <username> and password = <password>$", () -> {
            InuitTest("When: I enter invalid username = <username> and password = <password>");
            ClearLoginInfo();
            loginActions.SetMail(badUser);
            loginActions.SetPassword(badPassword);
            AddScreenshot("Invalid Credentials", "I entered invalid credentials");
            loginActions.ClickLogin();
        });
        Then("^I should receive an <error>$", () -> {
            InuitTest("Then: I should receive an <error>");
            HardAssertEqual(loginActions.GetErrorMessage(), loginError, wrongErrorMessage);
        });
        When("^I enter valid customer username = <username> and password = <password>$", () -> {
            InuitTest("When: I enter valid customer username = <username> and password = <password>");
            ClearLoginInfo();
            loginActions.SetMail(goodUser);
            loginActions.SetPassword(goodPassword);
            AddScreenshot("Valid Credentials", "I entered valid credentials");
            loginActions.ClickLogin();
        });
    }

    protected void ClearLoginInfo()
    {
        loginActions.ClearMail();
        loginActions.ClearPassword();
    }

    protected String GetReportName() {
        return "FeeTrainingCucumber.html";
    }

    private void InitializeProperties(){
        badUser = configLoader.GetProperties("InvalidUser");
        badPassword = configLoader.GetProperties("InvalidPassword");
        loginError = configLoader.GetProperties("LoginError");
        wrongErrorMessage = configLoader.GetProperties("WrongErrorMessage");
        userEmail = configLoader.GetProperties("customerUser");
        loginFailed = configLoader.GetProperties("LoginFailed");
        goodUser = configLoader.GetProperties("customerUser");
        goodPassword = configLoader.GetProperties("CustomerPassword");
    }
}
