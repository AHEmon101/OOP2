public class CurrentAcc extends UserAccount{
    public CurrentAcc(String username, String password){
        super(username, password);
    }

    @Override
    public void withdraw(double amount)
    {
        if (amount <= balance) {
        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
    } else {
        System.out.println("Insufficient funds");
    }

}
}
