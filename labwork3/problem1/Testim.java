package labwork3.problem1;

public class Testim {
    private static void fighter1Turn(CharacterMK fighter1, CharacterMK fighter2) {
        System.out.println(fighter1.getName() + "'s turn:");
        fighter1.abstractMethodAttack();
        fighter2.energy -= 20;
        fighter2.block();
        System.out.println(fighter1.getName() + ' ' + fighter1.energy);
        System.out.println(fighter2.getName() + ' ' + fighter2.energy);
        System.out.println();
    }
    private static void fighter2Turn(CharacterMK fighter2, CharacterMK fighter1) {
        System.out.println(fighter2.getName() + "'s turn:");
        fighter2.abstractMethodAttack();
        fighter1.energy -= 20;
        fighter1.block();
        System.out.println(fighter1.getName() + ' ' + fighter1.energy);
        System.out.println(fighter2.getName() + ' ' + fighter2.energy);
        System.out.println();
    }

    public static void main(String[]args){
        Sonya fighter1 = new Sonya();
        Kitana fighter2 = new Kitana();

        while(!fighter1.isDefeated() && !fighter2.isDefeated()){
            fighter1Turn(fighter1,fighter2);

            if(fighter1.isDefeated()){
                fighter2.abstractMethodFatality();
                break;
            }
            if(fighter2.isDefeated()){
                fighter1.abstractMethodFatality();
                break;
            }

            fighter2Turn(fighter2, fighter1);
            if(fighter2.isDefeated()){
                fighter1.abstractMethodFatality();
                break;
            }
            if(fighter1.isDefeated()){
                fighter2.abstractMethodFatality();
                break;
            }
        }
    }
}
