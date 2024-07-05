package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import fetraining.actions.CustomerDashBoardActions;
import fetraining.actions.LoginActions;

// user: tudor.niculae@email.com
// parola: tudor7887

public class LoginTest extends BaseTest{
    private String badUser, badPassword, loginError, wrongErrorMessage, userEmail, loginFailed, goodUser, goodPassword;;

    @BeforeSuite
    public void Setup(){
        super.Setup();
        InitializeProperties();
        loginActions = new LoginActions(driver);
        customerDashBoardActions =  new CustomerDashBoardActions(driver);
    }

    @BeforeTest
    public void TestSetup() {
        driver.get(url);
    }

    @Test (groups = "loginfailmessages")
    public void WrongCreditentialsMesage(){
        InuitTest("Wrong Creditentials Message");
        loginActions.SetMail(badUser);
        loginActions.SetPassword(badPassword);
        loginActions.ClickLogin();
        Assert.assertEquals(loginActions.GetErrorMessage(), loginError, wrongErrorMessage);
        ClearLoginInfo();
    }

    @Test (groups = "authentication", priority = 1)
    public void LoginSuccessfull(){
        InuitTest("Login Successfull");
        loginActions.SetMail(goodUser);
        loginActions.SetPassword(goodPassword);
        loginActions.ClickLogin();
        customerDashBoardActions.WaitUntilLoaded();
        Assert.assertEquals(customerDashBoardActions.GetEmail(), userEmail, loginFailed );
        Logout();
    }

    @Test (groups = "authentication", priority = 2)
    protected void Logout()
    {
        customerDashBoardActions.ClickLogout();
        loginActions.WaitUntilLoaded();
    }

    protected void ClearLoginInfo()
    {
        loginActions.ClearMail();
        loginActions.ClearPassword();
    }

    private void InitializeProperties(){
        badUser = configLoader.getProperties("InvalidUser");
        badPassword = configLoader.getProperties("InvalidPassword");
        loginError = configLoader.getProperties("LoginError");
        wrongErrorMessage = configLoader.getProperties("WrongErrorMessage");
        userEmail = configLoader.getProperties("customerUser");
        loginFailed = configLoader.getProperties("LoginFailed");
        goodUser = configLoader.getProperties("customerUser");
        goodPassword = configLoader.getProperties("CustomerPassword");
    }
}
