public class TestClassA3 {

    private static final int pauseTime = 3000;

    public static void main(String[] args) {

        // I usually just comment these out as I need them / don' need them.
        // it can be hard to tell what is being tested!
        // This is all just provided as an example, you should be testing your own code yourself.
        // And providing the test class as part of the hand in package.

        testBoardLoader(); //tests the BoardLoader

    }

    public static void testBoardLoader(){
        Board b =new Board();
        b.drawBoard();
        BoardLoader.loadBoardState(b,BoardLoader.folder + BoardLoader.fileName);
    }

}

