public class TestClassA3 {

    private static final int pauseTime = 3000;

    public static void main(String[] args) {

        // I usually just comment these out as I need them / don' need them.
        // it can be hard to tell what is being tested!
        // This is all just provided as an example, you should be testing your own code yourself.
        // And providing the test class as part of the hand in package.

        //phase1();
       // StdDraw.show(pauseTime);  // Draw all art and pause for 1 second
//        phase2(); // Castle and Pawn Test
//        StdDraw.show(pauseTime); // Draw all art and pause for 1 second
//        phase3();

        testBoardLoader();
        testQ();





    }
    //tests the queen
    public static void testQ(){

        Board b =new Board();

        b.drawBoard();
        b.setPiece(4, 4 , new Bishop("Bishop", "WHITE", b));
        b.drawPiece(4,4);



        //pause the b oard
        // clear the board make a new setting
    }

    public static void testBoardLoader(){
        Board b =new Board();
        b.drawBoard();
        BoardLoader.loadBoardState(b,BoardLoader.folder + BoardLoader.fileName);
    }
}

