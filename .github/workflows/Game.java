public class Game {
    private int result;
    private boolean move;
    private Board b;
    private int wKingx;
    private int wKingy;
    private int bKingx;
    private int bKingy;

    public Game(boolean _move) {
        move = _move;
        b = new Board();
    }

    public Game(boolean _move, Board _b) {
        move = _move;
        b = _b;
    }

    public boolean checkCheck() {
        return false; //implement later
    }

    public int checkMate() {
        result = 1;
        return result; //implement later
    }

    public int checkStaleMate() {
        return 0; //this will be hard to implement
    }
}