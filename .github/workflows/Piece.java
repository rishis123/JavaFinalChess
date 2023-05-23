public abstract class Piece {
	private String name;
	private boolean color; //white is true, black is false
	private int value;
	private int row;
	private int column;
	
	public Piece(String n, boolean c, int _row, int col, int v) {
		name = n;
		color = c;
		value = v;
		row = _row;
		column = col;
	}
	
	//basic setters/getters

	public String getName() {
		return name;
	}
	public boolean getColor() {
		return color;
	}
	public int getValue() {
		return value;
	}
	public int getColumn() {
	    return column;
	}
	public int getRow() {
	    return row;
	}
	
	//returns true if move is made, false if not, updates the row/col of piece object, mb change later?
	public boolean move(int toRow, int toCol, Board b) { // is toRow and toCol the final row or column or intiial
		if (isLegal(toRow, toCol, b)) {
		    Piece p = b[row][column];
		    b[row][column] == null;
		    b[toRow][toCol] == p;
			column = toCol;
			row = toRow;
			return true;
		}
		else {
			return false;
		}
	}
	
	//returns true if the move toRow, toCol is legal
	public boolean isLegal(int toRow, int toCol, Board _b);
	
}
