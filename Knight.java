public class Knight extends ChessPiece {

    public Knight(String newColor, Board theBoard) {
        super("Knight", newColor, theBoard);
        super.setGraphics("KnightBlack.png", "KnightWhite.png");
    }

    public Knight(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("KnightBlack.png", "KnightWhite.png");

    }
}
