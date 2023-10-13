package prac4;
public class Triangle extends Shape{
    public Triangle(){
        super();
    }
    public Triangle(Color color,int pos){
        super(color, pos);
    }
    void draw(){
        System.out.println(" ".repeat(pos));
        if(color == color.RED){
            System.out.println("🔺");
        }
        if(color == color.BLACK){
            System.out.println("▲");
        }
    }
}
