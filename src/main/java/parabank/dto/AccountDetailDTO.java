package parabank.dto;

import parabank.classes.Transaction;

import java.util.List;

public class AccountDetailDTO {
    public String Number;
    public String Type;
    public String Balance;
    public String Available;
    public List<TransactionOverwiewDTO> Transactions;
}
