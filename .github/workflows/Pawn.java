/**This class implements pawn object, including method to get Possible Moves and pawn promotion
*/
public class Pawn extends Piece {
    private boolean hasMoved; // where do we use this?
	private boolean c;


	/**
	Constructs a pawn object
	
	@param c the color of the pawn
	@param row the row of the pawn
	@param col the column of the pawn
	
	*/
	public Pawn(boolean c, int row, int col) {
		super("pawn", c, row, col);
		this.c = c;
	}

	/**
	Returns all possible moves for a pawn, in 2D array, with first row representing all possible move rows, and second row representing all possible move columns
	@param b the board of interest being passed in
	@return the 2D array described above
	
	
	*/
	public int[][] getPossibleMoves(Board b) {
		Piece[][] board = b.getBoard();
		int[][] possibleMoves = new int[2][4]; // 4 is max possible for pawn, 1 forward, 2 forward if 2nd rank, then 2 captures
		for (int i = 0; i < possibleMoves[0].length; i++) {
			possibleMoves[0][i] = -1;
			possibleMoves[1][i] = -1;
 		}
		
		int row = getRow();
		int col = getCol();
		int i = 0;//counter
		
		if (c) {//color boolean, true is white, black is false -- need for pawn separation
			if (row == 1 && board[row+1][col] == null && board[row+2][col] == null) { // we are using 0-based indexing for rows and columns
			    possibleMoves[0][i] = row + 2; // can move 2 spaces
			    possibleMoves[1][i] = col;
			    i++;
			}
			if (row < 7 && board[row+1][col] == null) {
			    possibleMoves[0][i] = row+1; // figure out pawn promotion
			    possibleMoves[0][i] = col;
			    i++;
			}
			if (col < 7 && (board[row+1][col+1] != null || board[row+1][col+1].getColor() != getColor())) { // capture
			   possibleMoves[0][i] = row+1; 
			    possibleMoves[0][i] = col+1;
			    i++;
			}
			if (col > 0 && (board[row+1][col-1] != null || board[row+1][col-1].getColor() != getColor())) { // capture
			   possibleMoves[0][i] = row+1; 
			    possibleMoves[0][i] = col-1;
			    i++;
			}	
		}
		else { // pawn is black
		   if (row == 6 && board[row-1][col] == null && board[row-2][col] == null) { // we are using 0-based indexing for rows and columns
			    possibleMoves[0][i] = row -2; // can move 2 spaces
			    possibleMoves[1][i] = col;
			    i++;
			}
			if (row > 0 && board[row-1][col] == null) {
			    possibleMoves[0][i] = row-1; // figure out pawn promotion
			    possibleMoves[0][i] = col;
			    i++;
			}
			if (col < 7 && (board[row-1][col+1] != null || board[row-1][col+1].getColor() != getColor())) { // capture
			   possibleMoves[0][i] = row-1; 
			    possibleMoves[0][i] = col+1;
			    i++;
			}
			if (col > 0 && (board[row-1][col-1] != null || board[row-1][col-1].getColor() != getColor())) { // capture
			   possibleMoves[0][i] = row-1; 
			    possibleMoves[0][i] = col-1;
			    i++;
			}	
		
		}

	
		
	return possibleMoves;
	}
	
	
	/** 
	This method promotes a white pawn in our 7th row or a black pawn in our 0th row to a same-colored queen, overwrites the pawn reference
	// work in progress
	
	*/
	public void pawnPromote() {
	 if (c) { // white pawn in 7th row
	 	 
		
		 
		 
		
		
	}
}
