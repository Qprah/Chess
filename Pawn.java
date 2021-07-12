public class Pawn extends ChessPiece {

    public Pawn(String newColor, Board theBoard) {
        super("Pawn", newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");

    }

    public Pawn(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");

    }
}
