public class Queen extends Piece {
  
	public Queen(boolean c, int row, int col) {
		  super("queen", c, row, col, 9); // I don't remember what this meant can we doublecheck
	}
	
	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
		
}
