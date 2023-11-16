package prac6;

public class Student extends Person implements CanHaveRetake{
    Student(){
        super();
    }
    Student(String name){
        super(name);
    }
    @Override
    public void move() {
        System.out.println("Moving");
    }
    @Override
    public void dance() {
        System.out.println("Dancing");
    }
    @Override
    public void haveRetake() {
        System.out.println("woopsie, got retake 0.0");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
