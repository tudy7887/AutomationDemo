package testng.fetraining;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import fetraining.actions.CustomerDashBoardActions;
import fetraining.actions.LoginActions;
import testng.BaseTest;
import util.ConfigLoader;

// user: tudor.niculae@email.com
// parola: tudor7887

public class LoginTest extends BaseTest {
    protected LoginActions loginActions;
    protected CustomerDashBoardActions customerDashBoardActions;
    private String feTrainingPropertyFilePath = "D:\\Learning\\SelfLearning\\Training\\src\\test\\resources\\properties\\FeTraining.properties";
    private String badUser, badPassword, loginError, wrongErrorMessage, userEmail, loginFailed, goodUser, goodPassword;
    protected String url;

    @BeforeSuite (alwaysRun = true)
    public void Setup(){
        super.Setup();
        configLoader = new ConfigLoader(feTrainingPropertyFilePath);
        loginActions = new LoginActions(driver);
        customerDashBoardActions =  new CustomerDashBoardActions(driver);
        InitializeProperties();
    }

    @Test (groups = "loginfailmessages", priority = 1)
    public void WrongCreditentialsMesage(){
        loginActions.GotoPage();
        InuitTest("Wrong Creditentials Message");
        loginActions.SetMail(badUser);
        loginActions.SetPassword(badPassword);
        loginActions.ClickLogin();
        Assert.assertEquals(loginActions.GetErrorMessage(), loginError, wrongErrorMessage);
        ClearLoginInfo();
    }

    @Test (groups = "authentication", priority = 0)
    public void LoginSuccessfull(){
        loginActions.GotoPage();
        InuitTest("Login Successfull");
        loginActions.SetMail(goodUser);
        loginActions.SetPassword(goodPassword);
        loginActions.ClickLogin();
        customerDashBoardActions.WaitUntilLoaded();
        Assert.assertEquals(customerDashBoardActions.GetEmail(), userEmail, loginFailed);
    }

    @Test (groups = "authentication", priority = 1)
    public void Logout()
    {
        customerDashBoardActions.ClickLogout();
        loginActions.WaitUntilLoaded();
    }

    protected void ClearLoginInfo()
    {
        loginActions.ClearMail();
        loginActions.ClearPassword();
    }

    @Override protected String GetReportName() {
        return "FeTraining.html";
    }

    private void InitializeProperties(){
        url = configLoader.GetProperties("StartPageLink");
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
