/**
This class creates a piece with a given name, row and column on a board, and has several methods to get/set those values, determine the legality of moves, etc.
*/
public abstract class Piece {
	private String movesList[];
	private String name;
	private boolean color; //white is true, black is false
	private int row;
	private int col;
	
	/**
	Construct a piece object
	@param n the name of the object
	@param c the color of the object
	@param _row the row of the object
	@param _col the column of the object
	*/
	public Piece(String n, boolean c, int _row, int _col) {
		name = n;
		color = c;
		row = _row;
		col = _col;
	}
	
/**
return name of piece
@return see above
*/
	public String getName() {
		return name;
	}
	/**
	return color of piece
	@return true is white, false is black
	*/
	public boolean getColor() {
		return color;
	}
	

	/**
	return column of piece
	@return see above
	*/
	public int getCol() {
	    return col;
	}
	/**
	return row of piece
	@return see above
	*/
	public int getRow() {
	    return row;
	}
	/**
	set column to inputted value
	@param c the desired column
	*/
	public void setCol(int c) {
		col = c;
	}
	/**
	set row to inputted value
	@param r the desired row
	*/
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
	makes a move on the board by moving the piecce to the square (toRow, toCol), and setting the square it came from to null
	@param toRow the row for the piece to move to
	@param c the column for the piece to move to
	@param b the passed in board
	@return whether or not the move is in the array
	*/
	
	public void move(int toRow, int toCol, Board b) { 
		Piece p = b.getSquare(row, col);
		b.setSquare(null, row, col);
		b.setSquare(p, toRow, toCol);
		col = toCol;
		row = toRow;
	}
	/**
	
	*/
	
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
