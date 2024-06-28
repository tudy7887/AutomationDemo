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
    private String badUser, badPassword, loginError, wrongErrorMessage, userEmail, loginFailed;

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

    @Test
    public void FailedLoginErrorMesage(){
        InuitTest("Login Error");
        loginActions.SetMail(badUser);
        loginActions.SetPassword(badPassword);
        loginActions.ClickLogin();
        Assert.assertEquals(loginActions.GetErrorMessage(), loginError, wrongErrorMessage);
        ClearLoginInfo();
    }

    @Test
    public void SuccessfullLogin(){
        InuitTest("Login Successful");
        Login();
        Assert.assertEquals(customerDashBoardActions.GetEmail(), userEmail, loginFailed );
        Logout();
    }

    private void InitializeProperties(){
        badUser = configLoader.getProperties("BadUser");
        badPassword = configLoader.getProperties("BadPassword");
        loginError = configLoader.getProperties("LoginError");
        wrongErrorMessage = configLoader.getProperties("WrongErrorMessage");
        userEmail = configLoader.getProperties("GoodUser");
        loginFailed = configLoader.getProperties("LoginFailed");
    }
}
