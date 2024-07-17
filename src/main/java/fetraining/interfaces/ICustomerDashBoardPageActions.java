package fetraining.interfaces;

public interface ICustomerDashBoardPageActions extends IBaseActions{
    void ClickLogout();
    void ClickDashBoard();
    void ClickTraining();
    void ClickEmail();
    String GetEmail();
    void ClickPrevious();
    void ClickForward();
    void ClickToggleCalendar();
    void ClickToggleWeekends();
    void ClickMonth();
    void ClickDay();
    void ClickWeek();
    void ClickList();
    void ClickCreateEvent();
    void ClickCancelEvent();
    void ClickToday();
    void ClickCalendar(int week, int day);
    void InsertTextToEventTitle(String input);
    void ClearEventTitle();
    String GetMonthDayText();
    boolean IsCalendarDisplayed();
    boolean IsMondayDisplayed();
    boolean IsTuesdayDisplayed();
    boolean IsWednesdayDisplayed();
    boolean IsThursdayDisplayed();
    boolean IsFridayDisplayed();
    boolean IsSaturdayDisplayed();
    boolean IsSundayDisplayed();
}
