package labwork2.task4;

public class CheckingAccount extends Account{
    private int countOfTransactions = 0;
    static final double transactionFee = 0.02;
    static final int countOfFreeTransactions = 5;
    public CheckingAccount(){
        super();
    }
    public CheckingAccount(int accNumber){
        super(accNumber);
        countOfTransactions = 0;
    }
    @Override
    public void withdraw(double sum){
        super.withdraw(sum);
        deductFee();
    }
    @Override
    public void deposit(double sum){
        super.deposit(sum);
        deductFee();
    }
    public void deductFee(){
        countOfTransactions++;
        if (countOfTransactions > countOfFreeTransactions){
            super.withdraw(transactionFee);
        }
    }
    @Override
    public String toString(){
        return "Check Account Balance: %s.\nGet Account number: %s.\n".formatted(getBalance(),getAccNumber());
    }
}
