import com.sun.source.tree.CatchTree;

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
        int num = Board.BOARD_SIZE;

        // partially works but detects the white and black
//        if (getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(futureRow, futureCol))) {
//            return false;
//        }
//=======================================================================================================================

        //increasing rows

        for (int i = 1; i <= num; i++) {
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



//        for (int i = 1; i <= num; i++) {
//
//            //Rows movement for both pieces
//            if (getBoard().getPieceColor(currentRow, currentCol).equals(Board.white)) {
//                if (getBoard().getPieceColor(currentRow + i, currentCol).equals(Board.white)) {
//                    if ((currentRow + i == futureRow && currentCol == futureCol))
//                        return false;
//                }
//                if (getBoard().getPieceColor(currentRow - i, currentCol).equals(Board.white)) {
//                    if ((currentRow - i == futureRow && currentCol == futureCol))
//                        return false;
//                }
//                if (getBoard().getPieceColor(currentRow - i, currentCol).equals(Board.white)) {
//                    if ((currentCol - i == futureCol && currentRow == futureRow))
//                        return false;
//                }
//                if (getBoard().getPieceColor(currentRow - i, currentCol).equals(Board.white)) {
//                    if ((currentCol + i == futureCol && currentRow == futureRow))
//                        return false;
//                }
//                if ((currentRow + i == futureRow && currentCol == futureCol))
//                    return true;
//            }
//            if ((currentRow - i == futureRow && currentCol == futureCol))
//                return true;
//
//            // Column movement for both pieces
//            if ((currentCol - i == futureCol && currentRow == futureRow))
//                return true;
//            if ((currentCol + i == futureCol && currentRow == futureRow))
//                return true;


        return false;

    }
}


