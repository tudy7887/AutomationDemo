package parabank.interfaces;

public interface ITransactionDetailsPageActions extends IBaseActions {
    void ChooseTransaction(String id);
    String GetTransactionId();
    String GetTransactionDate();
    String GetTransactionType();
    String GetTransactionAmount();
}
