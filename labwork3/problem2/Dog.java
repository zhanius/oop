package labwork3.problem2;

public class Dog implements Moveable{
    String name;
    String color;
    Dog(){}
    Dog(String name, String color){
        this.name=name;
        this.color=color;
    }
    @Override
    public void move() {
        System.out.println("Dog is Moving");
    }
}
