package testng.fetraining;

import fetraining.facade.FeTrainingFacade;
import fetraining.facade.IFeTrainingFacade;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import basetest.BaseTest;
import util.ConfigLoader;

// user: tudor.niculae@email.com
// parola: tudor7887

public class LoginTest extends BaseTest {
    protected IFeTrainingFacade iFeTrainingFacade;
    protected String feTrainingPropertyFilePath = "src/test/resources/properties/FeTraining.properties";
    private String invalidUser, invalidPassword, loginErrorMessage, wrongErrorMessage, userEmail, loginFailedMessage,
            customerUser, customerPassword, logoutFailedMessage, loginPageLink;

    @BeforeSuite (alwaysRun = true)
    public void Setup(){
        super.Setup();
        configLoader = new ConfigLoader(feTrainingPropertyFilePath);
        iFeTrainingFacade = new FeTrainingFacade(driver);
        InitializeProperties();
    }

    @Test (groups = "loginfail", priority = 1)
    public void WrongCredentialsMessage(){
        InuitTest("Wrong Credentials Message");
        iFeTrainingFacade.GotoLoginPage();
        ClearLoginInfo();
        iFeTrainingFacade.SetMail(invalidUser);
        iFeTrainingFacade.SetPassword(invalidPassword);
        iFeTrainingFacade.ClickLogin();
        HardAssertEqual(iFeTrainingFacade.GetErrorMessage(), loginErrorMessage, wrongErrorMessage);
    }

    @Test (groups = "authentication", priority = 0)
    public void LoginSuccessful(){
        InuitTest("Login Successful");
        iFeTrainingFacade.GotoLoginPage();
        ClearLoginInfo();
        iFeTrainingFacade.SetMail(customerUser);
        iFeTrainingFacade.SetPassword(customerPassword);
        iFeTrainingFacade.ClickLogin();
        iFeTrainingFacade.WaitUntilCustomerDashBoardPageLoaded();
        HardAssertEqual(iFeTrainingFacade.GetEmail(), userEmail, loginFailedMessage);
    }

    @Test (groups = "authentication", priority = 1)
    public void Logout()
    {
        InuitTest("Logout Successful");
        iFeTrainingFacade.ClickLogout();
        iFeTrainingFacade.WaitUntilLoginPageLoaded();
        HardAssertEqual(driver.getCurrentUrl(), loginPageLink, logoutFailedMessage);
    }

    protected void ClearLoginInfo()
    {
        iFeTrainingFacade.ClearMail();
        iFeTrainingFacade.ClearPassword();
    }

    @Override protected String GetReportName() {
        return "FeTrainingLogin.html";
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
