package labwork2.task3;

public class King extends Piece {
    public King(){
    }
    public King(int x, int y){
        super(x, y);
    }
    @Override
    public boolean isLegalMove(Position x, Position y){
        return (Math.abs(x.getX() - y.getX())) <= 1 && (Math.abs(y.getY() - x.getY())) <= 1;
    }
}
