/**
Implements a knight piece and finds all possible moves for it.
*/
public class Knight extends Piece {
	private int currRow; 
	private int currCol;
	private String[] possibleMoves;
	
	/**
	Constructs a knight object
	@param c the color of the knight
	@param row the row of the knight
	@param col the column of the knight
	*/
	public Knight(boolean c, int row, int col) {
		super("knight", c, row, col);
		currRow = row;
		currCol = col;
	}
	
	/**
	Returns all possible moves for knight (see superclass method for further details)
	@param b the board passed in
	@return the 2D array representing all possible moves.
	*/
	public int[][] getPossibleMoves(Board b) { 
		Piece[][] board = b.getBoard();
		int[][] possibleMoves = new int[2][8]; // 8 is max possible moves for a knight in middle of board
		for (int i = 0; i < possibleMoves[0].length; i++) {
			possibleMoves[0][i] = -1;
			possibleMoves[1][i] = -1;
 		}
		
		int row = getRow();
		int col = getCol();
		int i = 0;
		
		//Let's start with the two up, one left, using if functionality since don't need while to go through
		row = row + 2;
		col = col-1;
		if (row <= 7 && col >= 0 && (board[row][col] == null || board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		//now two up, one right
		
		row = getRow() + 2;
		col = getCol() + 1;
		if (row <= 7 && col <= 7 && (board[row][col] == null || board[row][col].getColor() != getColor()) ) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}

		
		//now one up, two left
		row = getRow() + 1;
		col = getCol() -2;
		if (row <= 7 && col >=0 && (board[row][col] == null || board[row][col].getColor() != getColor()) ) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		//now one up, two right
		row = getRow() + 1;
		col = getCol() +2;
		if (row <= 7 && col <=7 && (board[row][col] == null || board[row][col].getColor() != getColor()) ) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		//now one down, two left
		row = getRow() -1;
		col = getCol() -2;
		if (row >= 0 && col >=0 && (board[row][col] == null || board[row][col].getColor() != getColor() ) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		// now one down, two right
		
		row = getRow() -1;
		col = getCol() +2;
		if (row >= 0 && col <=7 && (board[row][col] == null ||board[row][col].getColor() != getColor()) ) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		//now two down, one left
		row = getRow() -2;
		col = getCol() -1;
		if (row >= 0 && col >=0 && (board[row][col] == null ||board[row][col].getColor() != getColor()) ) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		//now two down, one right
		
		row = getRow() -2;
		col = getCol() +1;
		if (row >= 0 && col <=7 && (board[row][col] == null || board[row][col].getColor() != getColor()) ) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
	
		return possibleMoves;	
	}
		

	 
}
