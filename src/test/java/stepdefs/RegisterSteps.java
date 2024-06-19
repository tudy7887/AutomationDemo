package stepdefs;

import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjectmodel.freetraining.LoginPage;
import pageobjectmodel.freetraining.RegisterPage;
import webdriver.Chrome;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterSteps implements En {
    private Chrome chrome = new Chrome();
    private WebDriver driver;
    private RegisterPage registerpage;
    private LoginPage loginpage;
    private String registerpagelink = "http://apptest.go.ro:9999/register";
    private String loginpagelink = "http://apptest.go.ro:9999/register";

    public RegisterSteps() {
        this.driver = driver;

        Before(()->{
            driver = chrome.GetChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
        });

        After(()->{
            driver.close();
            driver.quit();
        });

        Given("^I am on the register page$", () -> {
            driver.get(registerpagelink);
            registerpage = new RegisterPage(driver);
            loginpage = new LoginPage(driver);
        });

        When("I enter first name = {string}, last name = {string}, phone = {string}, email = {string}, password = {string}, city = {string}",
                (String firstname, String lastname, String phone, String email, String password, String city) -> {
                    registerpage.SetFirstName(firstname);
                    registerpage.SetLastName(lastname);
                    registerpage.SetPhone(phone);
                    registerpage.SetMail(email);
                    registerpage.SetPassword(password);
                    registerpage.SetCity(city);
                });

        And("Check the customer checkbox", () -> {
            registerpage.ClickCustomerCheckBox();
        });

        And("I click on Sign Up button", () -> {
            registerpage.ClickSignup();
        });

        Then("I should be taken to the Login page", () -> {
            loginpage.WaitUntilLoaded();
            assertEquals(loginpagelink, driver.getCurrentUrl());
        });

        And("Check the trainer checkbox", () -> {
            registerpage.ClickTrainerCheckBox();
        });

        Then("I should remain on Register page and receive the following error meage: {string}", (String error) -> {
            assertEquals(registerpagelink, driver.getCurrentUrl());
            assertEquals(error, registerpage.GetErrorMessage());
        });
    }
}
