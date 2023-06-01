public class King extends Piece {
	public King(boolean c, int row, int col) {
		super("king", c, row, col);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}

	public int[][] getPossibleMoves(Board b) {
		Piece[][] board = b.getBoard();
		int[][] possibleMoves = new int[2][8]; // 8 is max possible moves for a king
		for (int i = 0; i < possibleMoves[0].length; i++) {
			possibleMoves[0][i] = -1;
			possibleMoves[1][i] = -1;
 		}
		
		int row = getRow();
		int col = getCol();
		int i = 0;
		
		row = getRow() -1 ;
		if (row >= 0 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		row = getRow() + 1;
		if (row <= 7 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		row = getRow() -1;
		col = getCol() - 1;
		if (row >= 0 && col >= 0 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		row = getRow() - 1;
		col = getCol() +1;
		if (row >= 0 && col <= 7 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		row = getRow() + 1;
		col = getCol() -1;
		if (row <= 7 && col >=0 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		row = getRow() + 1;
		col = getCol() + 1;
		if (row <= 7 && col <=7 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		row = getRow();
		col = getCol() + 1;
		if (col <= 7 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		col = getCol() -1;
		if (col >= 0 && (board[row][col] == null || (board[row][col].getColor() ! = getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}

		return possibleMoves;
		
	}
}
