
public class Castle extends ChessPiece {

    public Castle(String newColor, Board theBoard) {
        super("Castle", newColor, theBoard);
        super.setGraphics("CastleBlack.png", "CastleWhite.png");
    }

    public Castle(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("CastleBlack.png", "CastleWhite.png");
    }

    //Phase 1 -complete
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        //=================================== LEFT, RIGHT, UP and DOWN =================================================
        int num = Board.BOARD_SIZE; //8

        // for RIGHT direction
        // iterations would be 7 - currentCol, to make the castle go till the end of the board in right direction.
        for (int i = 1; i <= (num - 1) - currentCol; i++) {
            // if opposite color is on the castles' path then castle can capture it
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow, currentCol + i))) {
                if (futureRow == currentRow && futureCol == currentCol + i) {
                    return true;
                }
            }
            // if not the opp color then break if a piece i found which will be of same color
            if (getBoard().hasPiece(currentRow, currentCol + i)) {
                break;
            } else {
                // if nothing then simply process with green valid tiles in right direction.
                if (currentRow == futureRow && currentCol + i == futureCol) {
                    return true;
                }
            }
        }
        //-----------------same concept below just in different directions----------------------------------------------

        // for LEFT direction
        // iterations would be currentCol, to make the castle go till the end of the board in left direction.
        for (int i = 1; i <= currentCol; i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow, currentCol - i))) {
                if (futureRow == currentRow && futureCol == currentCol - i) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow, currentCol - i)) {
                break;
            } else {
                if (currentRow == futureRow && currentCol - i == futureCol) {
                    return true;
                }
            }
        }
        //-----------------------------------------------------------------

        // for UP direction
        // iterations would be 7 - currentRow, to make the castle go till the end of the board in up direction.
        for (int i = 1; i <= (num - 1) - currentRow; i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow + i, currentCol))) {
                if (futureRow == currentRow + i && futureCol == currentCol) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow + i, currentCol)) {
                break;
            } else {
                if (currentRow + i == futureRow && currentCol == futureCol) {
                    return true;
                }
            }
        }
        //-----------------------------------------------------------------

        // for DOWN direction
        // iterations would be currentRow, to make the castle go till the end of the board in up direction.
        for (int i = 1; i <= currentRow; i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow - i, currentCol))) {
                if (futureRow == currentRow - i && futureCol == currentCol) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow - i, currentCol)) {
                break;
            } else {
                if (currentRow - i == futureRow && currentCol == futureCol) {
                    return true;
                }
            }
        }
        return false;
    }
}


