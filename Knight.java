public class Knight extends ChessPiece {

    public Knight(String newColor, Board theBoard) {
        super("Knight", newColor, theBoard);
        super.setGraphics("KnightBlack.png", "KnightWhite.png");
    }

    public Knight(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("KnightBlack.png", "KnightWhite.png");

    }

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {

        if(getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(futureRow,futureCol))){
            return false;
        }
        //top
        if(futureRow == currentRow + 2){
            if(futureCol == currentCol + 1){
                return true;
            }
            else if(futureCol == currentCol - 1){
                return true;
            }
        }
        //bottom
        if(futureRow == currentRow - 2){
            if(futureCol == currentCol + 1){
                return true;
            }
            else if(futureCol == currentCol - 1){
                return true;
            }
        }
        //right
        if(futureRow == currentRow + 1){
            if(futureCol == currentCol + 2){
                return true;
            }
            else if(futureCol == currentCol - 2){
                return true;
            }
        }
        //left
        if(futureRow == currentRow - 1){
            if(futureCol == currentCol + 2){
                return true;
            }
            else return futureCol == currentCol - 2;
        }
        return false;
    }
}


