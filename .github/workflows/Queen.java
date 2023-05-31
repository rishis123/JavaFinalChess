public class Queen extends Piece {
  
	public Queen(boolean c, int row, int col) {
		  super("queen", c, row, col); // I don't remember what this meant can we doublecheck
	}
	
	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
	
	public int[][] getPossibleMoves(Board b) {
		Piece[][] board = b.getBoard();
		int[][] possibleMoves = new int[2][27]; // 27 is max possible moves for a queen
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
		//functionality from rook class over
		
		
		
		row = getRow() -1;
		col = getCol() -1;
		while (row >= 0 && col >= 0 && board[row][col] == null) { // Check down-left diagonal
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
