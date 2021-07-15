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
 */

        //TWO STEPS CODE ---------------------------------------------------------------------------------------------------------------------------
        //only at row 1 and when the piece is white .. it will move two steps
        if (currentRow == 1 && getBoard().getPieceColor(currentRow, currentCol).equals(Board.white)) {  // have two steps if It's in row 6 or Row 1
            int num = 2;  //more work required
            for (int i = 1; i <= num; i++) {
                if (getBoard().hasPiece(currentRow + i, currentCol)) {  // if any piece in its column, it won't be able to kill it.
                    return false;
                } else if (futureRow == currentRow + i && futureCol == currentCol) {//iteration for making the pawn go up 2 tiles
                    return true;
                }
            }
        }
        //only when at row 6 and the piece is black .. it will move two steps down
        else if (currentRow == 6 && getBoard().getPieceColor(currentRow, currentCol).equals(Board.black)) {
            int num = 2;  //more work required
            for (int i = 1; i <= num; i++) {
                if (getBoard().hasPiece(currentRow - i, currentCol)) { // if any piece in its column then it won't kill.
                    return false;
                } else if (futureRow == currentRow - i && futureCol == currentCol) {//iteration for making the pawn go up 2 tiles
                    return true;
                }
            }
            // ONE STEP CODE --------------------------------------------------------------------------------------------------------------
        } else if (currentRow != 1 && getBoard().getPieceColor(currentRow, currentCol).equals(Board.white)) {

            //iteration for making the pawn go up 1 tile
            if (getBoard().hasPiece(currentRow + 1, currentCol)) { // even when moving one step, it can't kill
                return false;
            } else return futureRow == currentRow + 1 && futureCol == currentCol;

        } else if (currentRow != 1 && getBoard().getPieceColor(currentRow, currentCol).equals(Board.black)) {
            int num = 1;  //more work required
            for (int i = 1; i <= num; i++) {
                if (getBoard().hasPiece(currentRow - i, currentCol)) { // even when moving one step it won't kill
                    return false;
                } else if (futureRow == currentRow - i && futureCol == currentCol) {//iteration for making the pawn go down 1 tile
                    return true;
                }
            }
        }
        return false;
    }
}



