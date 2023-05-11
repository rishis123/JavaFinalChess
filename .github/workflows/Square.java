package Game;

public class Square {
	private int letter; //0-7 is a-h
	private int number; //0-7 is 1-8
	private Piece piece;
	
	public Square(int l, int n, Piece p) {
		letter = l;
		number = n;
		piece = p;
	}
	
	//basic setters/getters
	public void setLetter(int l) {
		letter = l;
	}
	public void setNumber(int n) {
		number = n;
	}
	public void setPiece(Piece p) {
		piece = p;
	}
	public int getLetter() {
		return letter;
	}
	public int getNumber() {
		return number;
	}
	public Piece getPiece() {
		return piece;
	}
	
	public boolean isFilled() {
		if(piece == null) {
			return false;
		}
		else{
			return true;
		}
	}
}
