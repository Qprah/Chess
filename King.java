public class King extends ChessPiece {

    public King(String newColor, Board theBoard) {
        super("King", newColor, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");
    }

    public King(String name, String color, Board theBoard) {
        super(name, color, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");

    }

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
//        int startrow = currentRow - 1;
//        int startcol = currentCol - 1;

        for (int i = currentRow - 1; i < currentRow+2; i++) {
            for (int j = currentCol - 1; j < currentCol + 2; j++) {

                if (futureRow == i && futureCol == j) {
                    System.out.println(futureRow + " " + futureCol + " " + i + "" + j + " " + (futureRow == i && futureCol == j) + "           " + currentRow + " " + currentCol);
                    return true;

                }
                if (futureRow == currentRow && futureCol == currentRow) {
                    return false;
                }
                /**
                if(super.getBoard().getPieceColor(currentRow, currentCol)
                        == super.getBoard().getPieceColor(7, 4)){
                    return false;
                }
                 */
            }
        }

        return false;
    }
}





