package labwork3.problem1;

public class Kitana extends CharacterMK{
    Kitana(){
        super();
        setAge(10000);
        setName("Kitana");
    }
    @Override
    void abstractMethodFatality() {
        System.out.println(getName() + " cuts the enemy with her Fan.\nKitana WIN!");
    }
    @Override
    void abstractMethodAttack() {
        System.out.println("Damages with a Fan.");
    }

}
