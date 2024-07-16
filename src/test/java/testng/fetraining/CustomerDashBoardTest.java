package testng.fetraining;

import org.testng.annotations.*;

public class CustomerDashBoardTest extends LoginTest {
    private String currentMonthYear, nextMonthYear, previousMonthYear, fewMonthYearsAgo, errorCalendarDisplayed, errorCalendarNotDisplayed, errorWrongMonthYear;

    @BeforeSuite (alwaysRun = true)
    public void Setup(){
        super.Setup();
        InitializeProperties();
    }

    @Test (dependsOnMethods = "LoginSuccessful", groups = "calendarnavigationbutton")
    public void PreviousButton() {
        customerDashBoardActions.ClickToday();
        InuitTest("Previous");
        customerDashBoardActions.ClickPrevious();
        HardAssertEqual(customerDashBoardActions.GetMonthDayText(), previousMonthYear, errorWrongMonthYear);
    }

    @Test (dependsOnMethods = "LoginSuccessful", groups = "calendarnavigationbutton")
    public void ForwardButton() {
        customerDashBoardActions.ClickToday();
        InuitTest("Forward");
        customerDashBoardActions.ClickForward();
        HardAssertEqual(customerDashBoardActions.GetMonthDayText(), nextMonthYear, errorWrongMonthYear);
    }

    @Test (dependsOnMethods = "LoginSuccessful", groups = "calendarnavigationbutton")
    public void TodayButton() {
        customerDashBoardActions.ClickToday();
        InuitTest("Today");
        customerDashBoardActions.ClickPrevious();
        customerDashBoardActions.ClickPrevious();
        customerDashBoardActions.ClickPrevious();
        HardAssertEqual(customerDashBoardActions.GetMonthDayText(), fewMonthYearsAgo, errorWrongMonthYear);
        customerDashBoardActions.ClickToday();
        HardAssertEqual(customerDashBoardActions.GetMonthDayText(), currentMonthYear, errorWrongMonthYear);
    }

    @Test (dependsOnMethods = "LoginSuccessful", groups = "calendarnavigationbutton")
    public void ToggleCalendarCheckBox(){
        InuitTest("ToggleCalendar");
        HardAssertTrue(customerDashBoardActions.IsCalendarDisplayed(), errorCalendarNotDisplayed);
        customerDashBoardActions.ClickToggleCalendar();
        HardAssertFalse(customerDashBoardActions.IsCalendarDisplayed(), errorCalendarDisplayed);
        customerDashBoardActions.ClickToggleCalendar();
        HardAssertTrue(customerDashBoardActions.IsCalendarDisplayed(), errorCalendarNotDisplayed);
    }

    private void InitializeProperties(){
        currentMonthYear = configLoader.GetProperties("CurrentMonthYear");
        nextMonthYear = configLoader.GetProperties("NextMonthYear");
        previousMonthYear = configLoader.GetProperties("PreviousMonthYear");
        fewMonthYearsAgo = configLoader.GetProperties("FewMonthYearsAgo");
        errorCalendarDisplayed = configLoader.GetProperties("ErrorCalendarDiplayed");
        errorCalendarNotDisplayed = configLoader.GetProperties("ErrorCalendarNotDiplayed");
        errorWrongMonthYear = configLoader.GetProperties("ErrorWrongMonthYear");

    }

}
