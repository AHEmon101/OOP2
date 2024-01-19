
public abstract class UserAccount{
    private String username;
    private String password;
    public double balance;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
        displayBalance();
    }

    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}