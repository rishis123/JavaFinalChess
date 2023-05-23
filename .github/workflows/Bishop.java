public class Bishop extends Piece {
	public Bishop(boolean c, int col, int row) {
		super("bishop", c, col, row, 3);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
}
