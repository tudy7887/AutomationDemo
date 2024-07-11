package parabank.interfaces;

public interface ITransactionDetailsPageActions extends IUserBaseActions {
    void ChooseTransaction(String id);
    String GetTransactionId();
    String GetTransactionDate();
    String GetTransactionType();
    String GetTransactionAmount();
}
