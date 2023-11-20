package labwork3.problem2;

public class Penguin implements Flyable {
    String name;
    Penguin(){}
    Penguin(String name, String color){
        this.name=name;
    }
    @Override
    public void fly() {
        System.out.println("Penguin is Flying");
    }
    @Override
    public void move() {
        System.out.println("Penguin is Moving");
    }
}
