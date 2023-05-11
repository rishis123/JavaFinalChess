package Game;

public class Move {
	private Square from;
	private Square to;
	private Piece piece;
	
	public Move(Square f, Square t) {
		from = f;
		to = t;
		piece = f.getPiece();
	}
	
	//basic setters/getters
	public void setFrom(Square f) {
		from = f;
	}
	public void setTo(Square t) {
		to = t;
	}
	public Square getfrom() {
		return from;
	}
	public Square getTo() {
		return to;
	}
	public Piece getPiece() {
		return piece;
	}
	
	public boolean isLegal() {
		if((from.getLetter() < 0 || from.getLetter() > 7) || (from.getNumber() < 0 || from.getNumber() > 7)) {
			return false;
		}
		if((to.getLetter() < 0 || to.getLetter() > 7) || (to.getNumber() < 0 || to.getNumber() > 7)) {
			return false;
		}
		if(piece.getName() == "pawn") {
			if(from.getNumber() == 0 || from.getNumber() == 7) {
				return false;
			}
			if(to.getNumber() == 0 || to.getNumber() == 7) {
				return false;
			}
			//a lot of repetitive code in here
			//also need to add in en passant capability down the road
			if(piece.getColor() == true) {
				if(from.getLetter() == to.getLetter()) {
					if(from.getNumber() == to.getNumber() - 1) {
						return true;
					}
					else if(from.getNumber() == to.getNumber() - 2) {
						if(from.getNumber() == 1) {
							//if from plusOne and from plusTwo !.isFilled, return true, otherwise, return false
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else if(Math.abs(from.getLetter() - to.getLetter()) == 1) {
					if(from.getNumber() == to.getNumber() - 1) {
						return true;
					}
				}
				else {
					return false;
				}
			}
			if(piece.getColor() == false) {
				//again, there's a good amount of duplicate code, any way to cleanly reduce code here?
				if(from.getLetter() == to.getLetter()) {
					if(from.getNumber() == to.getNumber() - 1) {
						return true;
					}
					else {
						return false;
					}
				}
				else if(Math.abs(from.getLetter() - to.getLetter()) == 1) {
					
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
}
