package labwork2.task1.frst;

public class Sphere extends Shape {
    int r;
    public Sphere(){
        super();
    }
    public Sphere(int r){
        this.r=r;
    }
    @Override
    double volume(){
        return (4*Pi*Math.pow(r,3))/3;
    }
    @Override
    double surfaceArea(){
        return 4*Pi*Math.pow(r,2);
    }
    public String toString(){
        return super.toString();
    }
}
