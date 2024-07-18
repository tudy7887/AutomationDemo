package stepdefs.fetraining;

import basetest.BaseTest;
import fetraining.actions.CustomerDashBoardPageActions;
import fetraining.actions.LoginPageActions;
import fetraining.facade.FeTrainingFacade;
import fetraining.facade.IFeTrainingFacade;
import org.testng.annotations.BeforeSuite;
import io.cucumber.java8.En;
import util.ConfigLoader;

public class LoginStepdefs extends BaseTest implements En {
    protected IFeTrainingFacade iFeTrainingFacade;
    protected String feTrainingPropertyFilePath = "src/test/resources/properties/FeTraining.properties";
    private String invalidUser, invalidPassword, loginErrorMessage, wrongErrorMessage, userEmail, loginFailedMessage,
            customerUser, customerPassword, logoutFailedMessage, loginPageLink;

    public LoginStepdefs() {
        Before(()->{
            Setup();
            InuitTest("FeTraining Login Scenario");
        });

        After(()->{
            if(!iFeTrainingFacade.GetCurrentUrl().equals(loginPageLink)){
                Logout();
            }
            Teardown();
        });

        Given("^I am on the login page of the FeTraining Application$", () -> {
            iFeTrainingFacade.GotoLoginPage();
            AddDetails("Given: I am on the login page of the FeTraining Application");
            AddScreenshot("Login Page", "FeTraining Loginn Page");
        });

        Then("^I should be taken to the Customers Dashboard Page$", () -> {
            iFeTrainingFacade.WaitUntilCustomerDashBoardPageLoaded();
            AddDetails("Then: I should be taken to the Customers Dashboard Page");
            HardAssertEqual(iFeTrainingFacade.GetEmail(), userEmail, loginFailedMessage);
        });
        When("^I enter invalid username = <username> and password = <password>$", () -> {
            ClearLoginInfo();
            iFeTrainingFacade.SetMail(invalidUser);
            iFeTrainingFacade.SetPassword(invalidPassword);
            AddDetails(String.format("When: I enter invalid %s = badUser and password = %s", invalidUser, invalidPassword));
            AddScreenshot("Invalid Credentials", "Invalid Credentials");
        });
        Then("^I should receive an <error>$", () -> {
            AddDetails("Then: I should receive an Error");
            HardAssertEqual(iFeTrainingFacade.GetErrorMessage(), loginErrorMessage, wrongErrorMessage);
        });
        When("^I enter valid customer username = <username> and password = <password>$", () -> {
            ClearLoginInfo();
            iFeTrainingFacade.SetMail(customerUser);
            iFeTrainingFacade.SetPassword(customerPassword);
            AddDetails(String.format("When: I enter valid %s = badUser and password = %s", customerUser, customerPassword));
            AddScreenshot("Valid Credentials", "Valid Credentials");
        });
        And("^I click on Login Button$", () -> {
            iFeTrainingFacade.ClickLogin();
            AddDetails("And: I click on Login Button");
        });
    }

    protected void ClearLoginInfo()
    {
        iFeTrainingFacade.ClearMail();
        iFeTrainingFacade.ClearPassword();
    }

    private void Logout()
    {
        iFeTrainingFacade.ClickLogout();
        iFeTrainingFacade.WaitUntilLoginPageLoaded();
        HardAssertEqual(driver.getCurrentUrl(), loginPageLink, logoutFailedMessage);
    }

    @BeforeSuite(alwaysRun = true)
    public void Setup(){
        super.Setup();
        configLoader = new ConfigLoader(feTrainingPropertyFilePath);
        iFeTrainingFacade = new FeTrainingFacade(driver);
        InitializeProperties();
    }

    protected String GetReportName() {
        return "FeeTrainingLoginCucumber.html";
    }

    private void InitializeProperties(){
        loginPageLink = configLoader.GetProperties("loginPageLink");
        invalidUser = configLoader.GetProperties("invalidUser");
        invalidPassword = configLoader.GetProperties("invalidPassword");
        loginErrorMessage = configLoader.GetProperties("loginErrorMessage");
        wrongErrorMessage = configLoader.GetProperties("WrongErrorMessage");
        userEmail = configLoader.GetProperties("customerUser");
        loginFailedMessage = configLoader.GetProperties("loginFailedMessage");
        logoutFailedMessage = configLoader.GetProperties("logoutFailedMessage");
        customerUser = configLoader.GetProperties("customerUser");
        customerPassword = configLoader.GetProperties("customerPassword");
    }
}
