package labwork2.task4;

public class Testim {
    public static void main(String[]args){
        Account acc1 = new Account(21212);
        Bank b = new Bank();
        CheckingAccount acc2 = new CheckingAccount(21213);
        SavingsAccount acc3 = new SavingsAccount(21214,3);

        b.addAccount(acc1);
        b.addAccount(acc2);
        b.addAccount(acc3);
        acc2.deposit(50000);
        acc3.deposit(50000);
        b.update();
        b.update();b.update();b.update();b.update();
        b.update();
        b.closeAccount(21213);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
    }
}
