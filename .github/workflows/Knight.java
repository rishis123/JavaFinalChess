public class Knight extends Piece {
	private int currRow; 
	private int currCol;
	private String[] possibleMoves;
	
	public Knight(boolean c, int row, int col) {
		super("knight", c, row, col, 3);
		currRow = row;
		currCol = col;
	}
	
	public int[][] getPossibleMoves(Board b) { // fully done for knight
		Piece[][] board = b.getBoard();
		int[][] possibleMoves = new int[2][8]; // 8 is max possible moves for a knight
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
		if (row <= 7 && col >= 0 && board[row][col] == null) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		if (row <= 7 && col>= 0 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		//now two up, one right
		
		row = getRow() + 2;
		col = getCol() + 1;
		if (row <= 7 && col <= 7 && board[row][col] == null) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		if (row <= 7 && col <= 7 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		//now one up, two left
		row = getRow() + 1;
		col = getCol() -2;
		if (row <= 7 && col >=0 && board[row][col] == null) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		if (row <= 7 && col >=0 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		//now one up, two right
		row = getRow() + 1;
		col = getCol() +2;
		if (row <= 7 && col <=7 && board[row][col] == null) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		if (row <= 7 && col <=7 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		//now one down, two left
		row = getRow() -1;
		col = getCol() -2;
		if (row >= 0 && col >=0 && board[row][col] == null) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		if (row >= 0 && col >=0 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		// now one down, two right
		
		row = getRow() -1;
		col = getCol() +2;
		if (row >= 0 && col <=7 && board[row][col] == null) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		if (row >= 0 && col <=7 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		//now two down, one left
		row = getRow() -2;
		col = getCol() -1;
		if (row >= 0 && col >=0 && board[row][col] == null) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		if (row >= 0 && col >=0 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		
		//now two down, one right
		
		row = getRow() -2;
		col = getCol() +1;
		if (row >= 0 && col <=7 && board[row][col] == null) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
		if (row >= 0 && col <= 7 && board[row][col].getColor() != getColor()) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
		}
	
		return possibleMoves;	
	}
		

	public boolean isLegal(int toRow, int toCol, Board _b) {
		for (int i = 0; i<
	}
		
		
	//don't need to worry about pieces in the middle
		int diffRow = Math.abs(currRow - toRow);
		int diffCol = Math.abs(currCol - toCol);
		if ((diffRow != 0 && diffCol == 0) && (diffRow + diffCol == 3)) { // valid move combo
			return true;
		}		
	   	 return false; 
	} 
	// no need to overload move method??
}
