package prac6;

public abstract class Animal {
    String name;
    Animal(){
    }
    Animal(String name){
        this.name = name;
    }
    abstract String voice();
    public String toString(){
        return this.name;
    }
}
