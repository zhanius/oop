package labwork1.dragon;

public class Person {
    private Gender gender;
    private String name;
    public Person() { }
    public Person(Gender gender){
        this.gender = gender;
    }
    public Person(Gender gender, String name){
        this(gender); this.name = name;
    }
    public void setGender(){
        this.gender = gender;
    }
    public void setName(){
        this.name = name;
    }
    public Gender getGender(){
        return this.gender;
    }
    public String getName(String name){
        return this.name;
    }
    public String toString(){
        return "Name: " + this.name + ", " + "Gender: " + this.gender + "\n";
    }
}
