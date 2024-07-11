package parabank.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillPayPageElements extends UserBaseElements {
    private By playeeName, playeeAddress, playeeCity, playeeState, playeeZip, playeePhone, playeeAccount,
            playeeVerifyAccount, playeeAmount, playeeNameError, playeeAddressError, playeeCityError,
            playeeStateError, playeeZipError, playeePhoneError, playeeAccountError, playeeVerifyAccountError,
            playeeAmountError, fromAccountBillPaymentCombobox, sendPaymentButton, billPayCompleted;

    public BillPayPageElements(WebDriver driver) {
        super(driver);
        SetLink(configLoader.GetProperties("billPayPageLink"));
        InitializeElements();
    }

    public WebElement GetFromAccountBillPaymentCombobox(){
        return driver.findElement(fromAccountBillPaymentCombobox);
    }
    public WebElement GetSendPaymentButton(){
        return driver.findElement(sendPaymentButton);
    }
    public WebElement GetBillPayCompleted(){
        return driver.findElement(billPayCompleted);
    }
    public WebElement GetPlayeeName(){
        return driver.findElement(playeeName);
    }
    public WebElement GetPlayeeAddress(){
        return driver.findElement(playeeAddress);
    }
    public WebElement GetPlayeeCity(){
        return driver.findElement(playeeCity);
    }
    public WebElement GetPlayeeState(){
        return driver.findElement(playeeState);
    }
    public WebElement GetPlayeeZip(){
        return driver.findElement(playeeZip);
    }
    public WebElement GetPlayeePhone(){
        return driver.findElement(playeePhone);
    }
    public WebElement GetPlayeeAccount(){
        return driver.findElement(playeeAccount);
    }
    public WebElement GetPlayeeVerifyAccount(){
        return driver.findElement(playeeVerifyAccount);
    }
    public WebElement GetPlayeeAmount(){
        return driver.findElement(playeeAmount);
    }
    public WebElement GetPlayeeNameError(){
        return driver.findElement(playeeNameError);
    }
    public WebElement GetPlayeeAddressError(){
        return driver.findElement(playeeAddressError);
    }
    public WebElement GetPlayeeCityError(){
        return driver.findElement(playeeCityError);
    }
    public WebElement GetPlayeeStateError(){
        return driver.findElement(playeeStateError);
    }
    public WebElement GetPlayeeZipError(){
        return driver.findElement(playeeZipError);
    }
    public WebElement GetPlayeePhoneError(){
        return driver.findElement(playeePhoneError);
    }
    public WebElement GetPlayeeAccountError(){
        return driver.findElement(playeeAccountError);
    }
    public WebElement GetPlayeeVerifyAccountError(){
        return driver.findElement(playeeVerifyAccountError);
    }
    public WebElement GetPlayeeAmountError(){
        return driver.findElement(playeeAmountError);
    }

    private void InitializeElements(){
        fromAccountBillPaymentCombobox = GetElementByCSSSlecetor(configLoader.GetProperties("fromAccountBillPaymentCombobox"));
        sendPaymentButton = GetElementByCSSSlecetor(configLoader.GetProperties("sendPaymentButton"));
        billPayCompleted = GetElementByCSSSlecetor(configLoader.GetProperties("billPayCompleted"));
        playeeName = GetElementByCSSSlecetor(configLoader.GetProperties("playeeName"));
        playeeAddress = GetElementByCSSSlecetor(configLoader.GetProperties("playeeAddress"));
        playeeCity = GetElementByCSSSlecetor(configLoader.GetProperties("playeeCity"));
        playeeState = GetElementByCSSSlecetor(configLoader.GetProperties("playeeState"));
        playeeZip = GetElementByCSSSlecetor(configLoader.GetProperties("playeeZip"));
        playeePhone = GetElementByCSSSlecetor(configLoader.GetProperties("playeePhone"));
        playeeAccount = GetElementByCSSSlecetor(configLoader.GetProperties("playeeAccount"));
        playeeVerifyAccount = GetElementByCSSSlecetor(configLoader.GetProperties("playeeVerifyAccount"));
        playeeAmount = GetElementByCSSSlecetor(configLoader.GetProperties("playeeAmount"));
        playeeNameError = GetElementByCSSSlecetor(configLoader.GetProperties("playeeNameError"));
        playeeAddressError = GetElementByCSSSlecetor(configLoader.GetProperties("playeeAddressError"));
        playeeCityError = GetElementByCSSSlecetor(configLoader.GetProperties("playeeCityError"));
        playeeStateError = GetElementByCSSSlecetor(configLoader.GetProperties("playeeStateError"));
        playeeZipError = GetElementByCSSSlecetor(configLoader.GetProperties("playeeZipError"));
        playeePhoneError = GetElementByCSSSlecetor(configLoader.GetProperties("playeePhoneError"));
        playeeAccountError = GetElementByCSSSlecetor(configLoader.GetProperties("playeeAccountError"));
        playeeVerifyAccountError = GetElementByCSSSlecetor(configLoader.GetProperties("playeeVerifyAccountError"));
        playeeAmountError = GetElementByCSSSlecetor(configLoader.GetProperties("playeeAmountError"));
    }
}
