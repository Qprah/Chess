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





    }
    //tests the queen
    public static void testQ(){

    }

    public static void testBoardLoader(){
        Board b =new Board();
        b.drawBoard();
        BoardLoader.loadBoardState(b,BoardLoader.folder + BoardLoader.fileName);
    }

    // Should be a board with one red and one black tile in the corners (see images. )
//    public static void phase1() {
//        Board b = new Board();
//
//        System.out.println("Attempt 1 - Error - No Tiles: ");
//        b.drawBoard();
//        b.drawPiece(1, 1);
//        b.drawPiece(6, 6);
//
//
//        // This should fail since there is no pieces on the board yet and drawPiece draws the piece.
//        try {
//            System.out.println("Attempt 2 - (1,1) (6,6) Corner Tiles: OOPS - it should be BLACK or Board.black, not Black ");
//            b.setPiece(1, 1, new Pawn("Pawn1", "Black", b));
//            b.setPiece(6, 6, new Pawn("Pawn2", "Whites", b));
//            b.drawPiece(1, 1);
//            b.drawPiece(6, 6);
//        } catch (Exception e) {
//            System.out.println(e);
//            e.printStackTrace();
//        }
//
//
//        b.setPiece(1, 1, new Pawn("Pawn3", "BLACK", b));
//        b.setPiece(6, 6, new Pawn("Pawn4", "WHITE", b));
//        b.drawPiece(1, 1);
//        b.drawPiece(6, 6);
//
//        b.setPiece(2, 2, new Pawn("Pawn5", "BLACK", b));
//        b.setPiece(5, 5, new Pawn("Pawn6", "WHITE", b));
//        b.drawPieces();
//
//    }
}

