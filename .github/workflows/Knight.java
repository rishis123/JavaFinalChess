public class Knight extends Piece {
	private int currRow; 
	private int currCol;
	private String[] possibleMoves;
	
	public Knight(boolean c, int row, int col) {
		super("knight", c, row, col, 3);
		currRow = row;
		currCol = col;
	}
	
	public int[][] getPossibleMoves(Board b) {
		Pieces[][] board = b.getBoard();
		int[][] possibleMoves = new int[2][8]; //rishi i started it for you, just fill this array w/ all the possible moves. row 0 is the row, row 1 is the column.
		for(int i = 0; i < possibleMoves[0].length; i++) {
			possibleMoves[0][i] = -1;
			possibleMoves[1][i] = -1;
		}			
		
		// include all the 2s, then 1s, don't need 1s and 2s again since double counting
		
		//
		
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
