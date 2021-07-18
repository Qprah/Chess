import java.io.*;
import java.util.Scanner;

public class BoardLoader {

    // the boardLoader test is in testClass , it can be used to run the
    // game itself, but currently only the Board class is responsible for the board setting.

    private static String[][] Board;


    public static String folder = ".\\Boards\\";
    public static String fileName = "StandardBoard.txt";

    public static void loadBoardState(Board theBoard, String fileName) {
        loadPiecesFromString(theBoard, parseFile(fileName));
    }

    private static String[][] parseFile(String fileName) {

        try {
            FileReader fr = new FileReader(fileName); // reads the file
            BufferedReader br = new BufferedReader(fr); // more efficiently

            String str = br.readLine(); // stores the read line in a string

            Scanner sc = new Scanner(str);// scanner to get the line read earlier.

            int rows = sc.nextInt(); // read the first int and stores it as rows
            int cols = sc.nextInt(); // reads the second int and stores it as cols

            Board = new String[rows][cols];  // initializes the board to have 8 rows and 8 columns

            // iteration through the matrix and the tokens are set in Board array
            for (int i = Board.length - 1; i >= 0; i--) {

                str = br.readLine();
                sc = new Scanner(str);

                while (sc.hasNext()) {
                    for (int j = 0; j < Board[i].length; j++) {
                        if (sc.hasNext()) {
                            Board[i][j] = sc.next();
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Board;
    }

    // sets the pieces and draws them on the targetBoard
    private static void loadPiecesFromString(Board targetBoard, String[][] boardCodes) {
        for (int i = 0; i < boardCodes.length; i++) {
            for (int j = 0; j < boardCodes[i].length; j++) {
                targetBoard.setPiece(i, j, loadChessPiece(targetBoard, boardCodes[i][j]));
                targetBoard.drawPiece(i, j);
            }
        }
    }

    // this method associates the Alphabets to the different color chessPieces that are
    // returned in loadPiecesFromString method as a parameter for setPiece.
    private static ChessPiece loadChessPiece(Board targetBoard, String code) {
        //White pieces
        if (code.charAt(0) == 'W')
        {
            if (code.charAt(1) == 'P') {
                return new Pawn("WHITE", targetBoard);
            }
            if (code.charAt(1) == 'C') {
                return new Castle("WHITE", targetBoard);
            }
            if (code.charAt(1) == 'N') {
                return new Knight("WHITE", targetBoard);
            }
            if (code.charAt(1) == 'B') {
                return new Bishop("WHITE", targetBoard);
            }
            if (code.charAt(1) == 'Q') {
                return new Queen("WHITE", targetBoard);
            }
            if (code.charAt(1) == 'K') {
                return new King("WHITE", targetBoard);
            }
        }
        // Black pieces
        if (code.charAt(0) == 'B')
        {
            if (code.charAt(1) == 'P') {
                return new Pawn("BLACK", targetBoard);
            }
            if (code.charAt(1) == 'C') {
                return new Castle("BLACK", targetBoard);
            }
            if (code.charAt(1) == 'N') {
                return new Knight("BLACK", targetBoard);
            }
            if (code.charAt(1) == 'B') {
                return new Bishop("BLACK", targetBoard);
            }
            if (code.charAt(1) == 'Q') {
                return new Queen("BLACK", targetBoard);
            }
            if (code.charAt(1) == 'K') {
                return new King("BLACK", targetBoard);
            }
        }
        return null;
    }
}

