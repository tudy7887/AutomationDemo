package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageElements extends  BaseElements {
    private By username, password, loginButton, registerLink, loginError, customerLogin;

    public LoginPageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("loginPageLink"));
        InitializeElements();
    }

    public WebElement GetUsername(){
        return driver.findElement(username);
    }
    public WebElement GetPassword(){
        return driver.findElement(password);
    }
    public WebElement GetLoginError(){
        return driver.findElement(loginError);
    }
    public WebElement GetLoginButton(){
        return driver.findElement(loginButton);
    }
    public WebElement GetRegisterLink(){
        return driver.findElement(registerLink);
    }
    public WebElement GetCustomerLogin(){
        return driver.findElement(customerLogin);
    }

    private void InitializeElements(){
        username = GetElementByCSSSlecetor(configLoader.GetProperties("usernameLogin"));
        password = GetElementByCSSSlecetor(configLoader.GetProperties("passwordLogin"));
        loginError = GetElementByCSSSlecetor(configLoader.GetProperties("loginError"));
        loginButton = GetElementByCSSSlecetor(configLoader.GetProperties("loginButton"));
        registerLink = GetElementByCSSSlecetor(configLoader.GetProperties("registerLink"));
        customerLogin = GetElementByCSSSlecetor(configLoader.GetProperties("customerLogin"));
    }
}
