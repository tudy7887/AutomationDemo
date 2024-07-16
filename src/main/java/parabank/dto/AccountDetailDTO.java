package parabank.dto;

import java.util.List;

public class AccountDetailDTO {
    public String Number;
    public String Type;
    public String Balance;
    public String Available;
    public List<TransactionOverwiewDTO> Transactions;
}
