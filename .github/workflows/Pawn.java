/**This class implements pawn object, including method to get Possible Moves and pawn promotion
*/
public class Pawn extends Piece {
    private boolean hasMoved; // where do we use this?
 

	/**
	Constructs a pawn object
	
	@param c the color of the pawn
	@param row the row of the pawn
	@param col the column of the pawn
	
	*/
	public Pawn(boolean c, int row, int col) {
		super("pawn", c, row, col);
 	}

	/**
	Returns all possible moves for a pawn, in 2D array, with first row representing all possible move rows, and second row representing all possible move columns
	@param b the board of interest being passed in
	@return the 2D array described above
	
	
	*/
public int[][] getPossibleMoves(Board b) {
		Piece[][] board = b.getBoard();
		Board checkBoard = new Board(b.getBoard());;
		
		int[][] possibleMoves = new int[2][4]; // 4 is max possible for pawn, 1 forward, 2 forward if 2nd rank, then 2 captures
		for (int i = 0; i < possibleMoves[0].length; i++) {
			possibleMoves[0][i] = -1;
			possibleMoves[1][i] = -1;
 		}
		
		int row = getRow();
		int col = getCol();
		int i = 0;//counter
		
		if (!getColor()) {//color boolean, true is white, black is false -- need for pawn separation
			if (row == 1 && board[row+1][col] == null && board[row+2][col] == null) { // we are using 0-based indexing for rows and columns
				move(row+1, col, checkBoard);
				if (!Game.checkCheck(checkBoard, getColor())) {
					possibleMoves[0][i] = row + 2; // can move 2 spaces
					possibleMoves[1][i] = col;
					i++;
				}
				checkBoard.setBoard(b.getBoard());
			}
			if (row < 7 && board[row+1][col] == null) {
				move(row+1, col, checkBoard);
				if (!Game.checkCheck(checkBoard, getColor())) {
					possibleMoves[0][i] = row + 1; // can move 2 spaces
					possibleMoves[1][i] = col;
					i++;
				}
				checkBoard.setBoard(b.getBoard());
			}
			if (col < 7 && (board[row+1][col+1] != null || (board[row+1][col+1] != null && board[row+1][col+1].getColor() != getColor()))) { // capture
				move(row+1, col, checkBoard);
				if (!Game.checkCheck(checkBoard, getColor())) {
					possibleMoves[0][i] = row + 1; // can move 2 spaces
					possibleMoves[1][i] = col + 1;
					i++;
				}
				checkBoard.setBoard(b.getBoard());
			}
			if (col > 0 && (board[row+1][col-1] != null || (board[row+1][col-1] != null && board[row+1][col-1].getColor() != getColor()))) { // capture
				move(row+1, col, checkBoard);
				if (!Game.checkCheck(checkBoard, getColor())) {
					possibleMoves[0][i] = row + 1; // can move 2 spaces
					possibleMoves[1][i] = col - 1;
					i++;
				}
				checkBoard.setBoard(b.getBoard());
			}	
		}
		else { // pawn is black
		   if (row == 6 && board[row-1][col] == null && board[row-2][col] == null) { // we are using 0-based indexing for rows and columns
			   move(row+1, col, checkBoard);
				if (!Game.checkCheck(checkBoard, getColor())) {
					possibleMoves[0][i] = row - 2; // can move 2 spaces
					possibleMoves[1][i] = col;
					i++;
				}
				checkBoard.setBoard(b.getBoard());
			}
			if (row > 0 && board[row-1][col] == null) {
				move(row+1, col, checkBoard);
				if (!Game.checkCheck(checkBoard, getColor())) {
					possibleMoves[0][i] = row - 2; // can move 2 spaces
					possibleMoves[1][i] = col;
					i++;
				}
				checkBoard.setBoard(b.getBoard());
			}
			if (col < 7 && (board[row-1][col+1] != null || (board[row-1][col+1] != null && board[row-1][col+1].getColor() != getColor()))) { // capture
				move(row+1, col, checkBoard);
				if (!Game.checkCheck(checkBoard, getColor())) {
					possibleMoves[0][i] = row - 1; // can move 2 spaces
					possibleMoves[1][i] = col + 1;
					i++;
				}
				checkBoard.setBoard(b.getBoard());
			}
			if (col > 0 && (board[row-1][col-1] != null || (board[row-1][col-1] != null && board[row-1][col-1].getColor() != getColor()))) { // capture
				move(row+1, col, checkBoard);
				if (!Game.checkCheck(checkBoard, getColor())) {
					possibleMoves[0][i] = row - 1; // can move 2 spaces
					possibleMoves[1][i] = col - 1;
					i++;
				}
				checkBoard.setBoard(b.getBoard());
			}	
		}	
	return possibleMoves;
	}
	
	
	
	/**
	Overriden piece class' move method, specially made for pawn in case of promotion to queen -- if in final rank of respective color, replaces with Queen of same color
	@param toRow the final Row of queen
	@param toCol the final column of queen
	@param b the passed in board
	*/
	
	public void move(int toRow, int toCol, Board b) { 
		Piece p = b.getSquare(row, col);
		
		if (p.getColor() && row == 1 ) { // white piece, reach 0th rank to pawn promote
			b.setSquare(null, row, col);
			Queen qWhite = new Queen(p.getColor(), row,col ); // arbitrary initial position
			b.setSquare(qWhite, toRow, toCol);
			col = toCol;
			row = toRow;
		}
		
		if (!p.getColor() && row == 6 ) { // black piece, reach 7th rank to pawn promote -- note our graphics effectively is normal chessboard flipped
			b.setSquare(null, row, col);
			Queen qBlack = new Queen(p.getColor(), row,col ); // arbitrary initial position, as long as it is null
			b.setSquare(qBlack, toRow, toCol);
			col = toCol;
			row = toRow;
		}
		
		
		
	}
}
