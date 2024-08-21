public class Customer {
    int accountId;
    long accountNumber;
    String Name;
    long balance;
    String passWord;

    public Customer(int accountId, long accountNumber, String name, long balance, String passWord) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        Name = name;
        this.balance = balance;
        this.passWord = passWord;
    }
}
