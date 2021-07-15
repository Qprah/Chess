public class Queen extends ChessPiece {

    public Queen(String newColor, Board theBoard) {
        super("Queen", newColor, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");
    }

    public Queen(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");

    }
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {

        //Queen works partially
        if (getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(futureRow, futureCol))) {
            return false;
        }
    /**
     * The do-while loops are responsible for the diagonal movement of the Queen.
     *
     * */
    // diagonal in top-right direction.
    int i = 0;
        do {
        if (currentRow + i == futureRow && currentCol + i == futureCol) {
            return true;
        }
        i++;
    } while ((i < 10));

    // diagonal in bottom-left direction
    int j = 0;
        do {
        if (currentRow - j == futureRow && currentCol - j == futureCol) {
            return true;
        }
        j++;
    } while ((j < 10));

    // diagonal in top-left direction
    int k = 0;
        do {
        if (currentRow + k == futureRow && currentCol - k == futureCol) {
            return true;
        }
        k++;
    } while ((k < 10));

    // diagonal in bottom-right direction
    int l = 0;
        do {
        if (currentRow - l == futureRow && currentCol + l == futureCol) {
            return true;
        }
        l++;
    } while ((l < 10));
        int num = 10;
        for (int m = 0; m < num; m++) {

            //Rows movement for both pieces
            if ((currentRow + m == futureRow || currentRow - m == futureRow) && currentCol == futureCol)
                return true;

            // Column movement for both pieces
            if ((currentCol - m == futureCol || currentCol + m == futureCol) && currentRow == futureRow)
                return true;
        }
        return false;
}
}
