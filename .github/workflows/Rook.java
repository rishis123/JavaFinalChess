/**
The rook class implements the rook piece, including methods to determine if a certain move is legal and to return a 2D array of all possible moves for the rook at each turn.
*/


public class Rook extends Piece {
	public Rook(boolean c, int row, int col) {
		super("rook", c, row, col);
	}
	
	/**
	Returns 2D array, with first row representing rows of all possible moves, and second row represents corresponding columns of all possible moves
	@param b the passed in board with our piece
	@return the 2D array described above.
	
	*/
	
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
		
		col = getCol() + 1;
		
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
