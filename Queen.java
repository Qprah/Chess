public class Queen extends ChessPiece {

    public Queen(String newColor, Board theBoard) {
        super("Queen", newColor, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");
    }

    public Queen(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");

    }
}
