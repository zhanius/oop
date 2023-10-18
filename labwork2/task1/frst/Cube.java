package labwork2.task1.frst;

import java.util.Map;

public class Cube extends Shape {
    int a;
    public Cube(){
        super();
    }
    public Cube(int a){
        this.a=a;
    }
    @Override
    double volume(){
        return Math.pow(a,3);
    }
    @Override
    double surfaceArea(){
        return 6* Math.pow(a,2);
    }
    public String toString(){
        return super.toString();
    }
}

