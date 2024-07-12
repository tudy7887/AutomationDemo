package testng.parabank;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import parabank.facade.IParaBankFacade;
import parabank.facade.ParaBankFacade;
import testng.BaseTest;
import util.ConfigLoader;

public class LoginTest extends BaseTest {
    protected IParaBankFacade iParaBankFacade;
    protected String paraBankPropertyFilePath = "src/test/resources/properties/ParaBank.properties";

    @BeforeSuite(alwaysRun = true)
    public void Setup(){
        super.Setup();
        configLoader = new ConfigLoader(paraBankPropertyFilePath);
        iParaBankFacade = new ParaBankFacade(driver);
        InitializeProperties();
    }

    @Test(groups = "parabankloginfail", priority = 1)
    public void WrongCreditentialsMesage(){
        iParaBankFacade.GoToLoginPage();
        iParaBankFacade.ClearLoginData();
        InuitTest("Wrong Creditentials Message");
        iParaBankFacade.ClearLoginData();
        iParaBankFacade.ClickLoginButton();
        HardAssertEqual("a", "b", "ERROR: Test!");

    }

    //@Test (groups = "parabankauthentication", priority = 0)
    public void LoginSuccessfull(){

    }

    //@Test (groups = "parabankauthentication", priority = 1)
    public void Logout() {

    }

    protected void ClearLoginInfo() {

    }

    @Override protected String GetReportName() {
        return "ParaBank.html";
    }

    private void InitializeProperties(){

    }
}
