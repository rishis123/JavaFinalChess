import Game.*;
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

public class ChessBoardDisplay {
	private static Board b = new Board();
	private static ArrayList<Piece> p = b.pieces();
	private static Piece m = null;
	
	public static Piece getPiece(int x, int y) {
		int row = x / 60;
		int col = y / 60;
		for(Piece el : p) {
			if(el.getRow() == row && el.getCol() == col) {
				return el;
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setSize(700, 600);
		frame.setTitle("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setUndecorated(true);
		
		BufferedImage whitePawn = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/whitePawn.png"));
		BufferedImage blackPawn = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/blackPawn.png"));
		BufferedImage whiteRook = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/whiteRook.png"));
		BufferedImage blackRook = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/blackRook.png"));
		BufferedImage whiteKnight = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/whiteKnight.png"));
		BufferedImage blackKnight = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/blackKnight.png"));
		BufferedImage whiteBishop = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/whiteBishop.png"));
		BufferedImage blackBishop = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/blackBishop.png"));
		BufferedImage whiteKing = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/whiteKing.png"));
		BufferedImage blackKing = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/blackKing.png"));
		BufferedImage whiteQueen = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/whiteQueen.png"));
		BufferedImage blackQueen = ImageIO.read(ChessBoardDisplay.class.getResource("/Pieces/blackQueen.png"));

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
							g.drawImage(whitePawn, el.getRow() * 60, el.getCol() * 60, this);
						}
						if(!el.getColor()) { //black pawns
							g.drawImage(blackPawn, el.getRow() * 60, el.getCol() * 60, this);
						}
					}
					if(el.getName().equals("rook")) {
						if(el.getColor()) { //white rooks
							g.drawImage(whiteRook, el.getRow() * 60, el.getCol() * 60, this);
						}
						if(!el.getColor()) { //black rooks
							g.drawImage(blackRook, el.getRow() * 60, el.getCol() * 60, this);
						}
					}
					if(el.getName().equals("knight")) {
						if(el.getColor()) { //white knights
							g.drawImage(whiteKnight, el.getRow() * 60, el.getCol() * 60, this);
						}
						if(!el.getColor()) { //black knights
							g.drawImage(blackKnight, el.getRow() * 60, el.getCol() * 60, this);
						}
					}
					if(el.getName().equals("bishop")) {
						if(el.getColor()) { //white bishops
							g.drawImage(whiteBishop, el.getRow() * 60, el.getCol() * 60, this);
						}
						if(!el.getColor()) { //black bishops
							g.drawImage(blackBishop, el.getRow() * 60, el.getCol() * 60, this);
						}
					}
					if(el.getName().equals("king")) {
						if(el.getColor()) { //white kings
							g.drawImage(whiteKing, el.getRow() * 60, el.getCol() * 60, this);
						}
						if(!el.getColor()) { //black kings
							g.drawImage(blackKing, el.getRow() * 60, el.getCol() * 60, this);
						}
					}
					if(el.getName().equals("queen")) {
						if(el.getColor()) { //white queens
							g.drawImage(whiteQueen, el.getRow() * 60, el.getCol() * 60, this);
						}
						if(!el.getColor()) { //black queens
							g.drawImage(blackQueen, el.getRow() * 60, el.getCol() * 60, this);
						}
					}
				}
			}
			
			
			
		};
		
		panel.setLayout(null);
		
		ArrayList<JButton> letters = new ArrayList<JButton>();
		String lets = "abcdefgh";
		for(int i = 0; i < 8; i++) {
			letters.add(new JButton(lets.substring(i, i + 1)));
		}
		int i = 10;
		for(JButton el : letters) {
			el.setBounds(500, i, 50, 50);
			panel.add(el);
			i += 50;
		}
		
		ArrayList<JButton> numbers = new ArrayList<JButton>();
		String nums = "12345678";
		for(int j = 0; j < 8; j++) {
			numbers.add(new JButton(nums.substring(j, j + 1)));
		}
		int j = 10;
		for(JButton el : numbers) {
			el.setBounds(550, j, 50, 50);
			panel.add(el);
			j += 50;
		}
		
		frame.add(panel);
		
		frame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX() / 60 + " | " + e.getY() / 60);
				System.out.println(getPiece(e.getX(), e.getY()));
				
				m = getPiece(e.getX(), e.getY());
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
