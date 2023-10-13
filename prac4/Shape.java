package prac4;

abstract class Shape {
    protected Color color;
    protected int pos;
    public Shape(){
    }
    public Shape(Color color, int pos){
        this.color = color;
        this.pos = pos;
    }
    abstract void draw();
}
