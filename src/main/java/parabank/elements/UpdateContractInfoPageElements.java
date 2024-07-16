package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    public void WaitUntilDataIsLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(firstNameUpdate).isDisplayed());
        wait.until(d -> d.findElement(lastNameUpdate).isDisplayed());
        wait.until(d -> d.findElement(addressUpdate).isDisplayed());
        wait.until(d -> d.findElement(cityUpdate).isDisplayed());
        wait.until(d -> d.findElement(stateUpdate).isDisplayed());
        wait.until(d -> d.findElement(zipCodeUpdate).isDisplayed());
        wait.until(d -> d.findElement(phoneUpdate).isDisplayed());
    }
    public void WaitUntilSuccessfulIsLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(updateSuccessful).isDisplayed());
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
