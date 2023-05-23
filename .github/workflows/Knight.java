public class Knight extends Piece {
	public Knight(boolean c, int row, int col) {
		super("knight", c, row, col, 3);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
}
