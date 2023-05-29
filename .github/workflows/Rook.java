public class Rook extends Piece {
	public Rook(boolean c, row, col) {
		super("rook", c, row, col, 5);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
		boolean found = false;
		int i = 0;
		int[][] possibleMoves = getPossibleMoves(_b);
	   	while (!found && i < possibleMoves[0].length) {
			if (possibleMoves[0][i] == toRow && possibleMoves[1][i] == toCol) { return true; }
			else { return false; }
		}
	}
	
	public int[][] getPossibleMoves(Board b) {
		Piece[][] board = b.getBoard();
		int[][] possibleMoves = new int[2][14];
		for (int i = 0; i < possibleMoves[0].length; i++) {
			possibleMoves[0][i] = -1;
			possibleMoves[1][i] = -1;
 		}
		
		int row = getRow();
		int col = getCol();
		int i = 0;
		
		row--;
		while (row >= 0 && board[row][col] == null) { // Check column up
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
			row--;
		}
		if (row >= 0 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		row = getRow() + 1;
		
		while (row <= 7 && board[row][col] == null) { // Check column down
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
			row++;
		}
		if (row <= 7 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		row = getRow();
		col--;
		
		while (col >= 0 && board[row][col] == null) { // Check row right
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
			col--;
		}
		if (col >= 0 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		col = getColumn() + 1;
		
		while (col <= 7 && board[row][col] == null) { // Check row left
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
			col++;
		}
		if (col <= 7 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
	
		return possibleMoves;	
	}
}
