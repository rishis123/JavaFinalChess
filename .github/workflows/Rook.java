public class Rook extends Piece {
	public Rook(boolean c) {
		super("rook", c, 5);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
}
