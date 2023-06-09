
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.applet.Applet;


public class ChessBoardDisplay {
	private static Board b = new Board();
	private static ArrayList<Piece> p = b.pieces();
	private static Piece m = null;
	private static int[] selected = {-1, -1};
	private static boolean toggleTurn = true;
	
	
	/**
	Returns piece at a specific (x,y) coordinate by finding corresponding (row,col) on grid
	
	@param x the potential piece's  x-coordinate.
	@param y the potential piece's y-coordinate.
	@return the piece at the specified coordinates
	*/
	public static Piece getPiece(int x, int y) {
		int col = x / 60;
		int row = y / 60;
		for(Piece el : p) {
			if(el.getRow() == row && el.getCol() == col) {
				return el;
			}
		}
		return null;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setTitle("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setUndecorated(true);
		
		BufferedImage whitePawn = ImageIO.read(ChessBoardDisplay.class.getResource("whitePawn.png"));
		BufferedImage blackPawn = ImageIO.read(ChessBoardDisplay.class.getResource("blackPawn.png"));
		BufferedImage whiteRook = ImageIO.read(ChessBoardDisplay.class.getResource("whiteRook.png"));
		BufferedImage blackRook = ImageIO.read(ChessBoardDisplay.class.getResource("blackRook.png"));
		BufferedImage whiteKnight = ImageIO.read(ChessBoardDisplay.class.getResource("whiteKnight.png"));
		BufferedImage blackKnight = ImageIO.read(ChessBoardDisplay.class.getResource("blackKnight.png"));
		BufferedImage whiteBishop = ImageIO.read(ChessBoardDisplay.class.getResource("whiteBishop.png"));
		BufferedImage blackBishop = ImageIO.read(ChessBoardDisplay.class.getResource("blackBishop.png"));
		BufferedImage whiteKing = ImageIO.read(ChessBoardDisplay.class.getResource("whiteKing.png"));
		BufferedImage blackKing = ImageIO.read(ChessBoardDisplay.class.getResource("blackKing.png"));
		BufferedImage whiteQueen = ImageIO.read(ChessBoardDisplay.class.getResource("whiteQueen.png"));
		BufferedImage blackQueen = ImageIO.read(ChessBoardDisplay.class.getResource("blackQueen.png"));

//		Board b = new Board();
		
		JPanel panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				for(int i = 0; i < 480; i += 60) {
					for(int j = 0; j < 480; j += 60) {
						if(i % 120 == 60 && j % 120 == 0) {
							g.setColor(Color.DARK_GRAY);
							g.fillRect(i, j, 60, 60);
						}
						else if(i % 120 == 0 && j % 120 == 60) {
							g.setColor(Color.DARK_GRAY);
							g.fillRect(i, j, 60, 60);
						}
						else {
							g.setColor(Color.LIGHT_GRAY);
							g.fillRect(i, j, 60, 60);
						}
					}
				}
				
//				System.out.println(p.toString());
				for(Piece el : p) {
					if(el.getName().equals("pawn")) {
						if(el.getColor()) { //white pawns
							g.drawImage(whitePawn, el.getCol() * 60, el.getRow() * 60, this);
						}
						if(!el.getColor()) { //black pawns
							g.drawImage(blackPawn, el.getCol() * 60, el.getRow() * 60, this);
						}
					}
					if(el.getName().equals("rook")) {
						if(el.getColor()) { //white rooks
							g.drawImage(whiteRook, el.getCol() * 60, el.getRow() * 60, this);
						}
						if(!el.getColor()) { //black rooks
							g.drawImage(blackRook, el.getCol() * 60, el.getRow() * 60, this);
						}
					}
					if(el.getName().equals("knight")) {
						if(el.getColor()) { //white knights
							g.drawImage(whiteKnight, el.getCol() * 60, el.getRow() * 60, this);
						}
						if(!el.getColor()) { //black knights
							g.drawImage(blackKnight, el.getCol() * 60, el.getRow() * 60, this);
						}
					}
					if(el.getName().equals("bishop")) {
						if(el.getColor()) { //white bishops
							g.drawImage(whiteBishop, el.getCol() * 60, el.getRow() * 60, this);
						}
						if(!el.getColor()) { //black bishops
							g.drawImage(blackBishop, el.getCol() * 60, el.getRow() * 60, this);
						}
					}
					if(el.getName().equals("king")) {
						if(el.getColor()) { //white kings
							g.drawImage(whiteKing, el.getCol() * 60, el.getRow() * 60, this);
						}
						if(!el.getColor()) { //black kings
							g.drawImage(blackKing, el.getCol() * 60, el.getRow() * 60, this);
						}
					}
					if(el.getName().equals("queen")) {
						if(el.getColor()) { //white queens
							g.drawImage(whiteQueen, el.getCol() * 60, el.getRow() * 60, this);
						}
						if(!el.getColor()) { //black queens
							g.drawImage(blackQueen, el.getCol() * 60, el.getRow() * 60, this);
						}
					}
				}
			}
		};
		
