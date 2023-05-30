import java.util.ArrayList;

public class Board {
	private Piece[][] board; //rows are letters, columns are numbers; top left is a8, bottom right is h1
	
	public Board() {
		board = new Piece[8][8];
		for(int i = 0; i < 8; i++) {
			board[i][6] = new Pawn(true, i, 6);
			board[i][1] = new Pawn(false, i, 1);
			
			if(i == 0 || i == 7) {
				board[i][7] = new Rook(true, i, 7);
				board[i][0] = new Rook(false, i, 0);
			}
			if(i == 1 || i == 6) {
				board[i][7] = new Knight(true, i, 7);
				board[i][0] = new Knight(false, i, 0);
			}
			if(i == 2 || i == 5) {
				board[i][7] = new Bishop(true, i, 7);
				board[i][0] = new Bishop(false, i, 0);
			}
			if(i == 3) {
				board[i][7] = new Queen(true, i, 7);
				board[i][0] = new Queen(false, i, 0);
			}
			if(i == 4) {
				board[i][7] = new King(true, i, 7);
				board[i][0] = new King(false, i, 0);
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

