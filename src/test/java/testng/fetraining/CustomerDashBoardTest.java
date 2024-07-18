package testng.fetraining;

import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class CustomerDashBoardTest extends LoginTest {
    private Map<Integer, String> months;
    private String errorWrongMonthYearMessage, errorCalendarNotDisplayedMessage, errorCalendarDisplayedMessage,
            errorMondayNotDisplayedMessage, errorTuesdayNotDisplayedMessage, errorWednesdayNotDisplayedMessage,
            errorThursdayNotDisplayedMessage, errorFridayNotDisplayedMessage, errorSaturdayNotDisplayedMessage,
            errorSundayNotDisplayedMessage, errorSaturdayDisplayedMessage, errorSundayDisplayedMessage,
            dashBoardPageLink, errorWrongPageMessage;
    private Integer thisMonth, thisYear;

    @BeforeSuite (alwaysRun = true)
    public void Setup(){
        super.Setup();
        InitializeProperties();
    }

    @Test (dependsOnMethods = "LoginSuccessful", groups = "trainingmenu")
    public void GoToDashBoardMenu(){
        InuitTest("Go To Dash Board Menu");
        iFeTrainingFacade.ClickDashBoard();
        HardAssertEqual(iFeTrainingFacade.GetCurrentUrl(), dashBoardPageLink, errorWrongPageMessage);
    }

    @Test (dependsOnMethods = "GoToDashBoardMenu", groups = "calendarnavigation")
    public void Previous12Month() {
        InuitTest("Previous 12 Month");
        SetToday();
        iFeTrainingFacade.ClickToday();
        HardAssertEqual(iFeTrainingFacade.GetMonthDayText(), GetMonthYear(), errorWrongMonthYearMessage);

        // Previous 12 Month
        for (var i = 0; i < 12; i++) {
            iFeTrainingFacade.ClickPrevious();
            SetYearMonth(-1);
            HardAssertEqual(iFeTrainingFacade.GetMonthDayText(), GetMonthYear(), errorWrongMonthYearMessage);
        }
    }

    @Test (dependsOnMethods = "GoToDashBoardMenu", groups = "calendarnavigation")
    public void Next12Month() {
        InuitTest("Next 12 Month");
        SetToday();
        iFeTrainingFacade.ClickToday();
        HardAssertEqual(iFeTrainingFacade.GetMonthDayText(), GetMonthYear(), errorWrongMonthYearMessage);

        // Previous 12 Month
        for (var i = 0; i < 12; i++) {
            iFeTrainingFacade.ClickForward();
            SetYearMonth(1);
            HardAssertEqual(iFeTrainingFacade.GetMonthDayText(), GetMonthYear(), errorWrongMonthYearMessage);
        }
    }

    @Test (dependsOnMethods = "GoToDashBoardMenu", groups = "checkboxes")
    public void ToggleCalendarCheckBox(){
        InuitTest("Toggle Calendar");
        HardAssertTrue(iFeTrainingFacade.IsCalendarDisplayed(), errorCalendarNotDisplayedMessage, "Calendar is displayed");
        iFeTrainingFacade.ClickToggleCalendar();
        HardAssertFalse(iFeTrainingFacade.IsCalendarDisplayed(), errorCalendarDisplayedMessage, "Calendar is not displayed");
        iFeTrainingFacade.ClickToggleCalendar();
        HardAssertTrue(iFeTrainingFacade.IsCalendarDisplayed(), errorCalendarNotDisplayedMessage, "Calendar is displayed");
    }

    @Test (dependsOnMethods = "GoToDashBoardMenu", groups = "checkboxes")
    public void ToggleWeekendsCheckBox(){
        InuitTest("Toggle Weekends");
        AssertWithWeekend();
        iFeTrainingFacade.ClickToggleWeekends();
        AssertWithoutWeekend();
        iFeTrainingFacade.ClickToggleWeekends();
        AssertWithWeekend();
    }

    private String GetMonthYear(){
        return String.format("%s %s", months.get(thisMonth), thisYear);
    }

    private void SetToday(){
        thisMonth = 7;
        thisYear = 2024;
    }

    private void SetYearMonth(int previousForward){
        SetYear(previousForward);
        SetMonth(previousForward);
    }

    private void SetMonth(int previousForward){
        var result = thisMonth + previousForward;
        if(result % 12 == 0){
            thisMonth = 12;
        } else if(result > 0){
            thisMonth = result % 12;
        }
        else{
            thisMonth = (12 - (result % 12));
        }
    }

    private void SetYear(int previousForward){
        var result = thisMonth + previousForward;
        var difference = 1 + previousForward / 12;
        if(result <= 0){
            thisYear-= difference;
        }
        else if(result > 12){
            thisYear+= difference;
        }
    }

    private void AssertWithWeekend(){
        SoftAssertTrue(iFeTrainingFacade.IsMondayDisplayed(), errorMondayNotDisplayedMessage, "Monday is displayed");
        SoftAssertTrue(iFeTrainingFacade.IsTuesdayDisplayed(), errorTuesdayNotDisplayedMessage, "Tuesday is displayed");
        SoftAssertTrue(iFeTrainingFacade.IsWednesdayDisplayed(), errorWednesdayNotDisplayedMessage, "Wednesday is displayed");
        SoftAssertTrue(iFeTrainingFacade.IsThursdayDisplayed(), errorThursdayNotDisplayedMessage, "Thursday is displayed");
        SoftAssertTrue(iFeTrainingFacade.IsFridayDisplayed(), errorFridayNotDisplayedMessage, "Friday is displayed");
        SoftAssertTrue(iFeTrainingFacade.IsSaturdayDisplayed(), errorSaturdayNotDisplayedMessage, "Saturday is displayed");
        SoftAssertTrue(iFeTrainingFacade.IsSundayDisplayed(), errorSundayNotDisplayedMessage, "Sunday is displayed");
    }

    private void AssertWithoutWeekend(){
        SoftAssertTrue(iFeTrainingFacade.IsMondayDisplayed(), errorMondayNotDisplayedMessage, "Monday is displayed");
        SoftAssertTrue(iFeTrainingFacade.IsTuesdayDisplayed(), errorTuesdayNotDisplayedMessage, "Tuesday is displayed");
        SoftAssertTrue(iFeTrainingFacade.IsWednesdayDisplayed(), errorWednesdayNotDisplayedMessage, "Wednesday is displayed");
        SoftAssertTrue(iFeTrainingFacade.IsThursdayDisplayed(), errorThursdayNotDisplayedMessage, "Thursday is displayed");
        SoftAssertTrue(iFeTrainingFacade.IsFridayDisplayed(), errorFridayNotDisplayedMessage, "Friday is displayed");
        SoftAssertFalse(iFeTrainingFacade.IsSaturdayDisplayed(), errorSaturdayDisplayedMessage, "Saturday is not displayed");
        SoftAssertFalse(iFeTrainingFacade.IsSundayDisplayed(), errorSundayDisplayedMessage, "Sunday is not displayed");
    }

    @Override protected String GetReportName() {
        return "FeTrainingCustomerDashBoard.html";
    }

    private void InitializeProperties(){
        SetToday();
        errorWrongMonthYearMessage = configLoader.GetProperties("errorWrongMonthYearMessage");
        errorCalendarNotDisplayedMessage = configLoader.GetProperties("errorCalendarNotDisplayedMessage");
        errorCalendarDisplayedMessage = configLoader.GetProperties("errorCalendarDisplayedMessage");
        errorMondayNotDisplayedMessage = configLoader.GetProperties("errorMondayNotDisplayedMessage");
        errorTuesdayNotDisplayedMessage = configLoader.GetProperties("errorTuesdayNotDisplayedMessage");
        errorWednesdayNotDisplayedMessage = configLoader.GetProperties("errorWednesdayNotDisplayedMessage");
        errorThursdayNotDisplayedMessage = configLoader.GetProperties("errorThursdayNotDisplayedMessage");
        errorFridayNotDisplayedMessage = configLoader.GetProperties("errorFridayNotDisplayedMessage");
        errorSaturdayNotDisplayedMessage = configLoader.GetProperties("errorSaturdayNotDisplayedMessage");
        errorSundayNotDisplayedMessage = configLoader.GetProperties("errorSundayNotDisplayedMessage");
        errorSaturdayDisplayedMessage = configLoader.GetProperties("errorSaturdayDisplayedMessage");
        errorSundayDisplayedMessage = configLoader.GetProperties("errorSundayDisplayedMessage");
        errorWrongPageMessage = configLoader.GetProperties("errorWrongPageMessage");
        dashBoardPageLink = configLoader.GetProperties("dashBoardPageLink");

        months = new HashMap<Integer, String>();
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");
    }

}
