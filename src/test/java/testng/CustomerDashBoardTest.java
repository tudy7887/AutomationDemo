package testng;

import org.testng.Assert;
import org.testng.annotations.*;
import fetraining.actions.CustomerDashBoardActions;
import fetraining.actions.LoginActions;

public class CustomerDashBoardTest extends BaseTest{
    private String currentMonthYear, nextMonthYear, previousMonthYear, fewMonthYearsAgo, errorCalendarDiplayed, errorCalendarNotDiplayed, errorWrongMonthYear;

    @BeforeSuite
    public void Setup(){
        super.Setup();
        InitializeProperties();
        loginActions = new LoginActions(driver);
        customerDashBoardActions =  new CustomerDashBoardActions(driver);
        driver.get(url);
        Login();
    }

    @AfterSuite
    public void Teardown(){
        Logout();
        super.Teardown();
    }

    @Test
    public void PreviousButton() {
        customerDashBoardActions.ClickToday();
        InuitTest("Previous");
        customerDashBoardActions.ClickPrevious();
        Assert.assertEquals(customerDashBoardActions.GetMonthDayText(), previousMonthYear, errorWrongMonthYear);
    }

    @Test
    public void ForwardButton() {
        customerDashBoardActions.ClickToday();
        InuitTest("Forward");
        customerDashBoardActions.ClickForward();
        Assert.assertEquals(customerDashBoardActions.GetMonthDayText(), nextMonthYear, errorWrongMonthYear);
    }

    @Test
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

    @Test
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
