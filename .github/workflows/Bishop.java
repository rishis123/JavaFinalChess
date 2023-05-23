public class Bishop extends Piece {
	public Bishop(boolean c, int row, int col) {
		super("bishop", c, row, col, 3);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
}
