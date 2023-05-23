package Game;

public abstract class Piece {
	private String name;
	private boolean color; //white is true, black is false
	private int value;
	private int row;
	private int column;
	
	public Piece(String n, boolean c, int col, int _row, int v) {
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
	
	//returns true if move is made, false if not, updates the row/col of piece object, mb change later?
	public boolean move(int toRow, int toCol, Board b) { // is toRow and toCol the final row or column or intiial
		if (isLegal(toRow, toCol, b)) {
			column = toCol;
			row = toRow;
			return true;
		}
		else {
			return false;
		}
	}
	
	//returns true if the move toRow, toCol is legal
	public abstract boolean isLegal(int toRow, int toCol, Board _b);
	
}
