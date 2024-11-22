package models;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount(String accountId, double balance){
        this.accountId= accountId;
        this.balance= balance;
    }

    public  double ckeckBalance(){
        return balance;
    }

    public boolean transferfunds(BankAccount toAccount, double amount) {
        if (amount > 0 && balance >= amount){
            balance -= amount;
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }

    private void deposit(double amount) {
        balance += amount;
    }
}
