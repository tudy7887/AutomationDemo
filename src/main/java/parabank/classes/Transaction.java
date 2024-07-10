package parabank.classes;

public class Transaction {
    private String Id;
    private String Date;
    private String Description;
    private String Type;
    private String Amount;


    public String GetDescription() {
        return Description;
    }

    public void SetDescription(String description) {
        Description = description;
    }

    public String GetId() {
        return Id;
    }

    public void SetId(String id) {
        Id = id;
    }

    public String GetDate() {
        return Date;
    }

    public void SetDate(String date) {
        Date = date;
    }

    public String GetType() {
        return Type;
    }

    public void SetType(String type) {
        Type = type;
    }

    public String GetAmount() {
        return Amount;
    }

    public void SetAmount(String amount) {
        Amount = amount;
    }
}
