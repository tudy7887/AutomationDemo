package fetraining.actions;

import fetraining.interfaces.ICustomerDashBoardPageActions;
import org.openqa.selenium.WebDriver;
import fetraining.elements.CustomerDashBoardElements;

public class CustomerDashBoardPageActions extends BaseActions implements ICustomerDashBoardPageActions {
    private CustomerDashBoardElements elements;

    public CustomerDashBoardPageActions(WebDriver driver){
        super(driver);
        elements = new CustomerDashBoardElements(driver);
        SetBaseElements(elements);
    }

    public void ClickLogout(){
        elements.LogoutButton().click();
    }
    public void ClickDashBoard(){
        elements.DashBoardButton().click();
    }
    public void ClickTraining(){
        elements.TrainingButton().click();
    }
    public void ClickEmail(){
        elements.EmailButton().click();
    }
    public String GetEmail(){
        return elements.EmailButton().getText();
    }
    public void ClickPrevious(){
        elements.PreviousButton().click();
    }
    public void ClickForward(){
        elements.ForwardButton().click();
    }
    public void ClickToggleCalendar(){
        elements.ToggleCalendarCheckBox().click();
    }
    public void ClickToggleWeekends(){
        elements.ToggleWeekendsCheckBox().click();
    }
    public void ClickMonth(){
        elements.MonthButton().click();
    }
    public void ClickDay(){
        elements.DayButton().click();
    }
    public void ClickWeek(){
        elements.WeekButton().click();
    }
    public void ClickList(){
        elements.ListButton().click();
    }
    public void ClickCreateEvent(){
        elements.CreateEventButton().click();
    }
    public void ClickCancelEvent(){
        elements.CancelEventButton().click();
    }
    public void ClickToday(){
        elements.TodayButton().click();
    }
    public void ClickCalendar(int week, int day){
        elements.CalendarDay(week, day).click();
    }
    public void InsertTextToEventTitle(String input){
        elements.EventTitleInput().sendKeys(input);
    }
    public void ClearEventTitle(){
        elements.EventTitleInput().clear();
    }
    public String GetMonthDayText(){
        return  elements.MonthYearTextBox().getText();
    }
    public boolean IsCalendarDisplayed() {
        try {
            return elements.CalendarTable().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean IsMondayDisplayed() {
        try {
            return elements.MondayColumn().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean IsTuesdayDisplayed() {
        try {
            return elements.TuesdayColumn().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean IsWednesdayDisplayed() {
        try {
            return elements.WednesdayColumn().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean IsThursdayDisplayed() {
        try {
            return elements.ThursdayColumn().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean IsFridayDisplayed() {
        try {
            return elements.FridayColumn().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean IsSaturdayDisplayed() {
        try {
            return elements.SaturdayColumn().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean IsSundayDisplayed() {
        try {
            return elements.SundayColumn().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
