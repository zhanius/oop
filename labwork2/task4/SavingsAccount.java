package labwork2.task4;

public class SavingsAccount extends Account {
    double interestRate;
    public SavingsAccount(){
        super();
    }
    public SavingsAccount(int accNumber, double interestRate){
        super(accNumber);
        this.interestRate=interestRate;
    }
    public void addInterest(){
        double balance = super.getBalance();
        double interest = balance * (interestRate / 100.0); // вычисляем проценты
        super.deposit(interest);
    }
    @Override
    public String toString(){
        return "Save Account Balance %s.\nIts Account Number: %s.\n".formatted(getBalance(),getAccNumber());
    }
}
