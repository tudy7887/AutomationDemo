package fetraining.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerDashBoardElements extends  BaseElements {
    private By logout = By.cssSelector("body > app-root > app-header > header > nav > ul > li:nth-child(6) > a");
    private By training = By.cssSelector("body > app-root > app-header > header > nav > ul > li:nth-child(4) > a");
    private By dashboard = By.cssSelector("body > app-root > app-header > header > nav > ul > li:nth-child(3) > a");
    private By email = By.id("userNameDisplay");
    private By previous = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[1]/div/button[1]");
    private By forward = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[1]/div/button[2]");
    private By today = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[1]/button");
    private By month = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[3]/div/button[1]");
    private By week = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[3]/div/button[2]");
    private By day = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[3]/div/button[3]");
    private By list = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[3]/div/button[4]");
    private By toglecalendar = By.xpath("/html/body/app-root/app-dashboard/div/div[1]/div[2]/label/input");
    private By togleweekends = By.xpath("/html/body/app-root/app-dashboard/div/div[1]/div[3]/label/input");
    private By monthyear = By.id("fc-dom-1");
    private By calendar = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[2]");
    private By addevent = By.cssSelector("#createEvent > div > div");
    private By eventttle = By.id("eventTitle");
    private By createevent = By.id("createEventButton");
    private By cancelevent = By.cssSelector("#createEvent > div > div > form > button:nth-child(3)");
    private By monday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By tuesday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By wednesday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By thursday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By friday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By saturday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By sunday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sun");
    public CustomerDashBoardElements(WebDriver driver){
        super(driver);
        SetLink("http://apptest.go.ro:9999/dashboard");
    }

    public WebElement CalendarDay(int week, int day)
    {
        var xpath = String.format("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[{}]/td[{}]/div", day, week);
        var by = By.xpath(xpath);
        return driver.findElement(by);
    }
    public WebElement LogoutButton(){
        return driver.findElement(logout);
    }
    public WebElement TrainingButton(){
        return driver.findElement(training);
    }
    public WebElement EmailButton(){
        return driver.findElement(email);
    }
    public WebElement DashBoardButton(){
        return driver.findElement(dashboard);
    }
    public WebElement PreviousButton(){
        return driver.findElement(previous);
    }
    public WebElement ForwardButton(){
        return driver.findElement(forward);
    }
    public WebElement TodayButton(){
        return driver.findElement(today);
    }
    public WebElement MonthButton(){
        return driver.findElement(month);
    }
    public WebElement DayButton(){
        return driver.findElement(day);
    }
    public WebElement WeekButton(){
        return driver.findElement(week);
    }
    public WebElement ListButton(){
        return driver.findElement(list);
    }
    public WebElement MonthYearTextBox(){
        return driver.findElement(monthyear);
    }
    public WebElement ToggleCalendarCheckBox(){
        return driver.findElement(toglecalendar);
    }
    public WebElement ToggleWeekendsCheckBox(){
        return driver.findElement(togleweekends);
    }
    public WebElement CalendarTable(){
        return driver.findElement(calendar);
    }
    public WebElement AddEventPopup(){
        return driver.findElement(addevent);
    }
    public WebElement CreateEventButton(){
        return driver.findElement(createevent);
    }
    public WebElement CancelEventButton(){
        return driver.findElement(cancelevent);
    }
    public WebElement EventTitleInput(){
        return driver.findElement(eventttle);
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
    public WebElement SundayColumn(){
        return driver.findElement(sunday);
    }

}
