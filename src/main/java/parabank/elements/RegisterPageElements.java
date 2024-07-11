package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageElements extends BaseElements {
    private By firstName, lastName, adress, city, state, zipCode, phone, ssn,
            username, password, passwordConfirmation, registerButton;

    public RegisterPageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("registerPageLink"));
        InitializeElements();
    }

    public WebElement GetFirstName(){
        return driver.findElement(firstName);
    }
    public WebElement GetLastName(){
        return driver.findElement(lastName);
    }
    public WebElement GetAdress(){
        return driver.findElement(adress);
    }
    public WebElement GetState(){
        return driver.findElement(state);
    }
    public WebElement GetCity(){
        return driver.findElement(city);
    }
    public WebElement GetZipCode(){
        return driver.findElement(zipCode);
    }
    public WebElement GetSsn(){
        return driver.findElement(ssn);
    }
    public WebElement GetPhone(){
        return driver.findElement(phone);
    }
    public WebElement GetPassword(){
        return driver.findElement(password);
    }
    public WebElement GetPasswordConfirmation(){
        return driver.findElement(passwordConfirmation);
    }
    public WebElement GetUsername(){
        return driver.findElement(username);
    }
    public WebElement GetRegisterButton(){
        return driver.findElement(registerButton);
    }

    private void InitializeElements(){
        firstName = GetElementByCSSSlecetor(configLoader.GetProperties("firstNameRegister"));
        lastName = GetElementByCSSSlecetor(configLoader.GetProperties("lastNameRegister"));
        adress = GetElementByCSSSlecetor(configLoader.GetProperties("addressRegister"));
        city = GetElementByCSSSlecetor(configLoader.GetProperties("cityRegister"));
        state = GetElementByCSSSlecetor(configLoader.GetProperties("stateRegister"));
        zipCode = GetElementByCSSSlecetor(configLoader.GetProperties("zipCodeRegister"));
        phone = GetElementByCSSSlecetor(configLoader.GetProperties("phoneRegister"));
        ssn = GetElementByCSSSlecetor(configLoader.GetProperties("ssnRegister"));
        username = GetElementByCSSSlecetor(configLoader.GetProperties("usernameRegister"));
        password = GetElementByCSSSlecetor(configLoader.GetProperties("passwordRegister"));
        passwordConfirmation = GetElementByCSSSlecetor(configLoader.GetProperties("passwordConfirmationRegister"));
        registerButton = GetElementByCSSSlecetor(configLoader.GetProperties("registerButton"));
    }
}
