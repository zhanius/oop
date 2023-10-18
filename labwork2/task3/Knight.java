package labwork2.task3;

public class Knight extends Piece {
    public Knight(){
        super();
    }
    public Knight(int x,int y){
        super(x,y);
    }
    @Override
    public boolean isLegalMove(Position x, Position y) {
        int dx = Math.abs(x.getX() - y.getX());
        int dy = Math.abs(x.getY() - y.getY());
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}
