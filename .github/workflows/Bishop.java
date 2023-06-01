/**
Class implements bishop piece, including method to get all possible moves.
*/
public class Bishop extends Piece {
	public Bishop(boolean c, int row, int col) {
		super("bishop", c, row, col);
	}

	/**
	Returns possible moves for bishop object (see superclass method for specifics)
	@param b the passed in board
	@return the 2D array representing valid moves
	
	*/
	public int[][] getPossibleMoves(Board b) { // Finished for bishop
		Piece[][] board = b.getBoard();
		int[][] possibleMoves = new int[2][13]; // 13 is max possible # of moves for a bishop on a chessboard
		// significance of the 2 is that in the 2D array, the first row is for possible move row values, then second row is for column values
		for (int i = 0; i < possibleMoves[0].length; i++) {
			possibleMoves[0][i] = -1; // defaults all possible moves to -1
			possibleMoves[1][i] = -1;
 		}
		
		int row = getRow();
		int col = getCol(); // finds row, col of the bishop currently
		int i = 0;
		
		row--;
		col--; //checks moves in down-left diagonal
		while (row >= 0 && col >= 0 && board[row][col] == null) { // Check column up
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
			row--;
			col--;
		}
		
		//checks capture opportunities
		if (row >= 0 && col >= 0 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++; // note we don't test anymore since will stop once capture.
		}
		
		row = getRow() + 1; // go back to the original square, and we go up and right by one (we are looking at up-right diagonal)
		col = getCol() + 1;
		
		while (row <= 7 && col <= 7 && board[row][col] == null) { // Check column down
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
			row++;
			col++;
		}
		//capture piece functionality
		
		if (row <= 7 && col <= 7 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		row = getRow()-1; // now we look at down-right diagonal
		col = getCol() + 1; // one col to right
		
		while (col <= 7 && row >= 0 && board[row][col] == null) { // Check row right
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
			col++;
			row--;
		}
		if (col <= 7 && row >=0 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		row = getRow() + 1;
		col = getCol() - 1; // now we look at up-left diagonal
		
		while (col >= 0 && row<=7 && board[row][col] == null) { // Check row left
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
			col--;
			row++;
		}
		if (col >=0 && row <= 7 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
	
		return possibleMoves;	
	}
	
	
	
}
