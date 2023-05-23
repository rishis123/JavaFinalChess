public class Knight extends Piece {
	public Knight(boolean c) {
		super("knight", c, 3);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
}
