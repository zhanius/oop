package prac3.prob2;

public class Staff extends Person {
    public String school;
    public double pay;

    public Staff(){
        super();
    }
    public Staff(String name, String address, String school, double pay){
        super(name, address);
        this.pay = pay;
        this.school = school;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public String getSchool(){
        return school;
    }
    public void setPay(double pay){
        this.pay = pay;
    }
    public double getPay(){
        return pay;
    }
    @Override
    public String toString(){
        return super.toString() + ", school is " + getSchool() + ", pay = " + getPay();
    }
}
