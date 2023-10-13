package prac3.prob2;

public class Student extends Person {
    public String program;
    public int year;
    public double fee;
    public Student(){
        super();
    }
    public Student(String name, String address, String program, int year, double fee){
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }
    public void setProgram(String program){
        this.program = program;
    }
    public String getProgram(){
        return program;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return year;
    }
    public void setFee(double fee){
        this.fee = fee;
    }
    public double getFee(){
        return fee;
    }
    public String toString(){
        return super.toString() + ", fee is " + getFee() + ", program is " + getProgram() + ", year is " + getYear();
    }
}
