package parabank.interfaces;

import java.util.List;

public interface IFindTransactionsPageActions extends IUserBaseActions {
    void SetFromAccountCombobox(String account);
    void EnterSearchTransactionId(String text);
    void EnterSearchTransactionDate(String text);
    void EnterSearchTransactionFromDate(String text);
    void EnterSearchTransactionToDate(String text);
    void EnterSearchTransactionAmount(String text);
    String GetFindByIdErrorErrorMessage();
    String GetFindByDateErrorErrorMessage();
    String GetFindByDateRangeErrorErrorMessage();
    String GetFindByAmountErrorErrorMessage();
    void ClickFindByIdButton();
    void ClickFindByDateButton();
    void ClickFindByDateRangeButton();
    void ClickFindByAmountButton();
    void ClearSearchTransactionId();
    void ClearSearchTransactionDate();
    void ClearSearchTransactionFromDate();
    void ClearSearchTransactionToDate();
    void ClearSearchTransactionAmount();
    void ClickResultTransactionList(int index);
    List<String> GetResultDateList();
    List<String> GetResultTransactionList();
    List<String> GetResultDebitList();
    List<String> GetResultCreditList();
}
