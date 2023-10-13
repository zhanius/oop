package prac4;
public class Rectangle extends Shape{
    public Rectangle(){
        super();
    }
    public Rectangle(Color color,int pos){
        super(color, pos);
    }
    void draw(){
        System.out.println(" ".repeat(pos));
        if(color == color.RED){
            System.out.println("🟥");
        }
        if(color == color.BLACK){
            System.out.println("⬛️");
        }
    }
}
