package parabank.interfaces;

import java.util.List;

public interface IAccountsOverviewPageActions extends IUserBaseActions {
    void ClickAccountList(int index);
    List<String> GetAccountList();
    List<String> GetBalanceList();
    String GetTotal();
    List<String> GetAvailableList();
}