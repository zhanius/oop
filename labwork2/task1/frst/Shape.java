package labwork2.task1.frst;

abstract class Shape {
    final double Pi = 3.14;
    public Shape(){
    }
    abstract double volume();
    abstract double surfaceArea();
    public String toString(){
        return "The Volume of Cylinder is " + volume() + "\nArea Surface is " + surfaceArea();
    }
}
