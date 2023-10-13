package labwork1.dragon;
import java.util.Vector;

public class DragonLaunch {
    static Vector <Person> people;
    static {
        people = new Vector<>();
    }
    static void kidnap(Person p){
        people.add(p);
    }
    static boolean willDragonEatOrNot(){
        if(people.get(0).getGender() == Gender.GIRL) {return true;}
        int cnt = 0;
        for(Person pip : people){
            if(cnt == 0 && pip.getGender() == Gender.GIRL){
                return true;
            }
            if(pip.getGender() == Gender.BOY){
                cnt++;
            }
            else{ cnt--; }
        }
        return cnt != 0;
    }
    public static void main(String[]args){
        kidnap(new Person(Gender.BOY));
        kidnap(new Person(Gender.BOY));
        kidnap(new Person(Gender.GIRL));
        kidnap(new Person(Gender.GIRL));
        kidnap(new Person(Gender.BOY));
        kidnap(new Person(Gender.GIRL));
        System.out.println((willDragonEatOrNot()) ? "Well-fed Dragon" : "Hungry dragon");
    }
}
