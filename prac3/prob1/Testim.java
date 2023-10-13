package prac3.prob1;

public class Testim {
    public static void main (String[]args){
        Lion l = new Lion("Simba", 6, Types.Mammal, "bones");
        System.out.println(l);
        l.eat();
        l.voice();
    }
}
