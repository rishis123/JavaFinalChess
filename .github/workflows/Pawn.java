public class Pawn extends Piece {
    private boolean hasMoved;

	public Pawn(boolean c, int row, int col) {
		super("pawn", c, row, col, 1);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return true; // implement later en passant?
	}
	
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
		
		if (getColor()) {//color boolean, true is white, black is false -- need for pawn separation
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
			if (board[row+1][col+1] != null && board[row+1][col+1].getColor() != getColor()) { // capture
			   possibleMoves[0][i] = row+1; 
			    possibleMoves[0][i] = col+1;
			    i++;
			}
			if (board[row+1][col-1] != null && board[row+1][col-1].getColor() != getColor()) { // capture
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
			if (board[row-1][col+1] != null && board[row-1][col+1].getColor() != getColor()) { // capture
			   possibleMoves[0][i] = row-1; 
			    possibleMoves[0][i] = col+1;
			    i++;
			}
			if (board[row-1][col-1] != null && board[row-1][col-1].getColor() != getColor()) { // capture
			   possibleMoves[0][i] = row-1; 
			    possibleMoves[0][i] = col-1;
			    i++;
			}	
		
		}

		if (getColor() && row == 7) { // white pawn promotion
		   pawnPromote(); // write new method
		}
		if (!getColor() && row == 0) {//black pawn promotion
	           pawnPromote(); //write new method
		}
		
	return possibleMoves;
	}
	
}
