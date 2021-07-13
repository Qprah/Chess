public class Pawn extends ChessPiece {

    public Pawn(String newColor, Board theBoard) {
        super("Pawn", newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");
        // Un-versioned files are also in the commit i.e png files

    }

    public Pawn(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");

    }
}
