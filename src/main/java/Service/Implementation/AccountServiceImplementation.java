package Service.Implementation;

import Service.AccountService;
import models.BankAccount;

public class AccountServiceImplementation  implements AccountService {
    public class AccountService {
        public boolean transferFunds(BankAccount toAccount, double amount) {
            if (amount > 0 && balance >= amount){
                balance -= amount;
                toAccount.deposit(amount);
                return true;
            }
            return false;
        }

        public  double ckeckBalance(){

            return balance;
        }
    }

}
