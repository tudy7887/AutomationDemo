package fetraining.actions;

import fetraining.elements.CustomerTrainingElements;
import fetraining.elements.LoginElements;
import fetraining.interfaces.ICustomerTrainingPageActions;
import fetraining.interfaces.ILoginPageActions;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerTrainingPageActions extends BaseActions implements ICustomerTrainingPageActions {
    private CustomerTrainingElements elements;

    public CustomerTrainingPageActions(WebDriver driver){
        super(driver);
        elements = new CustomerTrainingElements(driver);
        SetBaseElements(elements);
    }

    public void MoveTrainingListToMonday(int indexElement){
        var source = elements.GetTrainingElement(elements.GetTrainingList(), indexElement);
        var target = elements.GetMondayList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveTrainingListToTuesday(int indexElement){
        var source = elements.GetTrainingElement(elements.GetTrainingList(), indexElement);
        var target = elements.GetTuesdayList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveTrainingListToWednesday(int indexElement){
        var source = elements.GetTrainingElement(elements.GetTrainingList(), indexElement);
        var target = elements.GetWednesdayList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveTrainingListToThursday(int indexElement){
        var source = elements.GetTrainingElement(elements.GetTrainingList(), indexElement);
        var target = elements.GetThursdayList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveTrainingListToFriday(int indexElement){
        var source = elements.GetTrainingElement(elements.GetTrainingList(), indexElement);
        var target = elements.GetFridayList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveTrainingListToSaturday(int indexElement){
        var source = elements.GetTrainingElement(elements.GetTrainingList(), indexElement);
        var target = elements.GetSaturdayList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveTrainingListToSunday(int indexElement){
        var source = elements.GetTrainingElement(elements.GetTrainingList(), indexElement);
        var target = elements.GetSundayList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveMondayToTrainingList(int indexElement){
        var source = elements.GetTrainingElement(elements.GetMondayList(), indexElement);
        var target = elements.GetTrainingList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveTuesdayToTrainingList(int indexElement){
        var source = elements.GetTrainingElement(elements.GetTuesdayList(), indexElement);
        var target = elements.GetTrainingList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveWednesdayToTrainingList(int indexElement){
        var source = elements.GetTrainingElement(elements.GetWednesdayList(), indexElement);
        var target = elements.GetTrainingList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveThursdayToTrainingList(int indexElement){
        var source = elements.GetTrainingElement(elements.GetThursdayList(), indexElement);
        var target = elements.GetTrainingList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveFridayToTrainingList(int indexElement){
        var source = elements.GetTrainingElement(elements.GetFridayList(), indexElement);
        var target = elements.GetTrainingList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveSaturdayToTrainingList(int indexElement){
        var source = elements.GetTrainingElement(elements.GetSaturdayList(), indexElement);
        var target = elements.GetTrainingList();
        DragAndDropSourceToTarget(source, target);
    }
    public void MoveSundayToTrainingList(int indexElement){
        var source = elements.GetTrainingElement(elements.GetSundayList(), indexElement);
        var target = elements.GetTrainingList();
        DragAndDropSourceToTarget(source, target);
    }
    public String GetTrainingListElementText(int indexElement){
        return elements.GetTrainingElement(elements.GetTrainingList(), indexElement).getText();
    }
    public String GetMondayElementText(int indexElement){
        return elements.GetTrainingElement(elements.GetMondayList(), indexElement).getText();
    }
    public String GetTuesdayElementText(int indexElement){
        return elements.GetTrainingElement(elements.GetTuesdayList(), indexElement).getText();
    }
    public String GetWednesdayElementText(int indexElement){
        return elements.GetTrainingElement(elements.GetWednesdayList(), indexElement).getText();
    }
    public String GetThursdayElementText(int indexElement){
        return elements.GetTrainingElement(elements.GetThursdayList(), indexElement).getText();
    }
    public String GetFridayElementText(int indexElement){
        return elements.GetTrainingElement(elements.GetFridayList(), indexElement).getText();
    }
    public String GetSaturdayElementText(int indexElement){
        return elements.GetTrainingElement(elements.GetSaturdayList(), indexElement).getText();
    }
    public String GetSundayElementText(int indexElement){
        return elements.GetTrainingElement(elements.GetSundayList(), indexElement).getText();
    }
    public void ClickGenerateAllButton(){
        elements.GetGenerateAllButton().click();
    }

    private void DragAndDropSourceToTarget(WebElement source, WebElement target){
        var builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(source)
                .moveToElement(target)
                .release(target)
                .pause(Duration.ofSeconds(1))
                .build();
        dragAndDrop.perform();
        //elements.WaitUntilElementIsDisplayed(target);
    }
}
