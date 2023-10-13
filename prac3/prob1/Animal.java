package prac3.prob1;

public abstract class Animal {
    protected String name;
    protected Types type;
    protected int age;

     public Animal(){
     }
    public Animal(String name) {
        this.name = name;
    }
    public Animal(String name, int age, Types type){
        this(name);
        this.age = age;
        this.type = type;
    }

    public abstract void eat();
    public abstract void voice();

    public String toString(){
        return "Hello! My name is " +  this.name + ", and my type is " + this.type;
    }
}
