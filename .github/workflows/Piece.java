package Game;

public class Piece {
	private String name;
	private boolean color; //white is true, black is false
	private int value;
	
	public Piece(String n, boolean c, int v) {
		name = n;
		color = c;
		value = v;
	}
	
	//basic setters/getters
	public void setName(String n) {
		name = n;
	}
	public void setColor(boolean c) {
		color = c;
	}
	public void setValue(int v) {
		value = v;
	}
	public String getName() {
		return name;
	}
	public boolean getColor() {
		return color;
	}
	public int getValue() {
		return value;
	}
}
