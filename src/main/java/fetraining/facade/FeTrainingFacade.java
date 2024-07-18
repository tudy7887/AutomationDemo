package fetraining.facade;

import fetraining.actions.*;
import org.openqa.selenium.WebDriver;
import fetraining.interfaces.*;

public class FeTrainingFacade implements IFeTrainingFacade{
    private WebDriver driver;
    protected ILoginPageActions iLoginPageActions;
    protected ICustomerDashBoardPageActions iCustomerDashBoardPageActions;
    protected ICustomerTrainingPageActions iCustomerTrainingPageActions;

    public FeTrainingFacade(WebDriver driver){
        this.driver = driver;
        iLoginPageActions = new LoginPageActions(driver);
        iCustomerTrainingPageActions = new CustomerTrainingPageActions(driver);
        iCustomerDashBoardPageActions = new CustomerDashBoardPageActions (driver);
    }

    public void ClickLogout(){
        iCustomerDashBoardPageActions.ClickLogout();
    }
    public void ClickDashBoard(){
        iCustomerDashBoardPageActions.ClickDashBoard();
    }
    public void ClickTraining(){
        iCustomerDashBoardPageActions.ClickTraining();
    }
    public void ClickEmail(){
        iCustomerDashBoardPageActions.ClickEmail();
    }
    public String GetEmail(){
        return iCustomerDashBoardPageActions.GetEmail();
    }
    public void ClickPrevious(){
        iCustomerDashBoardPageActions.ClickPrevious();
    }
    public void ClickForward(){
        iCustomerDashBoardPageActions.ClickForward();
    }
    public void ClickToggleCalendar(){
        iCustomerDashBoardPageActions.ClickToggleCalendar();
    }
    public void ClickToggleWeekends(){
        iCustomerDashBoardPageActions.ClickToggleWeekends();
    }
    public void ClickMonth(){
        iCustomerDashBoardPageActions.ClickMonth();
    }
    public void ClickDay(){
        iCustomerDashBoardPageActions.ClickDay();
    }
    public void ClickWeek(){
        iCustomerDashBoardPageActions.ClickWeek();
    }
    public void ClickList(){
        iCustomerDashBoardPageActions.ClickList();
    }
    public void ClickCreateEvent(){
        iCustomerDashBoardPageActions.ClickCreateEvent();
    }
    public void ClickCancelEvent(){
        iCustomerDashBoardPageActions.ClickCancelEvent();
    }
    public void ClickToday(){
        iCustomerDashBoardPageActions.ClickToday();
    }
    public void ClickCalendar(int week, int day){
        iCustomerDashBoardPageActions.ClickCalendar(week,day);
    }
    public void InsertTextToEventTitle(String input){
        iCustomerDashBoardPageActions.InsertTextToEventTitle(input);
    }
    public void ClearEventTitle(){
        iCustomerDashBoardPageActions.ClearEventTitle();
    }
    public String GetMonthDayText(){
        return iCustomerDashBoardPageActions.GetMonthDayText();
    }
    public boolean IsCalendarDisplayed(){
        return iCustomerDashBoardPageActions.IsCalendarDisplayed();
    }
    public boolean IsMondayDisplayed(){
        return iCustomerDashBoardPageActions.IsMondayDisplayed();
    }
    public boolean IsTuesdayDisplayed(){
        return  iCustomerDashBoardPageActions.IsTuesdayDisplayed();
    }
    public boolean IsWednesdayDisplayed(){
        return iCustomerDashBoardPageActions.IsWednesdayDisplayed();
    }
    public boolean IsThursdayDisplayed(){
        return iCustomerDashBoardPageActions.IsThursdayDisplayed();
    }
    public boolean IsFridayDisplayed(){
        return iCustomerDashBoardPageActions.IsFridayDisplayed();
    }
    public boolean IsSaturdayDisplayed(){
        return iCustomerDashBoardPageActions.IsSaturdayDisplayed();
    }
    public boolean IsSundayDisplayed(){
        return iCustomerDashBoardPageActions.IsSundayDisplayed();
    }
    public void SetMail(String text){
        iLoginPageActions.SetMail(text);
    }
    public void SetPassword(String text){
        iLoginPageActions.SetPassword(text);
    }
    public void ClickLogin(){
        iLoginPageActions.ClickLogin();
    }
    public String GetErrorMessage(){
        return iLoginPageActions.GetErrorMessage();
    }
    public void ClearMail(){
        iLoginPageActions.ClearMail();
    }
    public void ClearPassword(){
        iLoginPageActions.ClearPassword();
    }
    public void MoveTrainingListToMonday(int indexElement){
        iCustomerTrainingPageActions.MoveTrainingListToMonday(indexElement);
    }
    public void MoveTrainingListToTuesday(int indexElement){
        iCustomerTrainingPageActions.MoveTrainingListToTuesday(indexElement);
    }
    public void MoveTrainingListToWednesday(int indexElement){
        iCustomerTrainingPageActions.MoveTrainingListToWednesday(indexElement);
    }
    public void MoveTrainingListToThursday(int indexElement){
        iCustomerTrainingPageActions.MoveTrainingListToThursday(indexElement);
    }
    public void MoveTrainingListToFriday(int indexElement){
        iCustomerTrainingPageActions.MoveTrainingListToFriday(indexElement);
    }
    public void MoveTrainingListToSaturday(int indexElement){
        iCustomerTrainingPageActions.MoveTrainingListToSaturday(indexElement);
    }
    public void MoveTrainingListToSunday(int indexElement){
        iCustomerTrainingPageActions.MoveTrainingListToSunday(indexElement);
    }
    public void MoveMondayToTrainingList(int indexElement){
        iCustomerTrainingPageActions.MoveMondayToTrainingList(indexElement);
    }
    public void MoveTuesdayToTrainingList(int indexElement){
        iCustomerTrainingPageActions.MoveTuesdayToTrainingList(indexElement);
    }
    public void MoveWednesdayToTrainingList(int indexElement){
        iCustomerTrainingPageActions.MoveWednesdayToTrainingList(indexElement);
    }
    public void MoveThursdayToTrainingList(int indexElement){
        iCustomerTrainingPageActions.MoveThursdayToTrainingList(indexElement);
    }
    public void MoveFridayToTrainingList(int indexElement){
        iCustomerTrainingPageActions.MoveFridayToTrainingList(indexElement);
    }
    public void MoveSaturdayToTrainingList(int indexElement){
        iCustomerTrainingPageActions.MoveSaturdayToTrainingList(indexElement);
    }
    public void MoveSundayToTrainingList(int indexElement){
        iCustomerTrainingPageActions.MoveSundayToTrainingList(indexElement);
    }
    public String GetTrainingListElementText(int indexElement){
        return iCustomerTrainingPageActions.GetTrainingListElementText(indexElement);
    }
    public String GetMondayElementText(int indexElement){
        return iCustomerTrainingPageActions.GetMondayElementText(indexElement);
    }
    public String GetTuesdayElementText(int indexElement){
        return iCustomerTrainingPageActions.GetTuesdayElementText(indexElement);
    }
    public String GetWednesdayElementText(int indexElement){
        return iCustomerTrainingPageActions.GetWednesdayElementText(indexElement);
    }
    public String GetThursdayElementText(int indexElement){
        return iCustomerTrainingPageActions.GetThursdayElementText(indexElement);
    }
    public String GetFridayElementText(int indexElement){
        return iCustomerTrainingPageActions.GetFridayElementText(indexElement);
    }
    public String GetSaturdayElementText(int indexElement){
        return iCustomerTrainingPageActions.GetSaturdayElementText(indexElement);
    }
    public String GetSundayElementText(int indexElement){
        return iCustomerTrainingPageActions.GetSundayElementText(indexElement);
    }
    public void ClickGenerateAllButton(){
        iCustomerTrainingPageActions.ClickGenerateAllButton();
    }

    // Go To Page And Wait Until Loaded
    public void GotoLoginPage(){
        iLoginPageActions.GotoPage();
    }
    public void WaitUntilLoginPageLoaded(){
        iLoginPageActions.WaitUntilLoaded();
    }
    public void GotoCustomerDashBoardPage(){
        iCustomerDashBoardPageActions.GotoPage();
    }
    public void WaitUntilCustomerDashBoardPageLoaded(){
        iCustomerDashBoardPageActions.WaitUntilLoaded();
    }
    public String GetCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public void GotoCustomerTrainingPage(){
        iCustomerTrainingPageActions.GotoPage();
    }
    public void WaitUntilCustomerTrainingPageLoaded(){
        iCustomerTrainingPageActions.WaitUntilLoaded();
    }
}
