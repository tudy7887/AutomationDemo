package fetraining.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginElements extends BaseElements {
    private By loginEmail, loginPassword, loginButton, loginError;

    public LoginElements(WebDriver driver){
        super(driver);
        SetLink("http://apptest.go.ro:9999/login");
        InitializeElements();
    }

    public WebElement MailInput(){
        return driver.findElement(loginEmail);
    }
    public WebElement PasswordInput(){
        return driver.findElement(loginPassword);
    }
    public WebElement LoginButton(){
        return driver.findElement(loginButton);
    }
    public WebElement ErrorMesage(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.findElement(loginError).isEnabled());
        return driver.findElement(loginError);
    }

    private void InitializeElements(){
        loginEmail = GetElementByCSSSlecetor(configLoader.GetProperties("loginEmail"));
        loginPassword = GetElementByCSSSlecetor(configLoader.GetProperties("loginPassword"));
        loginButton = GetElementByCSSSlecetor(configLoader.GetProperties("loginButton"));
        loginError = GetElementByCSSSlecetor(configLoader.GetProperties("loginError"));
    }
}
