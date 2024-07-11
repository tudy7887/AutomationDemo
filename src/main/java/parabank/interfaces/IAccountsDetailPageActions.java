package parabank.interfaces;

import java.util.List;

public interface IAccountsDetailPageActions extends IUserBaseActions {
    void ChooseAccount(String number);
    String GetNumber();
    String GetType();
    String GetBalance();
    String GetAvailable();
    void ClickTransactionTransactionList(int index);
    List<String> GetTransactionDatesList();
    List<String> GetTransactionTransactionList();
    List<String> GetTransactionDebitList();
    List<String> GetTransactionCreditList();
}
