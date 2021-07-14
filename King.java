public class King extends ChessPiece {
    private boolean gg = true;

    public King(String newColor, Board theBoard) {
        super("King", newColor, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");
    }

    public King(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");

    }

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {

        for (int i = currentRow - 1; i < currentRow + 2; i++) { //offsets the starting row and runs the loop 3 times
            for (int j = currentCol - 1; j < currentCol + 2; j++) {// offsets the starting col and runs the loop 3 times

                if (getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(futureRow, futureCol))) {
                    return false;
                }
                if (futureRow == i && futureCol == j) {
                    return true;
                }
            }
        }
        return false;
    }
}





