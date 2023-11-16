package prac6;

public abstract class Person implements CanHavePizza, CanHaveParty{
    String name;
    double money = 30.0;
    Person(){}
    Person(String name){
        this.name = name;
    }
    void pay(){
        if(money >= 5.0) {
            System.out.println("Card: The purchase was successful.");
            money-=5.0;
        }
        else{
            System.out.println("Card: Card was declined");
        }
    }
    void work(){
        money+=30.0;
    }
    @Override
    public void eatPizza(){
        System.out.println("It was very tasty Pizza :p");
    }

    public String toString(){
        return name;
    }

}
























