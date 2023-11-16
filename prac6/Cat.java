package prac6;

public class Cat extends Animal implements CanHavePizza{
    Cat(){
        super();
    }
    Cat(String name){
        super(name);
    }
    @Override
    public String voice(){
        return "meoww";
    }
    @Override
    public void eatPizza() {
        System.out.println("Mur-mur meow!!");
    }
    public String toString(){
        return super.toString() + ' ' + voice();
    }
}
