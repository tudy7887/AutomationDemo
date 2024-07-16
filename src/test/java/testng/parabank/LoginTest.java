package testng.parabank;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import parabank.dto.LoginDTO;
import parabank.dto.RegisterDTO;
import parabank.facade.IParaBankFacade;
import parabank.facade.ParaBankFacade;
import basetest.BaseTest;
import util.ConfigLoader;

public class LoginTest extends BaseTest {
    protected IParaBankFacade iParaBankFacade;
    protected String paraBankPropertyFilePath = "src/test/resources/properties/ParaBank.properties";
    private String errorNoLoginData, errorWrongLoginData, accountOverviewTitle, customerLoginTitle;
    private LoginDTO wrongUser, user1;
    private String loginFailMessage, logoutFailMessage, wrongLoginDataMessage, noLoginDataMessage;

    @BeforeSuite(alwaysRun = true)
    public void Setup(){
        super.Setup();
        configLoader = new ConfigLoader(paraBankPropertyFilePath);
        iParaBankFacade = new ParaBankFacade(driver);
        InitializeProperties();
    }

    @Test(groups = "parabankloginfail", priority = 2)
    public void EmptyCredentialsMessage(){
        InuitTest("Wrong Credentials Message");
        iParaBankFacade.GoToLoginPage();
        iParaBankFacade.ClearLoginData();
        iParaBankFacade.ClickLoginButton();
        HardAssertEqual(iParaBankFacade.GetLoginErrorMessage(), errorNoLoginData, noLoginDataMessage);
    }

    @Test(groups = "parabankloginfail", priority = 2)
    public void WrongCredentialsMessage(){
        InuitTest("Wrong Credentials Message");
        iParaBankFacade.GoToLoginPage();
        iParaBankFacade.ClearLoginData();
        iParaBankFacade.EnterLoginData(wrongUser);
        iParaBankFacade.ClickLoginButton();
        HardAssertEqual(iParaBankFacade.GetLoginErrorMessage(), errorWrongLoginData, wrongLoginDataMessage);
    }

    @Test (groups = "parabankauthentication", priority = 0)
    public void LoginSuccessful(){
        InuitTest("Login Successful");
        iParaBankFacade.GoToLoginPage();
        iParaBankFacade.ClearLoginData();
        iParaBankFacade.EnterLoginData(user1);
        iParaBankFacade.ClickLoginButton();
        HardAssertEqual(iParaBankFacade.GetAccountsOverview(), accountOverviewTitle, loginFailMessage);
    }

    @Test (groups = "parabankauthentication", priority = 1)
    public void Logout() {
        iParaBankFacade.ClickLogOutMenu();
        HardAssertEqual(iParaBankFacade.GetLoginPage(), customerLoginTitle, logoutFailMessage);
    }

    @Override protected String GetReportName() {
        return "ParaBank.html";
    }

    private void InitializeProperties(){
        errorNoLoginData = configLoader.GetProperties("errorNoLoginData");
        errorWrongLoginData = configLoader.GetProperties("errorWrongLoginData");
        accountOverviewTitle = configLoader.GetProperties("accountOverviewTitle");
        customerLoginTitle = configLoader.GetProperties("customerLoginTitle");

        loginFailMessage = configLoader.GetProperties("loginFailMessage");
        logoutFailMessage = configLoader.GetProperties("logoutFailMessage");
        wrongLoginDataMessage = configLoader.GetProperties("wrongLoginDataMessage");
        noLoginDataMessage = configLoader.GetProperties("noLoginDataMessage");

        user1 = new LoginDTO();
        user1.Username = configLoader.GetProperties("user1");
        user1.Password = configLoader.GetProperties("password1");

        wrongUser = new LoginDTO();
        wrongUser.Username = "sdfsdfsdsfsd";
        wrongUser.Password = "sdfsdfsdfsdfsdfsf";
    }
}
