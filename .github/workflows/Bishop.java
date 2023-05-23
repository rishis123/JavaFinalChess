public class Bishop extends Piece {
	public Bishop(boolean c) {
		super("bishop", c, 3);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
}
