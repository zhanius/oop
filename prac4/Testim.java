package prac4;
import java.util.Vector;

public class Testim {
    public static void main(String[]args){
        Vector<Shape>shapes = new Vector<>();
        shapes.add(new Circle(Color.RED,2));
        shapes.add(new Triangle(Color.BLACK, 2));
        shapes.add(new Rectangle(Color.RED, 2));

        for(Shape s : shapes){
            s.draw();
        }
    }
}
