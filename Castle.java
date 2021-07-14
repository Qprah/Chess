public class Castle extends ChessPiece {

    public Castle(String newColor, Board theBoard) {
        super("Castle", newColor, theBoard);
        super.setGraphics("CastleBlack.png", "CastleWhite.png");
    }

    public Castle(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("CastleBlack.png", "CastleWhite.png");
    }

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        int num = 10;

        // partially works but detects the white and black
        if (getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(futureRow, futureCol))) {
            return false;
        }

        //increasing rows
        for (int i = 0; i < num; i++) {

            //Rows movement for both pieces
            if ((currentRow + i == futureRow || currentRow - i == futureRow) && currentCol == futureCol)
                return true;

            // Column movement for both pieces
            if ((currentCol - i == futureCol || currentCol + i == futureCol) && currentRow == futureRow)
                return true;
        }
        return false;
    }
}
