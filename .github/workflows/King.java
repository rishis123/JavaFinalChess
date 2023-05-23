public class King extends Piece {
	public King(boolean c, int row, int col) {
		super("king", c, row, col, -1);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
}
