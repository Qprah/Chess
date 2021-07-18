public class Knight extends ChessPiece {

    public Knight(String newColor, Board theBoard) {
        super("Knight", newColor, theBoard);
        super.setGraphics("KnightBlack.png", "KnightWhite.png");
    }

    public Knight(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("KnightBlack.png", "KnightWhite.png");

    }
    //Phase 1 -complete

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {

        // is same color then the knight can't capture it.
        // this general if statement works because the valid moves are manual.
        if (getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(futureRow, futureCol))) {
            return false;
        }
        //R = currentRow
        //C = currentCol

        //two columns on the upper side (R+2) && (C+1, C-1)
        if (futureRow == currentRow + 2) {
            if (futureCol == currentCol + 1) {
                return true;
            } else if (futureCol == currentCol - 1) {
                return true;
            }
        }
        //two columns on the bottom side (R-2) && (C+1, C-1)
        if (futureRow == currentRow - 2) {
            if (futureCol == currentCol + 1) {
                return true;
            } else if (futureCol == currentCol - 1) {
                return true;
            }
        }
        //two columns on the right side (R+1) && (C+2, C-2)
        if (futureRow == currentRow + 1) {
            if (futureCol == currentCol + 2) {
                return true;
            } else if (futureCol == currentCol - 2) {
                return true;
            }
        }
        //two columns on the left side (R-1) && (C+2, C-2)
        if (futureRow == currentRow - 1) {
            if (futureCol == currentCol + 2) {
                return true;
            } else return futureCol == currentCol - 2;
        }
        return false;
    }
}


