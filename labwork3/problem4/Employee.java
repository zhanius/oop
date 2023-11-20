package labwork3.problem4;

import java.time.LocalDate;

public class Employee extends Person implements Comparable, Cloneable{
    private double salary;
    private LocalDate hireDate;
    private String insuranceNumber;
    public Employee(){
        super();
    }
    public Employee(String name, String insuranceNumber, LocalDate hireDate, double salary){
        super(name);
        this.insuranceNumber = insuranceNumber;
        this.hireDate = hireDate;
        this.salary = salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setHireDate(LocalDate hireDate){
        this.hireDate=hireDate;
    }
    public void setInsuranceNumber(String insuranceNumber){
        this.insuranceNumber = insuranceNumber;
    }
    public double getSalary(){
        return this.salary;
    }
    public LocalDate getHireDate(){
        return this.hireDate;
    }
    public String getInsuranceNumber(){
        return this.insuranceNumber;
    }
    @Override
    public boolean equals(Object o){
        if(!super.equals(o)) return false;
        Employee e = (Employee)o;
        return this.getSalary() == e.getSalary() &&  this.getHireDate().equals(e.getHireDate()) && this.getInsuranceNumber().equals(e.getInsuranceNumber());
    }

    @Override
    public String toString(){
        return super.toString() + ":\n" + "salary: " + getSalary() + ", started work on: " + getHireDate() + ", national insurance number: " + getInsuranceNumber();
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        Employee e = (Employee) super.clone();
        e.hireDate = this.hireDate;
        return e;
    }
    @Override
    public int compareTo(Object o) {
        Employee e = (Employee) o;
        return (int)(this.getSalary() - e.getSalary());
//        if(e.getSalary()<this.salary) return 1;
//        if(e.getSalary()>this.salary) return -1;
//        return 0;
    }
}
