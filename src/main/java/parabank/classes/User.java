package parabank.classes;

import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String ssn;
    private HashMap<String, Account> Accounts =  new HashMap<String, Account>();

    public String GetUsername() { return username; }
    public void SetUsername(String username) { this.username = username; }
    public String GetPassword() { return password; }
    public void SetPassword(String password) { this.password = password; }
    public String GetFirstName() { return firstName; }
    public void SetFirstName(String firstName) { this.firstName = firstName; }
    public String GetLastName() { return lastName; }
    public void SetLastName(String lastName) { this.lastName = lastName; }
    public String GetAddress() { return address; }
    public void SetAddress(String address) { this.address = address; }
    public String GetCity() { return city; }
    public void SetCity(String city) { this.city = city; }
    public String GetState() { return state; }
    public void SetState(String state) { this.state = state; }
    public String GetZipCode() { return zipCode; }
    public void SetZipCode(String zipCode) { this.zipCode = zipCode; }
    public String GetPhone() { return phone; }
    public void SetPhone(String phone) { this.phone = phone; }
    public String GetSsn() { return ssn; }
    public void SetSsn(String ssn) { this.ssn = ssn; }
    public Account GetAccount(String accountNumber) { return Accounts.get(accountNumber); }
    public void setAccounts(Account account) { Accounts.put(account.GetNumber(),account); }
}
