package fetraining.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerDashBoardElements extends  BaseElements {
    private By logoutButton, trainingButton, dashboardButton, emailButton, monthYearText, addEventPopup, eventTitle,
            createEventButton, cancelEventButton, monday, tuesday, wednesday, thursday, friday, saturday, sunday,
            previousButton, forwardButton, todayButton, monthButton, weekButton, dayButton, listButton,
            toggleCalendarCheckBox, toggleWeekendsCheckBox, calendar;

    public CustomerDashBoardElements(WebDriver driver){
        super(driver);
        SetLink("http://apptest.go.ro:9999/dashboard");
        InitializeElements();
    }

    public WebElement CalendarDay(int week, int day)
    {
        var xpath = String.format("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[{}]/td[{}]/div", day, week);
        var by = By.xpath(xpath);
        return driver.findElement(by);
    }
    public WebElement LogoutButton(){
        return driver.findElement(logoutButton);
    }
    public WebElement TrainingButton(){
        return driver.findElement(trainingButton);
    }
    public WebElement EmailButton(){
        return driver.findElement(emailButton);
    }
    public WebElement DashBoardButton(){
        return driver.findElement(dashboardButton);
    }
    public WebElement PreviousButton(){
        return driver.findElement(previousButton);
    }
    public WebElement ForwardButton(){
        return driver.findElement(forwardButton);
    }
    public WebElement TodayButton(){
        return driver.findElement(todayButton);
    }
    public WebElement MonthButton(){
        return driver.findElement(monthButton);
    }
    public WebElement DayButton(){
        return driver.findElement(dayButton);
    }
    public WebElement WeekButton(){
        return driver.findElement(weekButton);
    }
    public WebElement ListButton(){
        return driver.findElement(listButton);
    }
    public WebElement MonthYearTextBox(){
        return driver.findElement(monthYearText);
    }
    public WebElement ToggleCalendarCheckBox(){ return driver.findElement(toggleCalendarCheckBox); }
    public WebElement ToggleWeekendsCheckBox(){
        return driver.findElement(toggleWeekendsCheckBox);
    }
    public WebElement CalendarTable(){
        return driver.findElement(calendar);
    }
    public WebElement AddEventPopup(){
        return driver.findElement(addEventPopup);
    }
    public WebElement CreateEventButton(){
        return driver.findElement(createEventButton);
    }
    public WebElement CancelEventButton(){
        return driver.findElement(cancelEventButton);
    }
    public WebElement EventTitleInput(){
        return driver.findElement(eventTitle);
    }
    public WebElement MondayColumn(){
        return driver.findElement(monday);
    }
    public WebElement TuesdayColumn(){
        return driver.findElement(tuesday);
    }
    public WebElement WednesdayColumn(){
        return driver.findElement(wednesday);
    }
    public WebElement ThursdayColumn(){
        return driver.findElement(thursday);
    }
    public WebElement FridayColumn(){
        return driver.findElement(friday);
    }
    public WebElement SaturdayColumn(){
        return driver.findElement(saturday);
    }
    public WebElement SundayColumn() { return driver.findElement(sunday); }

    private void InitializeElements(){
        logoutButton = GetElementByCSSSlecetor(configLoader.GetProperties("logoutButton"));
        trainingButton = GetElementByCSSSlecetor(configLoader.GetProperties("trainingButton"));
        dashboardButton = GetElementByCSSSlecetor(configLoader.GetProperties("dashboardButton"));
        emailButton = GetElementByCSSSlecetor(configLoader.GetProperties("emailButton"));
        monthYearText = GetElementByCSSSlecetor(configLoader.GetProperties("monthYearText"));
        addEventPopup = GetElementByCSSSlecetor(configLoader.GetProperties("addEventPopup"));
        eventTitle = GetElementByCSSSlecetor(configLoader.GetProperties("eventTitle"));
        createEventButton = GetElementByCSSSlecetor(configLoader.GetProperties("createEventButton"));
        cancelEventButton = GetElementByCSSSlecetor(configLoader.GetProperties("cancelEventButton"));
        monday = GetElementByCSSSlecetor(configLoader.GetProperties("monday"));
        tuesday = GetElementByCSSSlecetor(configLoader.GetProperties("tuesday"));
        wednesday = GetElementByCSSSlecetor(configLoader.GetProperties("wednesday"));
        thursday = GetElementByCSSSlecetor(configLoader.GetProperties("thursday"));
        friday = GetElementByCSSSlecetor(configLoader.GetProperties("friday"));
        saturday = GetElementByCSSSlecetor(configLoader.GetProperties("saturday"));
        sunday = GetElementByCSSSlecetor(configLoader.GetProperties("sunday"));
        previousButton = GetElementByCSSSlecetor(configLoader.GetProperties("previousButton"));
        forwardButton = GetElementByCSSSlecetor(configLoader.GetProperties("forwardButton"));
        todayButton = GetElementByCSSSlecetor(configLoader.GetProperties("todayButton"));
        monthButton = GetElementByCSSSlecetor(configLoader.GetProperties("monthButton"));
        weekButton = GetElementByCSSSlecetor(configLoader.GetProperties("weekButton"));
        dayButton = GetElementByCSSSlecetor(configLoader.GetProperties("dayButton"));
        listButton = GetElementByCSSSlecetor(configLoader.GetProperties("listButton"));
        toggleCalendarCheckBox = GetElementByCSSSlecetor(configLoader.GetProperties("toggleCalendarCheckBox"));
        toggleWeekendsCheckBox = GetElementByCSSSlecetor(configLoader.GetProperties("toggleWeekendsCheckBox"));
        calendar = GetElementByCSSSlecetor(configLoader.GetProperties("calendar"));
    }
}
