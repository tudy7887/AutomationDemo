package testng;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import template.actions.CustomerDashBoardActions;
import template.actions.LoginActions;

// user: tudor.niculae@email.com
// parola: tudor7887

public class LoginTest extends BaseTest{

    private String url = "http://apptest.go.ro:9999/login";
    private String expectedError = "Access forbidden!";

    @BeforeSuite
    public void Setup(){
        super.Setup();
        loginActions = new LoginActions(driver);
        customerDashBoardActions =  new CustomerDashBoardActions(driver);
        driver.get(url);
    }

    @Test
    public void CheckErrorMessage(){
        InuitTest("Login Error");
        loginActions.SetMail("jgjhkhkjhkgjgjh");
        loginActions.SetPassword("jkkjgdjfefeg");
        loginActions.ClickLogin();
        Assert.assertEquals(loginActions.GetErrorMessage(), expectedError, "Error: Wrong Error Message!");
    }

    @Test
    public void SuccessfullLogin(){
        InuitTest("Login Successful");
        Login();
        Assert.assertEquals(customerDashBoardActions.GetEmail(), email);
    }
}
