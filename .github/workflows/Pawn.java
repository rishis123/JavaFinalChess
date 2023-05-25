public class Pawn extends Piece {
    private boolean hasMoved;

	public Pawn(boolean c, int row, int col) {
		super("pawn", c, row, col, 1);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return true; // implement later en passant?
	}
}
