package labwork2.task4;
import java.util.Vector;

public class Bank {
    static Vector <Account> accounts;
    static{
        accounts = new Vector<>();
    }
    public void addAccount(Account acc){
        accounts.add(acc);
    }
    public void closeAccount(int accNumber){

                accounts.remove(a);

    }
    public void update() {
        for (Account a : accounts) {
            if (a instanceof SavingsAccount) {
                ((SavingsAccount)a).addInterest();
            } else if (a instanceof CheckingAccount) {
                ((CheckingAccount)a).deductFee();
            }
        }
    }
}
