public class Pawn extends ChessPiece {

    public Pawn(String newColor, Board theBoard) {
        super("Pawn", newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");
        // Un-versioned files are also in the commit i.e png files

    }

    public Pawn(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");

    }
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {

        if(futureRow == currentRow && futureCol == currentRow) {
            return false;
        }
        if( super.getBoard().getPieceColor(currentRow,currentCol) == "WHITE" && futureRow == currentRow+1 && futureCol == currentCol){
            return true;
        }
        if( super.getBoard().getPieceColor(currentRow,currentCol) == "BLACK" && futureRow == currentRow-1 && futureCol == currentCol){
            return true;
        }
//        for(int i = 0 ; i<currentRow+2 ; i++){
//            for(int j = 0 ; j<currentRow+2 ; j++){
//                if(super.getBoard().hasPiece(i,j)){
//                    if(super.getBoard().getPieceColor(i,j) == super.getBoard().getPieceColor(currentRow,currentCol)){
//                        return true;
//                    }
//                }
//            }
//        }









//                if(super.getBoard().getPieceColor(currentRow, currentCol)
//                        == super.getBoard().getPieceColor(7, 4)){
//                    return false;
//                }

        return false;
    }
}