		panel.setLayout(null);
		
//		ArrayList<JButton> letters = new ArrayList<JButton>();
//		String lets = "abcdefgh";
//		for(int i = 0; i < 8; i++) {
//			letters.add(new JButton(lets.substring(i, i + 1)));
//		}
//		int i = 10;
//		for(JButton el : letters) {
//			el.setBounds(500, i, 50, 50);
//			panel.add(el);
//			i += 50;
//		}
//		
//		ArrayList<JButton> numbers = new ArrayList<JButton>();
//		String nums = "12345678";
//		for(int j = 0; j < 8; j++) {
//			numbers.add(new JButton(nums.substring(j, j + 1)));
//		}
//		int j = 10;
//		for(JButton el : numbers) {
//			el.setBounds(550, j, 50, 50);
//			panel.add(el);
//			j += 50;
//		}
		
		frame.add(panel);
		
		frame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int bCol = e.getX() / 60;
				int bRow = (e.getY() - 30) / 60;

//				System.out.println(bRow + " | " + bCol);
//				m = getPiece(e.getX(), e.getY() - 30); // -30 bc its bugged for some reason
//				System.out.println(m);
				if(m == null) {
					m = getPiece(e.getX(), e.getY() - 30); // -30 bc its bugged for some reason
					System.out.println(m);
				}
				else {
					selected[0] = bRow;
					selected[1] = bCol;
					
					if(selected[0] == m.getRow() && selected[1] == m.getCol()) {
						m = null;
						System.out.println("deselected");
					}
					else {
//						System.out.println(selected[0] + " : " + selected[1]);
//						System.out.println(m);
						
//						int[] moveMade = selected;
						int[][] possibleMoves = m.getPossibleMoves(b);
						for(int i = 0; i < possibleMoves[0].length; i++) {
//							System.out.println(possibleMoves[0][i] + "   " + possibleMoves[1][i]);
							if(possibleMoves[0][i] == selected[0] && possibleMoves[1][i] == selected[1] && toggleTurn == m.getColor()) {
//								System.out.println("legal");
								
								m.move(bRow, bCol, b);
								p = b.pieces();
//								System.out.println(m);
//								System.out.println(toggleTurn);
								frame.repaint();
								
								toggleTurn = !toggleTurn;
								m = null;
								break;
							}
//							else {
//								System.out.println("illegal");
//								m = null;
//								i = 100;
//							}
//							m = null;
						}
//						System.out.println(toggleTurn);
					}
					
				}
				
//				if (selected[0] == -1 && m != null) {
//					selected[0] = bRow;
//					selected[1] = bCol;
//					System.out.println(selected[0] + " -- " + selected[1]);
//				}
//				else if (selected[0] != -1 && b.getBoard()[selected[0]][selected[1]].inPossibleMoves(bRow, bCol, b)) { //add check for if piece is there
//					System.out.println("aha");
//					if (b.getBoard()[bRow][bCol] != null) { //taking
//						p.remove(b.getBoard()[bRow][bCol]);
//					}
//					b.getBoard()[bRow][bCol] = b.getBoard()[selected[0]][selected[1]]; 
//					b.getBoard()[selected[0]][selected[1]] = null;
//					b.getBoard()[bRow][bCol].setRow(bRow);
//					b.getBoard()[bRow][bCol].setCol(bCol); //switching
//					frame.repaint();
//					selected[0] = -1;
//					selected[1] = -1;
//				}
//				else {
//					selected[0] = -1;
//					selected[1] = -1;
//				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
//				System.out.println(getPiece(e.getX(), e.getY()));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
//		ChessBoard board = new ChessBoard();
//		frame.add(board);
		frame.setVisible(true);
		

	}
}
