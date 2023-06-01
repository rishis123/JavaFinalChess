import java.util.ArrayList;
/**
Make a board object, with all pieces inputted and methods to get the board, set particular square values, etc.
*/
public class Board {
	private Piece[][] board; //rows are letters, columns are numbers; top left is a8, bottom right is h1
	
	public Board(Piece[][] b) {
		board = b;
	}
	/**
	Construct a board, assign pieces to initial positions
	*/
	public Board() {
		board = new Piece[8][8];
		for(int i = 0; i < 8; i++) {
			board[6][i] = new Pawn(true, 6, i);
			board[1][i] = new Pawn(false, 1, i);
			
			if(i == 0 || i == 7) {
				board[7][i] = new Rook(true, 7, i);
				board[0][i] = new Rook(false, 0, i);
			}
			if(i == 1 || i == 6) {
				board[7][i] = new Knight(true, 7, i);
				board[0][i] = new Knight(false, 0, i);
			}
			if(i == 2 || i == 5) {
				board[7][i] = new Bishop(true, 7, i);
				board[0][i] = new Bishop(false, 0, i);
			}
			if(i == 3) {
				board[7][i] = new Queen(true, 7, i);
				board[0][i] = new Queen(false, 0, i);
			}
			if(i == 4) {
				board[7][i] = new King(true, 7, i);
				board[0][i] = new King(false, 0, i);
			}
		}
	
	}
	/**
	returns the board, note board[rows][columns] is the format we are using
	@return the board
	*/
	public Piece[][] getBoard(){
		return board;
	}
	
	/**
 	Sets a position on 2D array to an inputted piece -- useful in the swaps for capturing, castling, and pawn promotion. 
 	@param p the piece that you want to replace existing piece with
 	@param row the row value of the replacing piece (note: 0-based indexing)
 	@param col the column value of the replacing piece (note: again 0-based indexing
 	
 	*/

	public void setSquare(Piece p, int row, int col) {
		board[row][col] = p;
	}
	/**
 	Sets the board instance variable to an already made Piece array -- useful for checking for check. 
 	@param b the Piece array being passed in
 	
 	*/
	public void setBoard(Piece[][] b) {
		board = b;
	}
	/**
 	Returns the piece at a specified square / position in the 2D array
 	
 	@param r the row value of the specific piece, as seen in 2D array
 	@param c the column value of the same piece.
 	
 	*/
	public Piece getSquare(int r, int c) {
		return board[r][c];
	}
	/**
	What does this do?
	*/
	public ArrayList<Piece> pieces() {
		ArrayList<Piece> p = new ArrayList<Piece>();
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if(board[r][c] != null) {
					p.add(board[r][c]);
				}
			}
		}
		return p;
	}
}

