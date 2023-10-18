package labwork2.task3;

public class Bishop extends Piece{
    public Bishop(){
        super();
    }
    public Bishop(int x, int y){
        super(x,y);
    }

    public boolean isLegalMove(Position x, Position y){
        int dx = Math.abs(x.getX() - y.getX());
        int dy = Math.abs(x.getY() - y.getY());
        return dx==dy && !x.equals(y);
    }
}
