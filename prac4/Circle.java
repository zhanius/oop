package prac4;
public class Circle extends Shape{
    public Circle(){
        super();
    }
    public Circle(Color color,int pos){
        super(color, pos);
    }
    void draw(){
        System.out.println(" ".repeat(pos));
        if(color == color.RED){
            System.out.println("🔴");
        }
        if(color == color.BLACK){
            System.out.println("⚫");
        }
    }
}
