public class King extends ChessPiece {

    public King(String newColor, Board theBoard) {
        super("King", newColor, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");
    }

    public King(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");

    }
}

