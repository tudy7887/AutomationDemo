package template.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerDashBoardElements {
    private WebDriver driver;
    private By Logout = By.cssSelector("body > app-root > app-header > header > nav > ul > li:nth-child(6) > a");
    private By Training = By.cssSelector("body > app-root > app-header > header > nav > ul > li:nth-child(4) > a");
    private By DashBoard = By.cssSelector("body > app-root > app-header > header > nav > ul > li:nth-child(3) > a");
    private By Email = By.id("userNameDisplay");
    private By Previous = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[1]/div/button[1]");
    private By Forward = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[1]/div/button[2]");
    private By Today = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[1]/button");
    private By Month = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[3]/div/button[1]");
    private By Week = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[3]/div/button[2]");
    private By Day = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[3]/div/button[3]");
    private By List = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[1]/div[3]/div/button[4]");
    private By TogleCalendar = By.xpath("/html/body/app-root/app-dashboard/div/div[1]/div[2]/label/input");
    private By TogleWeekends = By.xpath("/html/body/app-root/app-dashboard/div/div[1]/div[3]/label/input");
    private By MonthYear = By.id("fc-dom-189");
    private By Calendar = By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[2]");
    private By AddEvent = By.cssSelector("#createEvent > div > div");
    private By EventTtle = By.id("eventTitle");
    private By CreateEvent = By.id("createEventButton");
    private By CancelEvent = By.cssSelector("#createEvent > div > div > form > button:nth-child(3)");
    private By Monday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By Tuesday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By Wednesday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By Thursday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By Friday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By Saturday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sat");
    private By Sunday = By.cssSelector("th.fc-col-header-cell.fc-day.fc-day-sun");
    private String Link = "http://apptest.go.ro:9999/dashboard";
    public CustomerDashBoardElements(WebDriver driver){
        this.driver = driver;
    }

    public String GetLoginLink(){return Link;}

    public WebElement CalendarDay(int week, int day)
    {
        var xpath = String.format("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[{}]/td[{}]/div", day, week);
        var by = By.xpath(xpath);
        return driver.findElement(by);
    }
    public WebElement LogoutButton(){
        return driver.findElement(Logout);
    }
    public WebElement TrainingButton(){
        return driver.findElement(Training);
    }
    public WebElement EmailButton(){
        return driver.findElement(Email);
    }
    public WebElement DashBoardButton(){
        return driver.findElement(DashBoard);
    }
    public WebElement PreviousButton(){
        return driver.findElement(Previous);
    }
    public WebElement ForwardButton(){
        return driver.findElement(Forward);
    }
    public WebElement TodayButton(){
        return driver.findElement(Today);
    }
    public WebElement MonthButton(){
        return driver.findElement(Month);
    }
    public WebElement DayButton(){
        return driver.findElement(Day);
    }
    public WebElement WeekButton(){
        return driver.findElement(Week);
    }
    public WebElement ListButton(){
        return driver.findElement(List);
    }
    public WebElement MonthYearTextBox(){
        return driver.findElement(MonthYear);
    }
    public WebElement ToggleCalendarCheckBox(){
        return driver.findElement(TogleCalendar);
    }
    public WebElement ToggleWeekendsCheckBox(){
        return driver.findElement(TogleWeekends);
    }
    public WebElement CalendarTable(){
        return driver.findElement(Calendar);
    }
    public WebElement AddEventPopup(){
        return driver.findElement(AddEvent);
    }
    public WebElement CreateEventButton(){
        return driver.findElement(CreateEvent);
    }
    public WebElement CancelEventButton(){
        return driver.findElement(CancelEvent);
    }
    public WebElement EventTitleInput(){
        return driver.findElement(EventTtle);
    }
    public WebElement MondayColumn(){
        return driver.findElement(Monday);
    }
    public WebElement TuesdayColumn(){
        return driver.findElement(Tuesday);
    }
    public WebElement WednesdayColumn(){
        return driver.findElement(Wednesday);
    }
    public WebElement ThursdayColumn(){
        return driver.findElement(Tuesday);
    }
    public WebElement FridayColumn(){
        return driver.findElement(Friday);
    }
    public WebElement SaturdayColumn(){
        return driver.findElement(Saturday);
    }
    public WebElement SundayColumn(){
        return driver.findElement(Sunday);
    }

}
