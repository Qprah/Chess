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

        for (int i = 1; i <= (num - 1) - currentCol; i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow, currentCol + i))) {
                if (futureRow == currentRow && futureCol == currentCol + i) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow, currentCol + i)) {
                break;
            } else {
                if (currentRow == futureRow && currentCol + i == futureCol) {
                    return true;
                }
            }
        }
        for (int i = 1; i <= currentCol; i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow, currentCol - i))) {
                if (futureRow == currentRow && futureCol == currentCol - i) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow, currentCol - i)) {
                break;
            } else {
                if (currentRow == futureRow && currentCol - i == futureCol) {
                    return true;
                }
            }
        }
        for (int i = 1; i <= (num - 1) - currentRow; i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow+i, currentCol))) {
                if (futureRow == currentRow + i && futureCol == currentCol) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow + i, currentCol)) {
                break;
            } else {
                if (currentRow + i == futureRow && currentCol== futureCol) {
                    return true;
                }
            }
        }
        for (int i = 1; i <= currentRow; i++) {
            if (!getBoard().getPieceColor(currentRow, currentCol).equals(getBoard().getPieceColor(currentRow - i, currentCol))) {
                if (futureRow == currentRow - i  && futureCol == currentCol) {
                    return true;
                }
            }
            if (getBoard().hasPiece(currentRow - i, currentCol)) {
                break;
            } else {
                if (currentRow - i == futureRow && currentCol== futureCol) {
                    return true;
                }
            }
        }
        return false;
    }
}


