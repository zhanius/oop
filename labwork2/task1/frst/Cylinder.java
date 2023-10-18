package labwork2.task1.frst;

public class Cylinder extends Shape{
    int r,h;
    public Cylinder(){
        super();
    }
    public Cylinder(int r,int h){
        this.r=r;
        this.h=h;
    }
    @Override
    double volume() {
        return (Pi*Math.pow(r,2)*h);
    }
    @Override
    double surfaceArea() {
        return 2*Pi*r*(r+h);
    }
    public String toString(){
        return super.toString();
    }
}
