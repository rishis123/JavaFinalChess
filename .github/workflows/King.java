public class King extends Piece {
	public King(boolean c, int row, int col) {
		super("king", c, row, col);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}

	public int[][] getPossibleMoves(Board b) {
		return null; //implement later
	}
}
