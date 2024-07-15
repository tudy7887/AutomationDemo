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
    private LoginDTO wrongUser, user1, user2;
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

    @Test (groups = "parabankauthentication", priority = 0, dependsOnGroups = "register")
    //@Test (groups = "parabankauthentication", priority = 0)
    public void LoginSuccessful(){
        InuitTest("Login Successful");
        iParaBankFacade.GoToLoginPage();
        iParaBankFacade.ClearLoginData();
        iParaBankFacade.EnterLoginData(user1);
        iParaBankFacade.ClickLoginButton();
        iParaBankFacade.WaitUntilAccountsOverviewPageLoaded();
        HardAssertEqual(iParaBankFacade.GetAccountsOverview(), accountOverviewTitle, loginFailMessage);
    }

    @Test (groups = "parabankauthentication", priority = 1)
    public void Logout() {
        iParaBankFacade.ClickLogOutMenu();
        iParaBankFacade.WaitUntilLoginPageLoaded();
        HardAssertEqual(iParaBankFacade.GetLoginPage(), customerLoginTitle, logoutFailMessage);
    }

    @Override protected String GetReportName() {
        return "ParaBank.html";
    }

    @Test (groups = "register")
    private void RegisterUsers(){
        var user1 = new RegisterDTO();
        var user2 = new RegisterDTO();

        user1.Username = configLoader.GetProperties("user1");
        user1.Password = configLoader.GetProperties("password1");
        user1.FirstName = configLoader.GetProperties("firstName1");
        user1.LastName = configLoader.GetProperties("lastName1");
        user1.Address = configLoader.GetProperties("address1");
        user1.City = configLoader.GetProperties("city1");
        user1.State = configLoader.GetProperties("state1");
        user1.ZipCode = configLoader.GetProperties("zip1");
        user1.Phone = configLoader.GetProperties("phone1");
        user1.Ssn = configLoader.GetProperties("ssn1");

        user2.Username = configLoader.GetProperties("user2");
        user2.Password = configLoader.GetProperties("password2");
        user2.FirstName = configLoader.GetProperties("firstName2");
        user2.LastName = configLoader.GetProperties("lastName2");
        user2.Address = configLoader.GetProperties("address2");
        user2.City = configLoader.GetProperties("city2");
        user2.State = configLoader.GetProperties("state2");
        user2.ZipCode = configLoader.GetProperties("zip2");
        user2.Phone = configLoader.GetProperties("phone2");
        user2.Ssn = configLoader.GetProperties("ssn2");

        iParaBankFacade.GoToLoginPage();
        iParaBankFacade.ClickRegisterLink();
        iParaBankFacade.WaitUntilRegisterPageLoaded();
        iParaBankFacade.EnterRegisterData(user1);
        iParaBankFacade.ClickRegister();
        iParaBankFacade.WaitUntilWelcomePageLoaded();
        iParaBankFacade.ClickLogOutMenu();
        iParaBankFacade.WaitUntilLoginPageLoaded();

        iParaBankFacade.GoToLoginPage();
        iParaBankFacade.ClickRegisterLink();
        iParaBankFacade.WaitUntilRegisterPageLoaded();
        iParaBankFacade.EnterRegisterData(user2);
        iParaBankFacade.ClickRegister();
        iParaBankFacade.WaitUntilWelcomePageLoaded();
        iParaBankFacade.ClickLogOutMenu();
        iParaBankFacade.WaitUntilLoginPageLoaded();
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

        user2 = new LoginDTO();
        user2.Username = configLoader.GetProperties("user2");
        user2.Password = configLoader.GetProperties("password2");

        wrongUser = new LoginDTO();
        wrongUser.Username = "sdfsdfsdsfsd";
        wrongUser.Password = "sdfsdfsdfsdfsdfsf";
    }
}
