package prac6;

public class Restaurant {
    String location;
    String name;
    Restaurant(){}
    Restaurant(String location,String name){
        this.location = location;
        this.name = name;
    }
    void servePizza(CanHavePizza eater){
        eater.eatPizza();

        if(eater instanceof Person){
            Person s = (Student)eater;
            s.pay();
            System.out.println("Thanks!");
        }
//        if(eater instanceof Cat){
//            Cat c = (Cat)eater;
//            c.eatPizza();
//        }
    }
    public String toString(){
        return this.location + " " + this.name;
    }
}
