package prac3.prob2;
public abstract class Person {
    protected String name;
    protected String address;
    public Person(){
    }
    public Person(String name, String address){
        this();
        this.address = address;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String toString(){
        return "name = " + name + ", address = " + address + ", ";
    }
}
