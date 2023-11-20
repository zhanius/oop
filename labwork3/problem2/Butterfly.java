package labwork3.problem2;

public class Butterfly implements Flyable {
    String name;
    String color;
    Butterfly(){}
    Butterfly(String name, String color){
        this.name=name;
        this.color=color;
    }
    @Override
    public void fly() {
        System.out.println("Butterfly is Flying");
    }
    @Override
    public void move() {
        System.out.println("Butterfly is Moving");
    }
}
