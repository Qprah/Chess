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
        int num = Board.BOARD_SIZE;

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
        for (int i = 1; i <= (num - 1) - currentRow; i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow+i, currentCol))) {
                if (futureRow == currentRow + i && futureCol == currentCol) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow + i, currentCol)) {
                break;
            } else {
                if (currentRow + i == futureRow && currentCol== futureCol) {
                    return true;
                }
            }
        }
        for (int i = 1; i <= currentRow; i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow - i, currentCol))) {
                if (futureRow == currentRow - i  && futureCol == currentCol) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow - i, currentCol)) {
                break;
            } else {
                if (currentRow - i == futureRow && currentCol== futureCol) {
                    return true;
                }
            }
        }
        // For top-right diagonal
        for (int i = 1; i <= maxIterationsTopRight(currentRow, currentCol); i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow+i, currentCol+i))) {
                if(futureRow==currentRow+i && futureCol == currentCol+i){
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow + i, currentCol + i)) {
                break;
            }
            else {
                if (currentRow + i == futureRow && currentCol + i == futureCol) {
                    return true;
                }
            }
        }

        // For bottom-left diagonal
        for (int i = 1; i <= maxIterationsBottomLeft(currentRow, currentCol); i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow-i, currentCol-i))) {
                if(futureRow==currentRow-i && futureCol == currentCol-i){
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

        // For bottom-right diagonal
        for (int i = 1; i <= maxIterationsBottomRight(currentRow, currentCol); i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow-i, currentCol+i))) {
                if(futureRow==currentRow-i && futureCol == currentCol+i){
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

        // For top-left diagonal
        for (int i = 1; i <= maxIterationsTopLeft(currentRow, currentCol); i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow+i, currentCol-i))) {
                if(futureRow==currentRow+i && futureCol == currentCol-i){
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
        return false;
    }

    public int maxIterationsTopRight(int currentRow, int currentCol) {
        int iterations;
        iterations = Math.min((Board.BOARD_SIZE - 1) - currentRow, (Board.BOARD_SIZE - 1) - currentCol);
        return iterations;
    }

    public int maxIterationsBottomLeft(int currentRow, int currentCol) {
        int iterations;

        iterations = Math.min(currentRow, currentCol);
        return iterations;
    }

    public int maxIterationsBottomRight(int currentRow, int currentCol) {
        int iterations = 0;
        int cr = currentRow;
        int cc = currentCol;
        if ((cr <= 7 && cc == 0) || (cr <= 6 && cc == 1) || (cr <= 5 && cc == 2) || (cr <= 4 && cc == 3)
                || (cr <= 3 && cc == 4) || (cr <= 2 && cc == 5) || (cr <= 1 && cc == 6) || (cr <= 0 && cc == 7)) {
            iterations = currentRow;
        } else {
            iterations = (Board.BOARD_SIZE - 1) - currentCol;
        }
        return iterations;
    }

    public int maxIterationsTopLeft(int currentRow, int currentCol) {
        int iterations = 0;
        int cr = currentRow;
        int cc = currentCol;
        if ((cr >= 0 && cc == 7) || (cr >= 1 && cc == 6) || (cr >= 2 && cc == 5) || (cr >= 3 && cc == 4)
                || (cr >= 4 && cc == 3) || (cr >= 5 && cc == 2) || (cr >= 6 && cc == 1) || (cr >= 7 && cc == 0)) {
            iterations = (Board.BOARD_SIZE - 1) - currentRow;
        } else {
            iterations = currentCol;
        }
        return iterations;
    }

}