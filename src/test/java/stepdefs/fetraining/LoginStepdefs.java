package stepdefs.fetraining;

import basetest.BaseTest;
import fetraining.actions.CustomerDashBoardActions;
import fetraining.actions.LoginActions;
import org.testng.annotations.BeforeSuite;
import io.cucumber.java8.En;
import util.ConfigLoader;

public class LoginStepdefs extends BaseTest implements En {
    protected LoginActions loginActions;
    protected CustomerDashBoardActions customerDashBoardActions;
    protected String feTrainingPropertyFilePath = "src/test/resources/properties/FeTraining.properties";
    private String badUser, badPassword, loginError, wrongErrorMessage, userEmail, loginFailed, goodUser, goodPassword;

    public LoginStepdefs() {
        Before(()->{
            Setup();
            InuitTest("FeTraining Login Scenario");
        });

        After(()->{
            Teardown();
        });

        Given("^I am on the login page of the FeTraining Application$", () -> {
            loginActions.GotoPage();
            AddDetails("Given: I am on the login page of the FeTraining Application");
            AddScreenshot("Login Page", "FeTraining Loginn Page");
        });

        Then("^I should be taken to the Customers Dashboard Page$", () -> {
            customerDashBoardActions.WaitUntilLoaded();
            AddDetails("Then: I should be taken to the Customers Dashboard Page");
            HardAssertEqual(customerDashBoardActions.GetEmail(), userEmail, loginFailed);
        });
        When("^I enter invalid username = <username> and password = <password>$", () -> {
            ClearLoginInfo();
            loginActions.SetMail(badUser);
            loginActions.SetPassword(badPassword);
            AddDetails(String.format("When: I enter invalid %s = badUser and password = %s", badUser, badPassword));
            AddScreenshot("Invalid Credentials", "Invalid Credentials");
        });
        Then("^I should receive an <error>$", () -> {
            AddDetails("Then: I should receive an Error");
            HardAssertEqual(loginActions.GetErrorMessage(), loginError, wrongErrorMessage);
        });
        When("^I enter valid customer username = <username> and password = <password>$", () -> {
            ClearLoginInfo();
            loginActions.SetMail(goodUser);
            loginActions.SetPassword(goodPassword);
            AddDetails(String.format("When: I enter valid %s = badUser and password = %s", goodUser, goodPassword));
            AddScreenshot("Valid Credentials", "Valid Credentials");
        });
        And("^I click on Login Button$", () -> {
            loginActions.ClickLogin();
            AddDetails("And: I click on Login Button");
        });
    }

    protected void ClearLoginInfo()
    {
        loginActions.ClearMail();
        loginActions.ClearPassword();
    }

    @BeforeSuite(alwaysRun = true)
    public void Setup(){
        super.Setup();
        configLoader = new ConfigLoader(feTrainingPropertyFilePath);
        loginActions = new LoginActions(driver);
        customerDashBoardActions =  new CustomerDashBoardActions(driver);
        InitializeProperties();
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
