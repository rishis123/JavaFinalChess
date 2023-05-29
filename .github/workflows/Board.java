public class Board {
	private Piece[][] board; //rows are letters, columns are numbers; top left is a8, bottom right is h1
	
	public Board() {
		board = new Piece[8][8];
		for(int i = 0; i < 8; i++) {
			board[7][i] = new Pawn(true, 6, i);
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
	
	public Piece[][] getBoard(){
		return board;
	}
	
	public void setSquare(Piece p, int row, int col) {
		board[row][col] = p;
	}
	
	public Piece getSquare(int r, int c) {
		return board[r][c];
	}
}
