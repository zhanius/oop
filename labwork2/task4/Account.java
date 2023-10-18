package labwork2.task4;

public class Account {
    private double balance;
    private int accNumber;
    public Account(){
    }
    public Account(int accNumber){
        this.accNumber = accNumber;
        balance=0.0;
    }
    public void deposit(double sum){
        this.balance += sum;
    }
    public void withdraw(double sum){
        this.balance -= sum;
    }
    public double getBalance(){
        return this.balance;
    }
    public int getAccNumber(){
        return this.accNumber;
    }
    public void transfer(double amount, Account other){
        withdraw(amount);
        other.deposit(amount);
    }
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        return this.accNumber == ((Account) o).accNumber && this.equals(o);
    }
    public String toString(){
        return "This Back Account has number %s. \nIts balance: %s.\n".formatted(getAccNumber(),getBalance());
    }
    public final void print(){
        System.out.println(toString());
    }
}
