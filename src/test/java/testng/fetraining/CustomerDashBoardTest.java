package testng.fetraining;

import org.testng.annotations.*;

public class CustomerDashBoardTest extends LoginTest {
    private String currentMonthYear, nextmonthyear, previousMonthYear, fewMonthYearsAgo, errorCalendarDiplayed, errorCalendarNotDiplayed, errorWrongMonthYear;

    @BeforeSuite (alwaysRun = true)
    public void Setup(){
        super.Setup();
        InitializeProperties();
    }

    @Test (dependsOnMethods = "LoginSuccessfull", groups = "calendarnavigationbutton")
    public void PreviousButton() {
        customerDashBoardActions.ClickToday();
        InuitTest("Previous");
        customerDashBoardActions.ClickPrevious();
        HardAssertEqual(customerDashBoardActions.GetMonthDayText(), previousMonthYear, errorWrongMonthYear);
    }

    @Test (dependsOnMethods = "LoginSuccessfull", groups = "calendarnavigationbutton")
    public void ForwardButton() {
        customerDashBoardActions.ClickToday();
        InuitTest("Forward");
        customerDashBoardActions.ClickForward();
        HardAssertEqual(customerDashBoardActions.GetMonthDayText(), nextmonthyear, errorWrongMonthYear);
    }

    @Test (dependsOnMethods = "LoginSuccessfull", groups = "calendarnavigationbutton")
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

    @Test (dependsOnMethods = "LoginSuccessfull", groups = "calendarnavigationbutton")
    public void ToggleCalendarCheckBox(){
        InuitTest("ToggleCalendar");
        HardAssertTrue(customerDashBoardActions.IsCalendarDisplayed(), errorCalendarNotDiplayed);
        customerDashBoardActions.ClickToggleCalendar();
        HardAssertFalse(customerDashBoardActions.IsCalendarDisplayed(), errorCalendarDiplayed);
        customerDashBoardActions.ClickToggleCalendar();
        HardAssertTrue(customerDashBoardActions.IsCalendarDisplayed(), errorCalendarNotDiplayed);
    }

    private void InitializeProperties(){
        currentMonthYear = configLoader.GetProperties("CurrentMonthYear");
        nextmonthyear = configLoader.GetProperties("NextMonthYear");
        previousMonthYear = configLoader.GetProperties("PreviousMonthYear");
        fewMonthYearsAgo = configLoader.GetProperties("FewMonthYearsAgo");
        errorCalendarDiplayed = configLoader.GetProperties("ErrorCalendarDiplayed");
        errorCalendarNotDiplayed = configLoader.GetProperties("ErrorCalendarNotDiplayed");
        errorWrongMonthYear = configLoader.GetProperties("ErrorWrongMonthYear");

    }

}
