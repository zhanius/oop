package labwork2.task3;

public class Queen extends Piece {
    public Queen(){
        super();
    }
    public Queen(int x, int y){
        super(x, y);
    }
    @Override
    public boolean isLegalMove(Position x, Position y){
        return Bishop.isLegalMove(x, y) || Rook.isLegalMove(x, y);
    }
}
