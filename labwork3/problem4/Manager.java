package labwork3.problem4;

import java.time.LocalDate;
import java.util.Vector;

public class Manager extends Employee {
    private double bonus;
    private Vector <Employee> team = new Vector<Employee>();
    public Manager(){super();}
    public Manager(String name, String insuranceNumber, LocalDate hireDate, double salary){
        super(name, insuranceNumber,hireDate, salary);
    }
    public Manager(String name, String insuranceNumber, LocalDate hireDate, double salary,double bonus){
        super(name, insuranceNumber,hireDate, salary);
        this.bonus=bonus;
    }
    public void setBonus(){
        this.bonus=bonus;
    }
    public double getBonus(){
        return this.bonus;
    }
    public void addTeammate(Employee e){
        team.add(e);
    }
    public void addBonus(double bon){
        this.bonus+=bon;
    }
    @Override
    public int compareTo(Object o){
        Manager m = (Manager) o;
        int res = super.compareTo(m);
        if(res == 0){
            if(m.getBonus() > this.getBonus()) return 1;
            if(m.getBonus() < this.getBonus()) return -1;
        }
        return res;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        Manager m = (Manager) super.clone();
        return m;
    }
    @Override
    public boolean equals(Object o){
        if(!super.equals(o)) return false;
        Manager m = (Manager)o;
        return this.getBonus() == m.getBonus();
    }
    @Override
    public String toString(){
        return super.toString() + ", bonus: " + getBonus();
    }
}
