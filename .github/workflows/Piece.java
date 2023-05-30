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
	
	//returns true if the move toRow, toCol is legal
	public abstract boolean isLegal(int toRow, int toCol, Board _b);
	public abstract int[][] getPossibleMoves(Board b);
	
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
