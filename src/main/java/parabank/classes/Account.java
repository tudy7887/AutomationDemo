package parabank.classes;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String Number;
    private String Type;
    private String Balance;
    private String Available;
    private List<Transaction> Transactions = new ArrayList<Transaction>();


    public String GetNumber() {
        return Number;
    }

    public void SetNumber(String number) {
        Number = number;
    }

    public String GetType() {
        return Type;
    }

    public void SetType(String type) {
        Type = type;
    }

    public String GetBalance() {
        return Balance;
    }

    public void SetBalance(String balance) {
        Balance = balance;
    }

    public String GetAvailable() {
        return Available;
    }

    public void SetAvailable(String available) {
        Available = available;
    }

    public List<Transaction> GetTransactions() {
        return Transactions;
    }

    public void AddTransaction(Transaction transaction) {
        Transactions.add(transaction);
    }
}
