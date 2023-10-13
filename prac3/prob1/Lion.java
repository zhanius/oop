package prac3.prob1;

public class Lion extends Animal {
    public String favToy;
    public Lion(){}
    public Lion(String name, int age, Types type, String favToy){
        super(name, age, type);
        this.favToy = favToy;
    }
    @Override
    public void eat(){
        System.out.println("Om-nom-nom!! Meeeaaat!!");
    }
    @Override
    public void voice(){
        System.out.println("ARRR!!!!!!");
    }
    public void eat(String food){
        System.out.println("Eating" + food);
    }
    public String toString(){
        return super.toString() + ". I love play with " + favToy + "!!! ";
    }
}
