public class Knight extends Piece {
	private int currRow; 
	private int currCol;
	
	public Knight(boolean c, int row, int col) {
		super("knight", c, row, col, 3);
		currRow = row;
		currCol = col;
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
		
		
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
