package labwork3.problem1;

public class Sonya extends CharacterMK{
    Sonya(){
        super();
        setName("Sonya");
        setAge(41);
    }
    @Override
    void abstractMethodFatality() {
        System.out.println(getName() + " blows a kiss :з\nSonya WIN!" );
    }
    @Override
    void abstractMethodAttack() {
        System.out.println("Tae Kwon Do!");
    }
}
