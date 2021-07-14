import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BoardLoader {

    public static void loadBoardState(Board theBoard, String fileName) {

    }

    private static String[][] parseFile(String fileName) {
        String[][] str = null;
        int rows;
        int cols;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            Scanner sc = new Scanner(br);

            rows = sc.nextInt();
            cols = sc.nextInt();

            str = new String[rows][cols];

//            for (int i = 0; i < rows; i++) {
//                line = br.readLine();
//                for (int j = 0; j < cols; j++) {
//                    str[i][j] =
//                }
//            }

        } catch (IOException ioe) {
            ioe.getStackTrace();
        }

        return str;
    }


}

