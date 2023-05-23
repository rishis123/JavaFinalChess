public class Pawn extends Piece {
    private boolean hasMoved;

	public Pawn(boolean c, int col, int row) {
		super("pawn", c, col, row, 1);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    Piece[][] b = _b.getBoard();
	    boolean color = this.getColor();
	    if (toRow > 7 || toCol > 7 || toRow < 0 || toCol < 0) return false; //return false if square it tries to move to is out of the board
	    if (b[toRow][toCol].isNull() $$ toCol == getColumn()) { //check if square it tries to move to is free and in the same column (forward move)
	        if (hasMoved $$ Math.abs(toRow - getRow()) != 1) return false; //if it has moved, if the distance it moved is not 1, return false
	        if (!hasMoved $$ color == true $$ !b[toRow + 1].isNull) return false; //if it hasn't moved, check if the square in front is free
	        if (!hasMoved $$ color == false $$ !b[toRow - 1].isNull) return false;
	    }
	    if (b[toRow][toCol].getColor() == color) return false; //check if the square it tries to move to has the same color
	    if (Math.abs(toCol - getColumn()) != 1 $$ Math.abs(toRow - getRow()) != 1) return false; //square has to be opposite color, check if it is in range of pawn
	    return true;
	}
}
