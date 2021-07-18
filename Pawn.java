/**
 * PAWN:
 *
 * It can move two steps when in starting position and one step afterwards when it's not.
 *
 * it can capture diagonally if there is piece at C+1 and R+1  or C-1 and R+1
 *
 * There are 4 different code sets 2 for White and 2 for Black and each of which works when a pawn
 * is allowed 2 steps in their starting position and then 1 step afterwards.
 */

public class Pawn extends ChessPiece {

    public Pawn(String newColor, Board theBoard) { //1st
        super("Pawn", newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");

    }

    public Pawn(String name, String newColor, Board theBoard) { // 2nd
        super(name, newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");

    }
    // Phase 1 - compete

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {

//================================================= BLACK  PAWN  BELOW =================================================

        /**
         * TWO STEP CODE WORKS!
         */
        //if any piece goes up or down to bottom, nothing will happen
        if(currentRow == 7 || currentRow == 0){
            return false;
        }

        // if the row is 6 and the piece selected is black then the pawn can move 2 steps.
        if (currentRow == 6 && getBoard().getPieceColor(currentRow, currentCol).equals(Board.black)) {
            // loops runs two make it go 2 steps down
            int num = 2;
            for (int i = 1; i <= num; i++) {
                // if any piece in the path break the loop and stops because the Pawn can't capture any piece on it's straight path
                if (getBoard().hasPiece(currentRow - i, currentCol)) {
                    break;
                } else {
                    //else continue the the path with valid tiles!
                    if (currentRow - i == futureRow && currentCol == futureCol) {
                        return true;
                    }
                }
            }
            // in case the pawn is on left side of the chessBoard it will only check the right column and not left because it doesn't exist.
            if (currentCol == 0) {
                if (getBoard().getPieceColor(currentRow - 1, currentCol + 1).equals(Board.white)) {
                    if (futureRow == currentRow - 1 && futureCol == currentCol + 1) {
                        return true;
                    }
                }
            }
            // same case is for extreme right of the board.
            if (currentCol == 7) {
                if (getBoard().getPieceColor(currentRow - 1, currentCol - 1).equals(Board.white)) {
                    if (futureRow == currentRow - 1 && futureCol == currentCol - 1) {
                        return true;
                    }
                }
            }
            //These two if blocks checks the C + 1 and C - 1 in (R-1) for the opposite color so that it can capture it!
            //ONE
            if (currentCol > 0 && currentCol < 7) {
                if (getBoard().getPieceColor(currentRow - 1, currentCol + 1).equals(Board.white)) {
                    if (futureRow == currentRow - 1 && futureCol == currentCol + 1) {
                        return true;
                    }
                }
                //TWO
                if (getBoard().getPieceColor(currentRow - 1, currentCol - 1).equals(Board.white)) {
                    if (futureRow == currentRow - 1 && futureCol == currentCol - 1) {
                        return true;
                    }
                }
            }


            return false;
        } // end of two step code for black

        /**
         * ONE STEP CODE WORKS!
         */

        //if the pawn is not on row 6 and is black then everything works according to this If block
        if (currentRow != 6 && getBoard().getPieceColor(currentRow, currentCol).equals(Board.black)) {

            // this If block checks 1 tile down
            if (getBoard().hasPiece(currentRow - 1, currentCol)) {


                // in case the pawn is on left side of the chessBoard it will only check the right column and not left because it doesn't exist.
                if (currentCol == 0) {
                    if (getBoard().getPieceColor(currentRow - 1, currentCol + 1).equals(Board.white)) {
                        if (futureRow == currentRow - 1 && futureCol == currentCol + 1) {
                            return true;
                        }
                    }
                }
                // same case is for extreme right of the board.
                if (currentCol == 7) {
                    if (getBoard().getPieceColor(currentRow - 1, currentCol - 1).equals(Board.white)) {
                        if (futureRow == currentRow - 1 && futureCol == currentCol - 1) {
                            return true;
                        }
                    }
                }
                if (currentCol > 0 && currentCol < 7) {
                    //These two if blocks checks the C + 1 and C - 1 in (R-1) for the opposite color so that it can capture it!
                    //ONE
                    if (getBoard().getPieceColor(currentRow - 1, currentCol + 1).equals(Board.white)) {
                        if (futureRow == currentRow - 1 && futureCol == currentCol + 1) {
                            return true;
                        }
                    }
                    //TWO
                    if (getBoard().getPieceColor(currentRow - 1, currentCol - 1).equals(Board.white)) {
                        if (futureRow == currentRow - 1 && futureCol == currentCol - 1) {
                            return true;
                        }
                    }
                }
            }

            //so that the piece also has the option to go one tile down alongside checking the C+1 and C-1 in R-1.
            else {
                if (currentRow - 1 == futureRow && currentCol == futureCol) {
                    return true;
                }
            }

            // in case the pawn is on left side of the chessBoard it will only check the right column and not left because it doesn't exist.
            if (currentCol == 0) {
                if (getBoard().getPieceColor(currentRow - 1, currentCol + 1).equals(Board.white)) {
                    if (futureRow == currentRow - 1 && futureCol == currentCol + 1) {
                        return true;
                    }
                }
            }
            // same case is for extreme right of the board.
            if (currentCol == 7) {
                if (getBoard().getPieceColor(currentRow - 1, currentCol - 1).equals(Board.white)) {
                    if (futureRow == currentRow - 1 && futureCol == currentCol - 1) {
                        return true;
                    }
                }
            }
            // other than extreme left and right the pawn can freely check the 3 columns in the roe below it
            if (currentCol > 0 && currentCol < 7) {
                //These two if blocks checks the C + 1 and C - 1 in (R-1) for the opposite color so that it can capture it!
                //ONE
                if (getBoard().getPieceColor(currentRow - 1, currentCol + 1).equals(Board.white)) {
                    if (futureRow == currentRow - 1 && futureCol == currentCol + 1) {
                        return true;
                    }
                }
                //TWO
                if (getBoard().getPieceColor(currentRow - 1, currentCol - 1).equals(Board.white)) {
                    if (futureRow == currentRow - 1 && futureCol == currentCol - 1) {
                        return true;
                    }
                }
            }
        }
//================================================= WHITE  PAWN  BELOW =================================================

//------------------------------------------------FOR WHITE PAWN with diagonal capturing--------------------------------

        /**
         * TWO STEP CODE WORKS! the commenting for black pawn has been done!
         * both pawns work the same just with opposite directions.
         */


        if (currentRow == 1 && getBoard().getPieceColor(currentRow, currentCol).equals(Board.white)) {

            int num = 2;

            for (int i = 1; i <= num; i++) {
                if (getBoard().hasPiece(currentRow + i, currentCol)) {
                    break;

                } else {
                    if (currentRow + i == futureRow && currentCol == futureCol) {
                        return true;
                    }
                }
            }

            //added for checking C+1 and C-1
            // in case the pawn is on left side of the chessBoard it will only check the right column and not left because it doesn't exist.
            if (currentCol == 0) {
                if (getBoard().getPieceColor(currentRow + 1, currentCol + 1).equals(Board.black)) {
                    if (futureRow == currentRow + 1 && futureCol == currentCol + 1) {
                        return true;
                    }
                }
            }
            // same case is for extreme right of the board.
            if (currentCol == 7) {
                if (getBoard().getPieceColor(currentRow + 1, currentCol - 1).equals(Board.black)) {
                    if (futureRow == currentRow + 1 && futureCol == currentCol - 1) {
                        return true;
                    }
                }
            }
            //These two if blocks checks the C + 1 and C - 1 in (R+1) for the opposite color so that it can capture it!
            //ONE
            if (currentCol > 0 && currentCol < 7) {
                if (getBoard().getPieceColor(currentRow + 1, currentCol + 1).equals(Board.black)) {
                    if (futureRow == currentRow + 1 && futureCol == currentCol + 1) {
                        return true;
                    }
                }
                //TWO
                if (getBoard().getPieceColor(currentRow + 1, currentCol - 1).equals(Board.black)) {
                    if (futureRow == currentRow + 1 && futureCol == currentCol - 1) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * ONE STEP CODE WORKS!
         */
        if (currentRow != 1 && getBoard().getPieceColor(currentRow, currentCol).equals(Board.white)) {

            if (getBoard().hasPiece(currentRow + 1, currentCol)) {
                //added for checking C+1 and C-1
                // in case the pawn is on left side of the chessBoard it will only check the right column and not left because it doesn't exist.
                if (currentCol == 0) {
                    if (getBoard().getPieceColor(currentRow + 1, currentCol + 1).equals(Board.black)) {
                        if (futureRow == currentRow + 1 && futureCol == currentCol + 1) {
                            return true;
                        }
                    }
                }
                // same case is for extreme right of the board.
                if (currentCol == 7) {
                    if (getBoard().getPieceColor(currentRow + 1, currentCol - 1).equals(Board.black)) {
                        if (futureRow == currentRow + 1 && futureCol == currentCol - 1) {
                            return true;
                        }
                    }
                }
                //These two if blocks checks the C + 1 and C - 1 in (R+1) for the opposite color so that it can capture it!
                //ONE
                if (currentCol > 0 && currentCol < 7) {
                    if (getBoard().getPieceColor(currentRow + 1, currentCol + 1).equals(Board.black)) {
                        if (futureRow == currentRow + 1 && futureCol == currentCol + 1) {
                            return true;
                        }
                    }
                    //TWO
                    if (getBoard().getPieceColor(currentRow + 1, currentCol - 1).equals(Board.black)) {
                        if (futureRow == currentRow + 1 && futureCol == currentCol - 1) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                if (currentRow + 1 == futureRow && currentCol == futureCol) {
                    return true;
                }
            }
            //added for checking C+1 and C-1
            // in case the pawn is on left side of the chessBoard it will only check the right column and not left because it doesn't exist.
            if (currentCol == 0) {
                if (getBoard().getPieceColor(currentRow + 1, currentCol + 1).equals(Board.black)) {
                    if (futureRow == currentRow + 1 && futureCol == currentCol + 1) {
                        return true;
                    }
                }
            }
            // same case is for extreme right of the board.
            if (currentCol == 7) {
                if (getBoard().getPieceColor(currentRow + 1, currentCol - 1).equals(Board.black)) {
                    if (futureRow == currentRow + 1 && futureCol == currentCol - 1) {
                        return true;
                    }
                }
            }
            //These two if blocks checks the C + 1 and C - 1 in (R+1) for the opposite color so that it can capture it!
            //ONE
            if (currentCol > 0 && currentCol < 7) {
                if (getBoard().getPieceColor(currentRow + 1, currentCol + 1).equals(Board.black)) {
                    if (futureRow == currentRow + 1 && futureCol == currentCol + 1) {
                        return true;
                    }
                }
                //TWO
                if (getBoard().getPieceColor(currentRow + 1, currentCol - 1).equals(Board.black)) {
                    if (futureRow == currentRow + 1 && futureCol == currentCol - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}




