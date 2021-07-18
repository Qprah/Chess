public class King extends ChessPiece {

    public King(String newColor, Board theBoard) {
        super("King", newColor, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");
    }

    public King(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");
    }
    //Phase 1 - complete

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {

        // this loop offsets the currentPosition of the king to bottom-left, for the loop to run around the king
        // (8 tiles around the king are valid with king in Center)

        for (int i = currentRow - 1; i < currentRow + 2; i++) { //offsets the starting row and runs the loop 3 times
            for (int j = currentCol - 1; j < currentCol + 2; j++) {// offsets the starting col and runs the loop 3 times

                //general statement would work here because the king is just going one step in every Direction, therefore, no need to break out of the loop
                if (getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(futureRow, futureCol))) {
                    return false;
                }
                //otherwise just return the valid tiles.
                if (futureRow == i && futureCol == j) {
                    return true;
                }
            }
        }
        return false;
    }
}





