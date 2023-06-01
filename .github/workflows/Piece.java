public abstract class Piece {
	private String movesList[];
	private String name;
	private boolean color; //white is true, black is false
	private int row;
	private int col;
	
	public Piece(String n, boolean c, int _row, int _col) {
		name = n;
		color = c;
		row = _row;
		col = _col;
	}
	
	//basic setters/getters

	public String getName() {
		return name;
	}
	public boolean getColor() {
		return color;
	}
//removed value - no point
	public int getCol() {
	    return col;
	}
	public int getRow() {
	    return row;
	}
	public void setCol(int c) {
		col = c;
	}
	public void setRow(int r) {
		row = r;
	}
	
	/**
	returns 2D array of all possible moves for piece of interest, with first row representing all possible move-rows and second row representing all possible move-columns
	@param b the passed in board
	@return the 2D array described above
	*/
	public abstract int[][] getPossibleMoves(Board b);
	
	/**
	returns true if an inputted move is in the 2D array from getPossibleMoves, else returns false and is invalid
	@param r the row for the piece to move to
	@param c the column for the piece to move to
	@param b the passed in board
	@return whether or not the move is in the array
	*/
	public boolean inPossibleMoves(int r, int c, Board b) {
		int[][] possibleMoves = getPossibleMoves(b);
		int i = 0;
		while (i < possibleMoves[0].length && possibleMoves[0][i] != -1) {
			if (possibleMoves[0][i] == r && possibleMoves[1][i] == c) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	//returns true if move is made, false if not, updates the row/col of piece object, mb change later?
	public boolean move(int toRow, int toCol, Board b) { // is toRow and toCol the final row or col or intiial
		if (isLegal(toRow, toCol, b)) {
		    Piece p = b.getSquare(row, col);
		    b.setSquare(null, row, col);
		    b.setSquare(p, row, col);
			col = toCol;
			row = toRow;
			return true;
		}
		else {
			return false;
		}
	}
}
