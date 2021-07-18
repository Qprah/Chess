
public class Bishop extends ChessPiece {

    public Bishop(String newColor, Board theBoard) {
        super("King", newColor, theBoard);
        super.setGraphics("BishopBlack.png", "BishopWhite.png");
    }

    public Bishop(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("BishopBlack.png", "BishopWhite.png");
    }
    //Phase 1 -complete


    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {

        //bishop works properly

        /**
         * There are 4 loops which are responsible for the diagonal movement of the bishop.
         * 4 different methods have been used for all direction iterations.
         */

        // For top-right diagonal
        for (int i = 1; i <= maxIterationsTopRight(currentRow, currentCol); i++) {
            //if the colors of the two pieces not equal in the top-right direction then current piece can capture the other.
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow + i, currentCol + i))) {
                if (futureRow == currentRow + i && futureCol == currentCol + i) {
                    return true;
                }
            }
            // if it's not the different color then upper if condition will be skipped and this if (below) starts working.
            if (getBoard().hasPiece(currentRow + i, currentCol + i)) {
                break;
            } else {
                // to have the valid moves in the top-right if none conditions are met, that means path is clear.
                if (currentRow + i == futureRow && currentCol + i == futureCol) {
                    return true;
                }
            }
        }

        // For bottom-left diagonal
        // same concept as in top-right diagonal just the direction is opposite.
        for (int i = 1; i <= maxIterationsBottomLeft(currentRow, currentCol); i++) {
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


        // For bottom-right diagonal
        // same concept but direction is bottom-right (R decreases and C increases)
        for (int i = 1; i <= maxIterationsBottomRight(currentRow, currentCol); i++) {
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

        // For top-left diagonal
        // same concept as before
        for (int i = 1; i <= maxIterationsTopLeft(currentRow, currentCol); i++) {
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
        return false;
    }

    //All methods below have been called in Queen class;
    /**(calculates the number of tiles diagonally from current position of selected piece)*/
    // how many times the loop is run for going up-right
    public static int maxIterationsTopRight(int currentRow, int currentCol) {
        int iterations;
        iterations = Math.min((Board.BOARD_SIZE - 1) - currentRow, (Board.BOARD_SIZE - 1) - currentCol);
        return iterations;
    }

    // times the loop runs to go bottom left
    public static int maxIterationsBottomLeft(int currentRow, int currentCol) {
        int iterations;
        iterations = Math.min(currentRow, currentCol);
        return iterations;
    }

    // times the loop runs to go bottom right
    public static int maxIterationsBottomRight(int currentRow, int currentCol) {
        int iterations;
        int cr = currentRow;
        int cc = currentCol;

        //Here the chessPiece works differently on different portions of the chessBoard.
        //Any R and C below the central diagonal (starting from top-left and ending on bottom right) would follow the first if block
        //otherwise the else block is valid for all other positions of the selected piece on the chessBoard.
        if ((cr <= 7 && cc == 0) || (cr <= 6 && cc == 1) || (cr <= 5 && cc == 2) || (cr <= 4 && cc == 3)
                || (cr <= 3 && cc == 4) || (cr <= 2 && cc == 5) || (cr <= 1 && cc == 6) || (cr <= 0 && cc == 7)) {
            iterations = currentRow;

        } else {
            iterations = (Board.BOARD_SIZE - 1) - currentCol;
        }
        return iterations;
    }

    // times the loop runs to go top left
    public static int maxIterationsTopLeft(int currentRow, int currentCol) {
        int iterations;
        int cr = currentRow;
        int cc = currentCol;

        //Any R and C below the central diagonal (starting from top-Right and ending on bottom-Left) would follow the first if block
        //otherwise the else block is valid for all other positions of the selected piece on the chessBoard.
        if ((cr >= 0 && cc == 7) || (cr >= 1 && cc == 6) || (cr >= 2 && cc == 5) || (cr >= 3 && cc == 4)
                || (cr >= 4 && cc == 3) || (cr >= 5 && cc == 2) || (cr >= 6 && cc == 1) || (cr >= 7 && cc == 0)) {
            iterations = (Board.BOARD_SIZE - 1) - currentRow;

        } else {
            iterations = currentCol;
        }
        return iterations;
    }

}


