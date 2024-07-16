package testng.parabank;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import parabank.dto.UpdateInfoDTO;

public class UpdateContractInfoTest extends LoginTest{
    private UpdateInfoDTO updateData;
    private String updateSuccessfulMessage, wrongUpdateSuccessfulMessage, wrongFirstnameMessage, wrongLastnameMessage,
            wrongAddressMessage, wrongStateMessage, wrongCityMessage, wrongZipCodeMessage, wrongPhoneMessage;

    @BeforeSuite(alwaysRun = true)
    public void Setup(){
        super.Setup();
        InitializeProperties();
    }

    @Test(dependsOnMethods = "LoginSuccessful", groups = "updatecontactinfo")
    public void UpdateUserInfo() {
        InuitTest("Update User Info");
        iParaBankFacade.ClickUpdateContractInfoMenu();
        var initialInfo = iParaBankFacade.GetUserInfo();
        AddScreenshot("Initial User Info", "Initial User Info");
        iParaBankFacade.ClearUpdateInfoData();
        iParaBankFacade.EnterUpdatedInfoData(updateData);
        iParaBankFacade.ClickUpdateProfileButton();
        AddScreenshot("Update Info Successful", "Updated User Info Successful Message");
        SoftAssertEqual(iParaBankFacade.GetUpdateSuccessfulMessage(), updateSuccessfulMessage, wrongUpdateSuccessfulMessage);
        iParaBankFacade.ClickUpdateContractInfoMenu();
        var updatedInfo = iParaBankFacade.GetUserInfo();
        AddScreenshot("Updated User Info", "Updated User Info");
        SoftAssertEqual(updatedInfo.FirstName, updateData.FirstName, wrongFirstnameMessage);
        SoftAssertEqual(updatedInfo.LastName, updateData.LastName, wrongLastnameMessage);
        SoftAssertEqual(updatedInfo.Address, updateData.Address, wrongAddressMessage);
        SoftAssertEqual(updatedInfo.State, updateData.State, wrongStateMessage);
        SoftAssertEqual(updatedInfo.City, updateData.City, wrongCityMessage);
        SoftAssertEqual(updatedInfo.ZipCode, updateData.ZipCode, wrongZipCodeMessage);
        SoftAssertEqual(updatedInfo.Phone, updateData.Phone, wrongPhoneMessage);
    }

    private void InitializeProperties(){
        updateData = new UpdateInfoDTO();
        updateData.FirstName = configLoader.GetProperties("updateFirstName");
        updateData.LastName = configLoader.GetProperties("updateLastName");
        updateData.Address = configLoader.GetProperties("updateAddress");
        updateData.City = configLoader.GetProperties("updateCity");
        updateData.State = configLoader.GetProperties("updateState");
        updateData.Phone = configLoader.GetProperties("updatePhone");
        updateData.ZipCode = configLoader.GetProperties("updateZipCode");

        updateSuccessfulMessage = configLoader.GetProperties("updateSuccessfulMessage");
        wrongUpdateSuccessfulMessage = configLoader.GetProperties("wrongUpdateSuccessfulMessage");
        wrongFirstnameMessage = configLoader.GetProperties("wrongFirstnameMessage");
        wrongLastnameMessage = configLoader.GetProperties("wrongLastnameMessage");
        wrongAddressMessage = configLoader.GetProperties("wrongAddressMessage");
        wrongStateMessage = configLoader.GetProperties("wrongStateMessage");
        wrongCityMessage = configLoader.GetProperties("wrongCityMessage");
        wrongZipCodeMessage = configLoader.GetProperties("wrongZipCodeMessage");
        wrongPhoneMessage = configLoader.GetProperties("wrongPhoneMessage");
    }
}
