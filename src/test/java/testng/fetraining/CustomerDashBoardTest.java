package testng.fetraining;

import fetraining.actions.CustomerDashBoardActions;
import org.testng.Assert;
import org.testng.annotations.*;

public class CustomerDashBoardTest extends LoginTest {
    private String currentMonthYear, nextMonthYear, previousMonthYear, fewMonthYearsAgo, errorCalendarDiplayed, errorCalendarNotDiplayed, errorWrongMonthYear;

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
        Assert.assertEquals(customerDashBoardActions.GetMonthDayText(), previousMonthYear, errorWrongMonthYear);
    }

    @Test (dependsOnMethods = "LoginSuccessfull", groups = "calendarnavigationbutton")
    public void ForwardButton() {
        customerDashBoardActions.ClickToday();
        InuitTest("Forward");
        customerDashBoardActions.ClickForward();
        Assert.assertEquals(customerDashBoardActions.GetMonthDayText(), nextMonthYear, errorWrongMonthYear);
    }

    @Test (dependsOnMethods = "LoginSuccessfull", groups = "calendarnavigationbutton")
    public void TodayButton() {
        customerDashBoardActions.ClickToday();
        InuitTest("Today");
        customerDashBoardActions.ClickPrevious();
        customerDashBoardActions.ClickPrevious();
        customerDashBoardActions.ClickPrevious();
        Assert.assertEquals(customerDashBoardActions.GetMonthDayText(), fewMonthYearsAgo, errorWrongMonthYear);
        customerDashBoardActions.ClickToday();
        Assert.assertEquals(customerDashBoardActions.GetMonthDayText(), currentMonthYear, errorWrongMonthYear);
    }

    @Test (dependsOnMethods = "LoginSuccessfull", groups = "calendarnavigationbutton")
    public void ToggleCalendarCheckBox(){
        InuitTest("ToggleCalendar");
        Assert.assertTrue(customerDashBoardActions.IsCalendarDisplayed(), errorCalendarNotDiplayed);
        customerDashBoardActions.ClickToggleCalendar();
        Assert.assertFalse(customerDashBoardActions.IsCalendarDisplayed(), errorCalendarDiplayed);
        customerDashBoardActions.ClickToggleCalendar();
        Assert.assertTrue(customerDashBoardActions.IsCalendarDisplayed(), errorCalendarNotDiplayed);
    }

    private void InitializeProperties(){
        currentMonthYear = configLoader.getProperties("CurrentMonthYear");
        nextMonthYear = configLoader.getProperties("NextMonthYear");
        previousMonthYear = configLoader.getProperties("PreviousMonthYear");
        fewMonthYearsAgo = configLoader.getProperties("FewMonthYearsAgo");
        errorCalendarDiplayed = configLoader.getProperties("ErrorCalendarDiplayed");
        errorCalendarNotDiplayed = configLoader.getProperties("ErrorCalendarNotDiplayed");
        errorWrongMonthYear = configLoader.getProperties("ErrorWrongMonthYear");

    }

}
