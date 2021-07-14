public class Bishop extends ChessPiece {

    public Bishop(String newColor, Board theBoard) {
        super("King", newColor, theBoard);
        super.setGraphics("BishopBlack.png", "BishopWhite.png");
    }

    public Bishop(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("BishopBlack.png", "BishopWhite.png");
    }

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {

        //bishop works partially
        if (getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(futureRow, futureCol))) {
            return false;
        }

        /**
         * The do-while loops are responsible for the diagonal movement of the bishop.
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

        return false;
    }

}


