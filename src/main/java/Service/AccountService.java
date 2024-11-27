package Service;

import models.BankAccount;

public interface AccountService {
    public boolean checkBalance();
    public boolean transferFunds(BankAccount toAccount, double amount);
}
