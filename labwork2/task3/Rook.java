package labwork2.task3;

public class Rook extends Piece {
    public Rook(){
        super();
    }
    public Rook(int x, int y){
        super(x, y);
    }
    @Override
    public static boolean isLegalMove(Position x, Position y){
        int dx = Math.abs(x.getX() - y.getX());
        int dy = Math.abs(x.getY() - y.getY());
        return dx == 0 || dy == 0;
    }
}
