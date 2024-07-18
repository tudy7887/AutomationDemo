package testng.fetraining;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CustomerTrainingTest extends LoginTest {
    private String biceps, triceps, legs, chest;
    private String position1Element, position2Element, position3Element, position4Element;
    private String errorElementsAreInWrongOrderMessage, trainingPageLink, errorWrongPageMessage;

    @BeforeSuite (alwaysRun = true)
    public void Setup(){
        super.Setup();
        InitializeProperties();
    }

    @Test (dependsOnMethods = "LoginSuccessful", groups = "trainingmenu")
    public void GoToTrainingMenu(){
        InuitTest("Go To Training Menu");
        iFeTrainingFacade.ClickTraining();
        HardAssertEqual(iFeTrainingFacade.GetCurrentUrl(), trainingPageLink, errorWrongPageMessage);
    }

    @Test (dependsOnMethods = "GoToTrainingMenu", groups = "trainingprogram")
    public void MoveAll4toMonday(){
        InuitTest("Move All To Monday");
        // Initial
        IdentifyInitialOrderOfElements();
        HardAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position1Element, position2Element, position3Element, position4Element),
                errorElementsAreInWrongOrderMessage);
        // Move all 4
        MoveTrainingListToMonday(4);
        SoftAssertEqual(GetMondayFirstElements(4),
                GetReferenceString(position2Element, position4Element, position3Element, position1Element),
                errorElementsAreInWrongOrderMessage);
        // Restore to Initial
        MoveMondayToTrainingList(4);
        SoftAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position4Element, position1Element, position3Element, position2Element),
                errorElementsAreInWrongOrderMessage);
    }
    @Test (dependsOnMethods = "GoToTrainingMenu", groups = "trainingprogram")
    public void MoveAll4toTuesday(){
        InuitTest("Move All To Tuesday");
        // Initial
        IdentifyInitialOrderOfElements();
        HardAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position1Element, position2Element, position3Element, position4Element),
                errorElementsAreInWrongOrderMessage);
        // Move all 4
        MoveTrainingListToTuesday(4);
        SoftAssertEqual(GetTuesdayFirstElements(4),
                GetReferenceString(position2Element, position4Element, position3Element, position1Element),
                errorElementsAreInWrongOrderMessage);
        // Restore to Initial
        MoveTuesdayToTrainingList(4);
        SoftAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position4Element, position1Element, position3Element, position2Element),
                errorElementsAreInWrongOrderMessage);
    }
    @Test (dependsOnMethods = "GoToTrainingMenu", groups = "trainingprogram")
    public void MoveAll4toWednesday(){
        InuitTest("Move All To Wednesday");
        // Initial
        IdentifyInitialOrderOfElements();
        HardAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position1Element, position2Element, position3Element, position4Element),
                errorElementsAreInWrongOrderMessage);
        // Move all 4
        MoveTrainingListToWednesday(4);
        SoftAssertEqual(GetWednesdayFirstElements(4),
                GetReferenceString(position2Element, position4Element, position3Element, position1Element),
                errorElementsAreInWrongOrderMessage);
        // Restore to Initial
        MoveWednesdayToTrainingList(4);
        SoftAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position4Element, position1Element, position3Element, position2Element),
                errorElementsAreInWrongOrderMessage);
    }
    @Test (dependsOnMethods = "GoToTrainingMenu", groups = "trainingprogram")
    public void MoveAll4toThursday(){
        InuitTest("Move All To Thursday");
        // Initial
        IdentifyInitialOrderOfElements();
        HardAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position1Element, position2Element, position3Element, position4Element),
                errorElementsAreInWrongOrderMessage);
        // Move all 4
        MoveTrainingListToThursday(4);
        SoftAssertEqual(GetThursdayFirstElements(4),
                GetReferenceString(position2Element, position4Element, position3Element, position1Element),
                errorElementsAreInWrongOrderMessage);
        // Restore to Initial
        MoveThursdayToTrainingList(4);
        SoftAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position4Element, position1Element, position3Element, position2Element),
                errorElementsAreInWrongOrderMessage);
    }
    @Test (dependsOnMethods = "GoToTrainingMenu", groups = "trainingprogram")
    public void MoveAll4toFriday(){
        InuitTest("Move All To Friday");
        // Initial
        IdentifyInitialOrderOfElements();
        HardAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position1Element, position2Element, position3Element, position4Element),
                errorElementsAreInWrongOrderMessage);
        // Move all 4
        MoveTrainingListToFriday(4);
        SoftAssertEqual(GetFridayFirstElements(4),
                GetReferenceString(position2Element, position4Element, position3Element, position1Element),
                errorElementsAreInWrongOrderMessage);
        // Restore to Initial
        MoveFridayToTrainingList(4);
        SoftAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position4Element, position1Element, position3Element, position2Element),
                errorElementsAreInWrongOrderMessage);
    }
    @Test (dependsOnMethods = "GoToTrainingMenu", groups = "trainingprogram")
    public void MoveAll4toSaturday(){
        InuitTest("Move All To Saturday");
        // Initial
        IdentifyInitialOrderOfElements();
        HardAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position1Element, position2Element, position3Element, position4Element),
                errorElementsAreInWrongOrderMessage);
        // Move all 4
        MoveTrainingListToSaturday(4);
        SoftAssertEqual(GetSaturdayFirstElements(4),
                GetReferenceString(position1Element, position4Element, position3Element, position2Element),
                errorElementsAreInWrongOrderMessage);
        // Restore to Initial
        MoveSaturdayToTrainingList(4);
        SoftAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position4Element, position2Element, position3Element, position1Element),
                errorElementsAreInWrongOrderMessage);
    }
    @Test (dependsOnMethods = "GoToTrainingMenu", groups = "trainingprogram")
    public void MoveAll4toSunday(){
        InuitTest("Move All To Sunday");
        // Initial
        IdentifyInitialOrderOfElements();
        HardAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position1Element, position2Element, position3Element, position4Element),
                errorElementsAreInWrongOrderMessage);
        // Move all 4
        MoveTrainingListToSunday(4);
        SoftAssertEqual(GetSundayFirstElements(4),
                GetReferenceString(position1Element, position4Element, position3Element, position2Element),
                errorElementsAreInWrongOrderMessage);
        // Restore to Initial
        MoveSundayToTrainingList(4);
        SoftAssertEqual(GetTrainingListFirstElements(4),
                GetReferenceString(position4Element, position2Element, position3Element, position1Element),
                errorElementsAreInWrongOrderMessage);
    }



    private void MoveMondayToTrainingList(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveMondayToTrainingList(0);
        }
    }
    private void MoveTuesdayToTrainingList(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveTuesdayToTrainingList(0);
        }
    }
    private void MoveWednesdayToTrainingList(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveWednesdayToTrainingList(0);
        }
    }
    private void MoveThursdayToTrainingList(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveThursdayToTrainingList(0);
        }
    }
    private void MoveFridayToTrainingList(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveFridayToTrainingList(0);
        }
    }
    private void MoveSaturdayToTrainingList(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveSaturdayToTrainingList(0);
        }
    }
    private void MoveSundayToTrainingList(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveSundayToTrainingList(0);
        }
    }

    private void MoveTrainingListToMonday(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveTrainingListToMonday(0);
        }
    }
    private void MoveTrainingListToTuesday(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveTrainingListToTuesday(0);
        }
    }
    private void MoveTrainingListToWednesday(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveTrainingListToWednesday(0);
        }
    }
    private void MoveTrainingListToThursday(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveTrainingListToThursday(0);
        }
    }
    private void MoveTrainingListToFriday(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveTrainingListToFriday(0);
        }
    }
    private void MoveTrainingListToSaturday(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveTrainingListToSaturday(0);
        }
    }
    private void MoveTrainingListToSunday(int nrOfElements){
        for(var i = 0; i < nrOfElements; i++){
            iFeTrainingFacade.MoveTrainingListToSunday(0);
        }
    }

    private String GetTrainingListFirstElements(int nrOfElements){
        var result = iFeTrainingFacade.GetTrainingListElementText(0);
        if(nrOfElements > 1) {
            for (var i = 1; i < nrOfElements; i++) {
                result += "_" + iFeTrainingFacade.GetTrainingListElementText(i);
            }
        }
        return result;
    }
    private String GetMondayFirstElements(int nrOfElements){
        var result = iFeTrainingFacade.GetMondayElementText(0);
        if(nrOfElements > 1) {
            for (var i = 1; i < nrOfElements; i++) {
                result += "_" + iFeTrainingFacade.GetMondayElementText(i);
            }
        }
        return result;
    }
    private String GetTuesdayFirstElements(int nrOfElements){
        var result = iFeTrainingFacade.GetTuesdayElementText(0);
        if(nrOfElements > 1) {
            for (var i = 1; i < nrOfElements; i++) {
                result += "_" + iFeTrainingFacade.GetTuesdayElementText(i);
            }
        }
        return result;
    }
    private String GetWednesdayFirstElements(int nrOfElements){
        var result = iFeTrainingFacade.GetWednesdayElementText(0);
        if(nrOfElements > 1) {
            for (var i = 1; i < nrOfElements; i++) {
                result += "_" + iFeTrainingFacade.GetWednesdayElementText(i);
            }
        }
        return result;
    }
    private String GetThursdayFirstElements(int nrOfElements){
        var result = iFeTrainingFacade.GetThursdayElementText(0);
        if(nrOfElements > 1) {
            for (var i = 1; i < nrOfElements; i++) {
                result += "_" + iFeTrainingFacade.GetThursdayElementText(i);
            }
        }
        return result;
    }
    private String GetFridayFirstElements(int nrOfElements){
        var result = iFeTrainingFacade.GetFridayElementText(0);
        if(nrOfElements > 1) {
            for (var i = 1; i < nrOfElements; i++) {
                result += "_" + iFeTrainingFacade.GetFridayElementText(i);
            }
        }
        return result;
    }
    private String GetSaturdayFirstElements(int nrOfElements){
        var result = iFeTrainingFacade.GetSaturdayElementText(0);
        if(nrOfElements > 1) {
            for (var i = 1; i < nrOfElements; i++) {
                result += "_" + iFeTrainingFacade.GetSaturdayElementText(i);
            }
        }
        return result;
    }
    private String GetSundayFirstElements(int nrOfElements){
        var result = iFeTrainingFacade.GetSundayElementText(0);
        if(nrOfElements > 1) {
            for (var i = 1; i < nrOfElements; i++) {
                result += "_" + iFeTrainingFacade.GetSundayElementText(i);
            }
        }
        return result;
    }

    private String GetReferenceString(String element1, String element2, String element3, String element4){
        return element1 + "_" + element2 + "_" + element3 + "_" + element4;
    }
    private void IdentifyInitialOrderOfElements(){
        position1Element = iFeTrainingFacade.GetTrainingListElementText(0);
        position2Element = iFeTrainingFacade.GetTrainingListElementText(1);
        position3Element = iFeTrainingFacade.GetTrainingListElementText(2);
        position4Element = iFeTrainingFacade.GetTrainingListElementText(3);
    }

    @Override protected String GetReportName() {
        return "FeTrainingCustomerTraining.html";
    }

    private void InitializeProperties(){
        trainingPageLink = configLoader.GetProperties("trainingPageLink");
        errorWrongPageMessage = configLoader.GetProperties("errorWrongPageMessage");
        errorElementsAreInWrongOrderMessage = configLoader.GetProperties("errorElementsAreInWrongOrderMessage");
    }

}
