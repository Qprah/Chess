public class Pawn extends ChessPiece {

    public Pawn(String newColor, Board theBoard) { //1st
        super("Pawn", newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");

    }

    public Pawn(String name, String newColor, Board theBoard) { // 2nd
        super(name, newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");

    }

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
/**
 * PAWN features:
 *
 *   ----- Moves two steps at first turn and then only one step.
 *
 *   ----- Can't kill the opposite in it's own column
 *
 *   ----- Kills diagonally (can ignore and move forward or it can kill diagonally)
 *
 *   current Row + 1  , current Col -1 +i   1<i<=3
 *
 *
 */
//TWO STEP CODE WORKS FIRE!    // FOR WHITE with diagonal capturing
        if (currentRow == 1 && getBoard().getPieceColor(currentRow, currentCol).equals(Board.white)) {  // have two steps if It's in row 6 or Row 1
            int num = 2;
            for (int i = 1; i <= num; i++) {
                if (getBoard().hasPiece(currentRow + i, currentCol)) {  // if any piece in the path break the loop and stop
                    break;
                } else {
                    if (currentRow + i == futureRow && currentCol == futureCol) {
                        return true;
                    }
                }
            }
            //add for checking C+1 and C-1
            if (getBoard().getPieceColor(currentRow + 1, currentCol + 1).equals(Board.black)) {
                if (futureRow == currentRow + 1 && futureCol == currentCol + 1) {//iteration for checking the
                    return true;
                }
            }
            if (getBoard().getPieceColor(currentRow + 1, currentCol - 1).equals(Board.black)) {
                if (futureRow == currentRow + 1 && futureCol == currentCol - 1) {
                    return true;
                }
            }
            return false;
        }

        //ONE STEP CODE // FOR WHITE with diagonal capturing!
        if (currentRow != 1 && getBoard().getPieceColor(currentRow, currentCol).equals(Board.white)) {

            if (getBoard().hasPiece(currentRow + 1, currentCol)) {
                if (getBoard().getPieceColor(currentRow + 1, currentCol + 1).equals(Board.black)) {
                    if (futureRow == currentRow + 1 && futureCol == currentCol + 1) {//iteration for checking the
                        return true;
                    }
                }
                if (getBoard().getPieceColor(currentRow + 1, currentCol - 1).equals(Board.black)) {
                    if (futureRow == currentRow + 1 && futureCol == currentCol - 1) {
                        return true;
                    }
                }
                return false;
            } else {
                if (currentRow + 1 == futureRow && currentCol == futureCol) {
                    return true;
                }
            }
            if (getBoard().getPieceColor(currentRow + 1, currentCol + 1).equals(Board.black)) {
                if (futureRow == currentRow + 1 && futureCol == currentCol + 1) {//iteration for checking the
                    return true;
                }
            }
            if (getBoard().getPieceColor(currentRow + 1, currentCol - 1).equals(Board.black)) {
                if (futureRow == currentRow + 1 && futureCol == currentCol - 1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}




