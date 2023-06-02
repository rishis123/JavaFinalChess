/**
The King class implements the king piece, including methods to return a 2D array of all possible moves for the king at each turn.
*/

public class King extends Piece {
	private boolean hasMoved;
	
	public King(boolean c, int row, int col) {
		super("king", c, row, col);
	}

	public boolean isLegal(int toRow, int toCol, Board _b) {
	    return false; // implement later
	}

	public void move(int toRow, int toCol, Board b) {
		Piece p = b.getSquare(getRow(), getCol());
	    b.setSquare(null, getRow(), getCol());
	    if(toCol - getCol() == 2) {
	    	b.getBoard()[getRow()][7].move(getRow(), 5, b);
	    }
	    if(toCol - getCol() == -2) {
	    	b.getBoard()[getRow()][0].move(getRow(), 3, b);
	    }
		setCol(toCol);
		setRow(toRow);
	    b.setSquare(p, getRow(), getCol());
	    hasMoved = true;
	}
	
	/** 
	returns all possible moves for the implicit parameter king object, with first row of 2D array representing all possible move rows, and second row representing corresponding move columns 
	@param b the explicitly passed in Board object containing the king
	@return 2D array described above
	
	
	*/
	public int[][] getPossibleMoves(Board b) {
		Piece[][] board = b.getBoard();
		int[][] possibleMoves = new int[2][8]; // 8 is max possible moves for a king
		for (int i = 0; i < possibleMoves[0].length; i++) {
			possibleMoves[0][i] = -1;
			possibleMoves[1][i] = -1;
 		}
		
		int row = getRow();
		int col = getCol();
		int i = 0;
		
		if(!hasMoved) {
			//kingside castling for black:
			if(!getColor() && board[0][5] == null && board[0][6] == null && board[0][7].getName().equals("rook") && !board[0][7].getColor()) {
				possibleMoves[0][i] = row;
				possibleMoves[1][i] = col + 2;
//				b.setSquare(null, 0, 7);
//				b.setSquare(new Rook(false, 0, 5), 0, 5);
//				b.getBoard()[0][7].move(0, 5, b);
				i++;
			}
			//kingside castling for white
			if(getColor() && board[7][5] == null && board[7][6] == null && board[7][7].getName().equals("rook") && board[7][7].getColor()) {
				possibleMoves[0][i] = row;
				possibleMoves[1][i] = col + 2;
//				b.setSquare(null, 7, 7);
//				b.setSquare(new Rook(true, 7, 5), 7, 5);
				i++;
			}
			//queenside castling for black:
			if(!getColor() && board[0][3] == null && board[0][2] == null && board[0][1] == null && board[0][0].getName().equals("rook") && !board[0][0].getColor()) {
				possibleMoves[0][i] = row;
				possibleMoves[1][i] = col - 2;
//				b.setSquare(null, 0, 0);
//				b.setSquare(new Rook(false, 0, 3), 0, 3);
				i++;
			}
			//queenside castling for white:
			if(getColor() && board[7][3] == null && board[7][2] == null && board[7][1] == null && board[7][0].getName().equals("rook") && board[7][0].getColor()) {
				possibleMoves[0][i] = row;
				possibleMoves[1][i] = col - 2;
//				b.setSquare(null, 0, 0);
//				b.setSquare(new Rook(false, 0, 3), 0, 3);
				i++;
			}
		}
		
		row = getRow() -1 ;
		if (row >= 0 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
//			hasMoved = true;
		}
		
		row = getRow() + 1;
		if (row <= 7 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
//			hasMoved = true;
		}
		
		row = getRow() -1;
		col = getCol() - 1;
		if (row >= 0 && col >= 0 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
//			hasMoved = true;
		}
		
		row = getRow() - 1;
		col = getCol() +1;
		if (row >= 0 && col <= 7 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
//			hasMoved = true;
		}
		
		row = getRow() + 1;
		col = getCol() -1;
		if (row <= 7 && col >=0 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
//			hasMoved = true;
		}
		row = getRow() + 1;
		col = getCol() + 1;
		if (row <= 7 && col <=7 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
//			hasMoved = true;
		}
		
		row = getRow();
		col = getCol() + 1;
		if (col <= 7 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
//			hasMoved = true;
		}
		
		col = getCol() -1;
		if (col >= 0 && (board[row][col] == null || (board[row][col].getColor() != getColor()))) {
			possibleMoves[0][i] = row;
			possibleMoves[1][i] = col;
			i++;
//			hasMoved = true;
		}

		return possibleMoves;
		
	}
}
