public class Queen extends ChessPiece {

    public Queen(String newColor, Board theBoard) {
        super("Queen", newColor, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");
    }

    public Queen(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");

    }//Phase 1 - complete

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {

        // ALL CODE FROM BISHOP AND CASTLE AS QUEEN IS A COMBINATION OF THEIR MOVEMENTS!

        //=================================== LEFT, RIGHT, UP and DOWN =================================================
        int num = Board.BOARD_SIZE; //8

        // for RIGHT direction
        for (int i = 1; i <= (num - 1) - currentCol; i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow, currentCol + i))) {
                if (futureRow == currentRow && futureCol == currentCol + i) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow, currentCol + i)) {
                break;
            } else {
                if (currentRow == futureRow && currentCol + i == futureCol) {
                    return true;
                }
            }
        }
        //-----------------------------------------------------------------

        // for LEFT direction
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

        //===================================== DIAGONALS CONTROL =========================================================================

        // For top-right diagonal
        for (int i = 1; i <= Bishop.maxIterationsTopRight(currentRow, currentCol); i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow + i, currentCol + i))) {
                if (futureRow == currentRow + i && futureCol == currentCol + i) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow + i, currentCol + i)) {
                break;
            } else {
                if (currentRow + i == futureRow && currentCol + i == futureCol) {
                    return true;
                }
            }
        }
        //-----------------------------------------------------------------

        // For bottom-left diagonal
        for (int i = 1; i <= Bishop.maxIterationsBottomLeft(currentRow, currentCol); i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow - i, currentCol - i))) {
                if (futureRow == currentRow - i && futureCol == currentCol - i) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow - i, currentCol - i)) {
                break;
            } else {
                if (currentRow - i == futureRow && currentCol - i == futureCol) {
                    return true;
                }

            }
        }
        //-----------------------------------------------------------------

        // For bottom-right diagonal
        for (int i = 1; i <= Bishop.maxIterationsBottomRight(currentRow, currentCol); i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow - i, currentCol + i))) {
                if (futureRow == currentRow - i && futureCol == currentCol + i) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow - i, currentCol + i)) {
                break;
            } else {
                if (currentRow - i == futureRow && currentCol + i == futureCol) {
                    return true;
                }
            }
        }
        //-----------------------------------------------------------------

        // For top-left diagonal
        for (int i = 1; i <= Bishop.maxIterationsTopLeft(currentRow, currentCol); i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow + i, currentCol - i))) {
                if (futureRow == currentRow + i && futureCol == currentCol - i) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow + i, currentCol - i)) {
                break;
            } else {
                if (currentRow + i == futureRow && currentCol - i == futureCol) {
                    return true;
                }
            }
        }
        //-----------------------------------------------------------------
        return false;
    }
}