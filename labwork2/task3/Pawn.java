package labwork2.task3;

public class Pawn extends Piece{
    public Pawn(){
        super();
    }
    public Pawn(int x, int y){
        super(x, y);
    }
    @Override
    public boolean isLegalMove(Position x, Position y) {
        int dx = Math.abs(x.getX() - y.getX());
        int dy = Math.abs(x.getY() - y.getY());
        if(dx == 0 && dy == 1) return true;
        return false;
    }
}
