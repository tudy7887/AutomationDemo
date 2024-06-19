package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import template.actions.LoginActions;

public class LoginTest extends BaseTest{
    private LoginActions loginActions;
    private String url = "http://apptest.go.ro:9999/login";
    private String expectedError = "Access forbidden!";

    @BeforeSuite
    public void Setup(){
        super.Setup();
        loginActions = new LoginActions(driver);
        driver.get(url);
    }

    @Test
    public void CheckErrorMessage(){
        InuitTest("Login");
        loginActions.SetMail("jgjhgjgjh");
        loginActions.SetPassword("jkkjgdjfefeg");
        loginActions.ClickLogin();
        Assert.assertEquals(loginActions.GetErrorMessage(), expectedError, "Error: Wrong Error Message!");
    }
}
