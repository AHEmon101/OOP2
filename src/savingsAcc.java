public class savingsAcc extends UserAccount{
    public savingsAcc(String username, String password){
        super(username, password);
    }

    @Override
    public void withdraw(double amount){
        if (amount <= balance && amount <= 50000) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}
