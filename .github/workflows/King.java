public class King extends Piece {
	public King(boolean c, int row, int col) {
		super("king", c, row, col);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}

	public int[][] getPossibleMoves(Board _b) {
		Piece[][] board = _b.getBoard();
		int[][] possibleMoves = new int[2][8];
		int j = 0;
		for (int i = 0; i < possibleMoves[0].length; i++) {
			possibleMoves[0][i] = -1;
			possibleMoves[1][i] = -1;
		}
		
		int row = getRow();
		int col = getCol();
		
		return possibleMoves;
	}
}
