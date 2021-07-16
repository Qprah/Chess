import java.io.*;
import java.util.Scanner;

public class BoardLoader {

    private static String[][] board;
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

            board = new String[rows][cols];  // initializes the board to have 8 rows and 8 columns

            for (int i = board.length-1 ; i >= 0; i--) {
                str = br.readLine();
                sc = new Scanner(str);
                while (sc.hasNext()) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (sc.hasNext()) {
                            board[i][j] = sc.next();
                            System.out.print(" " + board[i][j]);
                        }
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return board;
    }

    private static void loadPiecesFromString(Board targetBoard, String[][] boardCodes) {
        for (int i = 0; i < boardCodes.length; i++) {
            for (int j = 0; j < boardCodes[i].length; j++) {
                targetBoard.setPiece(i, j, loadChessPiece(targetBoard, boardCodes[i][j]));
                targetBoard.drawPiece(i, j);
            }
        }
    }

    private static ChessPiece loadChessPiece(Board targetBoard, String code) {
        if (code.charAt(0) == 'W') {
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
        if (code.charAt(0) == 'B') {
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

