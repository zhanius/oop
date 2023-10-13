package labwork1.prob2;
/* Write any class at you choice and show appropriate usage of:
enums, "static" and "final" modifiers, "this" keyword (2 usages),
read-only fields, methods overloading, initialization block.*/
public class PersonalityType {
    static int cnt = 0;
    private String name;
    private final Types type;

    public PersonalityType(String name, Types type){
        this.name = name;
        this.type = type;
        cnt++;
    }
    public PersonalityType(String name){
        this(name,Types.ambivert);
    }

    public static int getCnt(){
        return cnt;
    }
    public String getName(){
        return this.name;
    }
    public Types getType(){
        return this.type;
    }

    public String toString(){
        return this.name + " is an " + this.type;
    }
    public static void main(String[]args){
        PersonalityType p = new PersonalityType("Zhans");
        PersonalityType p1 = new PersonalityType("Kamazhay");
        PersonalityType p2 = new PersonalityType("Gabdyq", Types.ambivert);
        System.out.println(p);
        System.out.println(p1);
        System.out.println(p2);
        //System.out.println(PersonalityType.getCnt());
    }
}
