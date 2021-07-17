import javax.swing.plaf.ColorUIResource;

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

        // For top-right direction
        for (int i = 1; i <= maxIterationsTopRight(currentRow, currentCol); i++) {

            if (getBoard().hasPiece(currentRow + i, currentCol + i)) {
                break;
            } else {
                if (currentRow + i == futureRow && currentCol + i == futureCol) {
                    return true;
                }

            }
        }

        for (int i = 1; i <= maxIterationsBottomLeft(currentRow, currentCol); i++) {
            if (getBoard().hasPiece(currentRow - i, currentCol - i)) {
                break;
            } else {
                if (currentRow - i == futureRow && currentCol - i == futureCol) {
                    return true;
                }

            }
        }
        for (int i = 1; i <= maxIterationsBottomRight(currentRow, currentCol); i++)
            if (getBoard().hasPiece(currentRow - i, currentCol + i)) {
                break;
            } else {
                if (currentRow - i == futureRow && currentCol + i == futureCol) {
                    return true;
                }
            }
        return false;
    }


    /**
     * The do-while loops are responsible for the diagonal movement of the bishop.
     */
//        // diagonal in top-right direction.
//        int i = 0;
//        do {
//            if (currentRow + i == futureRow && currentCol + i == futureCol) {
//                return true;
//            }
//            i++;
//        } while ((i < 10));
//
//        // diagonal in bottom-left direction
//        int j = 0;
//        do {
//            if (currentRow - j == futureRow && currentCol - j == futureCol) {
//                return true;
//            }
//            j++;
//        } while ((j < 10));
//
//        // diagonal in top-left direction
//        int k = 0;
//        do {
//            if (currentRow + k == futureRow && currentCol - k == futureCol) {
//                return true;
//            }
//            k++;
//        } while ((k < 10));
//
//        // diagonal in bottom-right direction
//        int l = 0;
//        do {
//            if (currentRow - l == futureRow && currentCol + l == futureCol) {
//                return true;
//            }
//            l++;
//        } while ((l < 10));
//
//
//        return false;
//    }
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


    /**
     * make a method - checks the rows,
     * columns,
     * diagonals.
     *
     * startR, startC, endR, endC
     * rows - i found the piece on the row
     *
     * say it's on right side
     *
     * ---cp---------P----
     *
     *
     * ----C------------
     */

}


