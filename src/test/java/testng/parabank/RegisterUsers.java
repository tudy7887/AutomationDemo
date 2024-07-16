package testng.parabank;

import basetest.BaseTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import parabank.dto.RegisterDTO;
import parabank.facade.IParaBankFacade;
import parabank.facade.ParaBankFacade;
import util.ConfigLoader;

public class RegisterUsers extends BaseTest {
    private IParaBankFacade iParaBankFacade;
    private String paraBankPropertyFilePath = "src/test/resources/properties/ParaBank.properties";
    @BeforeSuite(alwaysRun = true)
    public void Setup(){
        super.Setup();
        configLoader = new ConfigLoader(paraBankPropertyFilePath);
        iParaBankFacade = new ParaBankFacade(driver);
    }

    @Test(groups = "register")
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
        iParaBankFacade.EnterRegisterData(user1);
        iParaBankFacade.ClickRegister();
        iParaBankFacade.ClickLogOutMenu();

        iParaBankFacade.GoToLoginPage();
        iParaBankFacade.ClickRegisterLink();
        iParaBankFacade.EnterRegisterData(user2);
        iParaBankFacade.ClickRegister();
        iParaBankFacade.ClickLogOutMenu();

        if(driver != null){
            driver.quit();
        }
    }

}
