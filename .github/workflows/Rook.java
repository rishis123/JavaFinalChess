public class Rook extends Piece {
	public Rook(boolean c, row, col) {
		super("rook", c, row, col, 5);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
}
