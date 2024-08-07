package fetraining.facade;

public interface IFeTrainingFacade {
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
    void SetMail(String text);
    void SetPassword(String text);
    void ClickLogin();
    String GetErrorMessage();
    void ClearMail();
    void ClearPassword();
    void MoveTrainingListToMonday(int indexElement);
    void MoveTrainingListToTuesday(int indexElement);
    void MoveTrainingListToWednesday(int indexElement);
    void MoveTrainingListToThursday(int indexElement);
    void MoveTrainingListToFriday(int indexElement);
    void MoveTrainingListToSaturday(int indexElement);
    void MoveTrainingListToSunday(int indexElement);
    void MoveMondayToTrainingList(int indexElement);
    void MoveTuesdayToTrainingList(int indexElement);
    void MoveWednesdayToTrainingList(int indexElement);
    void MoveThursdayToTrainingList(int indexElement);
    void MoveFridayToTrainingList(int indexElement);
    void MoveSaturdayToTrainingList(int indexElement);
    void MoveSundayToTrainingList(int indexElement);
    String GetTrainingListElementText(int indexElement);
    String GetMondayElementText(int indexElement);
    String GetTuesdayElementText(int indexElement);
    String GetWednesdayElementText(int indexElement);
    String GetThursdayElementText(int indexElement);
    String GetFridayElementText(int indexElement);
    String GetSaturdayElementText(int indexElement);
    String GetSundayElementText(int indexElement);
    void ClickGenerateAllButton();

    // Go To Page And Wait Until Loaded
    void GotoLoginPage();
    void WaitUntilLoginPageLoaded();
    void GotoCustomerDashBoardPage();
    void WaitUntilCustomerDashBoardPageLoaded();
    void GotoCustomerTrainingPage();
    void WaitUntilCustomerTrainingPageLoaded();
    String GetCurrentUrl();
}
