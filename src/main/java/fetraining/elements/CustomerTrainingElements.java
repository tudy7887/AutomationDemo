package fetraining.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerTrainingElements extends BaseElements{

    private By trainingElement, trainingList, mondayList, tuesdayList, wednesdayList,
            thursdayList, fridayList, saturdayList, sundayList, generateAllButton;
    public CustomerTrainingElements(WebDriver driver) {
        super(driver);
        SetLink("http://apptest.go.ro:9999/trainings");
        InitializeElements();
    }

    public WebElement GetTrainingElement(WebElement list, int index) { return list.findElements(trainingElement).get(index); }
    public WebElement GetTrainingList() { return driver.findElement(trainingList); }
    public WebElement GetMondayList() { return driver.findElement(mondayList); }
    public WebElement GetTuesdayList() { return driver.findElement(tuesdayList); }
    public WebElement GetWednesdayList() { return driver.findElement(wednesdayList); }
    public WebElement GetThursdayList() { return driver.findElement(thursdayList); }
    public WebElement GetFridayList() { return driver.findElement(fridayList); }
    public WebElement GetSaturdayList() { return driver.findElement(saturdayList); }
    public WebElement GetSundayList() { return driver.findElement(sundayList); }
    public WebElement GetGenerateAllButton() { return driver.findElement(generateAllButton); }

    private void InitializeElements(){
        trainingElement = GetElementByCSSSlecetor(configLoader.GetProperties("trainingElement"));
        trainingList = GetElementByCSSSlecetor(configLoader.GetProperties("trainingList"));
        mondayList = GetElementByCSSSlecetor(configLoader.GetProperties("mondayList"));
        tuesdayList = GetElementByCSSSlecetor(configLoader.GetProperties("tuesdayList"));
        wednesdayList = GetElementByCSSSlecetor(configLoader.GetProperties("wednesdayList"));
        thursdayList = GetElementByCSSSlecetor(configLoader.GetProperties("thursdayList"));
        fridayList = GetElementByCSSSlecetor(configLoader.GetProperties("fridayList"));
        saturdayList = GetElementByCSSSlecetor(configLoader.GetProperties("saturdayList"));
        sundayList = GetElementByCSSSlecetor(configLoader.GetProperties("sundayList"));
        generateAllButton = GetElementByCSSSlecetor(configLoader.GetProperties("generateAllButton"));

    }
}
