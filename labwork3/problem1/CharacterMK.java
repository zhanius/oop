package labwork3.problem1;

public abstract class CharacterMK implements FuncForFightGames{
    String name;
    int age;
    int energy = 100;
    CharacterMK(){}
    CharacterMK(String name, int age){
        this.name=name; this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age=age;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public boolean isDefeated(){
        return energy == 0;
    }

    @Override
    public void attack() {
        System.out.println(getClass().getSimpleName() + " attacks.");
    }
    @Override
    public void rise() {
        System.out.println(getClass().getSimpleName() + " rises.");
    }
    @Override
    public void fall() {
        System.out.println(getClass().getSimpleName() + " falls.");
    }
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " moves.");
    }
    @Override
    public void block() {
        System.out.println(getClass().getSimpleName() + " blocks.");
    }

    abstract void abstractMethodFatality();
    abstract void abstractMethodAttack();
}
