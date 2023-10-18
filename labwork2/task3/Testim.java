package labwork2.task3;

public class Testim {
    public static void main(String[]args){
        Knight knight = new Knight(2,2);
        Bishop bishop = new Bishop(4,4);
        Pawn pawn = new Pawn(5, 6);
        Queen queen = new Queen(5, 8);
        Rook rook = new Rook(3,6);
        King king = new King(3,7);

        Position end = new Position(2,2);

        System.out.println(knight.isLegalMove(new Position(2,2),end));
        System.out.println(bishop.isLegalMove(new Position(4,4),end));
        System.out.println(pawn.isLegalMove(new Position(5,6),end));
        System.out.println(queen.isLegalMove(new Position(5,8),end));
        System.out.println(rook.isLegalMove(new Position(3,6),end));
        System.out.println(king.isLegalMove(new Position(3,7),end));
    }
}
