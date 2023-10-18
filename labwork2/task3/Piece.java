package labwork2.task3;
public abstract class Piece {
    int x,y;
    public Piece(){
    }
    public Piece(int x, int y){
        this.x=x;
        this.y=y;
    }
    public abstract boolean isLegalMove(Position a, Position b);
}
