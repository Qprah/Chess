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

        if ((getBoard().getPieceColor(futureRow, futureCol)).equals(getBoard().getPieceColor(currentRow, currentCol)))
            return false;

        // white piece - lets the white pawn take two steps initially
        if (super.getBoard().getPieceColor(currentRow, currentCol).equals(Board.white)) {
            if ((futureRow == currentRow + 2 || futureRow == currentRow + 1) && futureCol == currentCol) {
                return true;
            }
        }

        // black piece - lets the black pawn take two steps initially
        if (super.getBoard().getPieceColor(currentRow, currentCol).equals(Board.black)) {
            return (futureRow == currentRow - 2 || futureRow == currentRow - 1) && futureCol == currentCol;
        }
//        System.out.println(super.getBoard().getPieceColor(currentRow, currentCol) + " "+
//        super.getBoard().getPieceColor(futureRow, futureCol)+ "    fr  " + futureRow + "    fc " + futureCol
//        + "    cr "+ currentRow + "    cc "+currentCol);

        return false;
    }
}

//                if(super.getBoard().getPieceColor(currentRow, currentCol)
//                        == super.getBoard().getPieceColor(7, 4)){
//                    return false;
//                }




