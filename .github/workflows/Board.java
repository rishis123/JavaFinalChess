package Game;

public class Board {
	private Piece[][] board; //rows are letters, columns are numbers; top left is a8, bottom right is h1
	
	public Board() {
		board = new Piece[8][8];
		for(int i = 0; i < 8; i++) {
			board[7][i] = new Pawn(true);
			board[1][i] = new Pawn(false);
			
			if(i == 0 || i == 7) {
				board[7][i] = new Rook(true);
				board[1][i] = new Rook(false);
			}
			if(i == 1 || i == 6) {
				board[7][i] = new Knight(true);
				board[1][i] = new Knight(false);
			}
			if(i == 2 || i == 5) {
				board[7][i] = new Bishop(true);
				board[1][i] = new Bishop(false);
			}
			if(i == 3) {
				board[7][i] = new Queen(true);
				board[1][i] = new Queen(false);
			}
			if(i == 4) {
				board[7][i] = new King(true);
				board[1][i] = new King(false);
			}
		}
	}
	
	public Piece[][] getBoard(){
		return board;
	}
}
