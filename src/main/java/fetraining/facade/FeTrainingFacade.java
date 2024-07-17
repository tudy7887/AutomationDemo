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
}
