public class King extends Piece {
	public King(boolean c) {
		super("king", c, -1);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
}
