package fetraining.interfaces;

public interface ICustomerTrainingPageActions extends IBaseActions{
    void MoveTrainingListToMonday(int indexElement);
    void MoveTrainingListToTuesday(int indexElement);
    void MoveTrainingListToWednesday(int indexElement);
    void MoveTrainingListToThursday(int indexElement);
    void MoveTrainingListToFriday(int indexElement);
    void MoveTrainingListToSaturday(int indexElement);
    void MoveTrainingListToSunday(int indexElement);
    void MoveMondayToTrainingList(int indexElement);
    void MoveTuesdayToTrainingList(int indexElement);
    void MoveWednesdayToTrainingList(int indexElement);
    void MoveThursdayToTrainingList(int indexElement);
    void MoveFridayToTrainingList(int indexElement);
    void MoveSaturdayToTrainingList(int indexElement);
    void MoveSundayToTrainingList(int indexElement);
    String GetTrainingListElementText(int indexElement);
    String GetMondayElementText(int indexElement);
    String GetTuesdayElementText(int indexElement);
    String GetWednesdayElementText(int indexElement);
    String GetThursdayElementText(int indexElement);
    String GetFridayElementText(int indexElement);
    String GetSaturdayElementText(int indexElement);
    String GetSundayElementText(int indexElement);
    void ClickGenerateAllButton();
}
