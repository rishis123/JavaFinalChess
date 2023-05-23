public class Queen extends Piece {
  
	public Queen(boolean c) {
		  super("queen", c, 9); // I don't remember what this meant can we doublecheck
	}
	
	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}
		
}
