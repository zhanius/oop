package labwork3.problem5;

public class Chocolate implements Comparable<Chocolate> {
    double weight;
    String name;
    Chocolate(){}
    Chocolate(String name, double weight){
        this.weight=weight;
        this.name=name;
    }
    public String toString(){
        return "Chocolate " + this.name + " with weight: " + this.weight;
    }
    @Override
    public int compareTo(Chocolate c){
        if(this.weight>c.weight) return 1;
        if(this.weight<c.weight) return -1;
        return 0;
    }
}
