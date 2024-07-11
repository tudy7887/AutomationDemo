package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateContractInfoPageElements extends BaseElements {
    private By firstNameUpdate, lastNameUpdate, addressUpdate, cityUpdate, stateUpdate, zipCodeUpdate,
            phoneUpdate, updateProfileButton, updateSuccessful;

    public UpdateContractInfoPageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("updateContractInfoPageLink"));
        InitializeElements();
    }

    public WebElement GetFirstNameUpdate(){
        return driver.findElement(firstNameUpdate);
    }
    public WebElement GetLastNameUpdate(){
        return driver.findElement(lastNameUpdate);
    }
    public WebElement GetAddressUpdate(){
        return driver.findElement(addressUpdate);
    }
    public WebElement GetCityUpdate(){
        return driver.findElement(cityUpdate);
    }
    public WebElement GetStateUpdate(){
        return driver.findElement(stateUpdate);
    }
    public WebElement GetZipCodeUpdate(){
        return driver.findElement(zipCodeUpdate);
    }
    public WebElement GetPhoneUpdate(){
        return driver.findElement(phoneUpdate);
    }
    public WebElement GetUpdateProfileButton(){
        return driver.findElement(updateProfileButton);
    }
    public WebElement GetUpdateSuccessful(){
        return driver.findElement(updateSuccessful);
    }

    private void InitializeElements(){
        firstNameUpdate = GetElementByCSSSlecetor(configLoader.GetProperties("firstNameUpdate"));
        lastNameUpdate = GetElementByCSSSlecetor(configLoader.GetProperties("lastNameUpdate"));
        addressUpdate = GetElementByCSSSlecetor(configLoader.GetProperties("addressUpdate"));
        cityUpdate = GetElementByCSSSlecetor(configLoader.GetProperties("cityUpdate"));
        stateUpdate = GetElementByCSSSlecetor(configLoader.GetProperties("stateUpdate"));
        zipCodeUpdate = GetElementByCSSSlecetor(configLoader.GetProperties("zipCodeUpdate"));
        phoneUpdate = GetElementByCSSSlecetor(configLoader.GetProperties("phoneUpdate"));
        updateProfileButton = GetElementByCSSSlecetor(configLoader.GetProperties("updateProfileButton"));
        updateSuccessful = GetElementByCSSSlecetor(configLoader.GetProperties("updateSuccessful"));
    }
}
