import javax.swing.*;
import java.awt.*; //both pacakges for window-based applications, as this chess program will be

public class ChessBoard extends JPanel { // what we did for graphics
    private static final int squareLength = 50; // like the house lab, each square on the chessboard is 50x50 units
    private static final int boardLength = 8; // chessboard is 8 x 8.
    private static final Color whiteSquare = Color.WHITE; // chessboard is white and gray squares (nested for loop structure below for assignment) 
    private static final Color graySquare = Color.GRAY; // see above
    private static final Color pieceColor = Color.BLACK; // THINK OVER THIS
    private static final Font pieceFont = new Font("Arial", Font.PLAIN, 32); // We need a font to draw the below piece symbols.
    private static final Piece[] pieceBlackSymbols = {new Pawn(), new Pawn (), new Pawn (), "♕", "♖", "♗", "♘", "♙", "♚", "♛", "♜", "♝", "♞", "♟"}; // symbols from internet 

    protected void paintComponent(Graphics g) { // We are overriding this method from JComponent abstract class
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g; // more stuff from our graphics unit

        // Draw each square of the chessboard
        for (int row = 0; row < boardLength; row++) {
            for (int col = 0; col < boardLength; col++) { // simple nested loop through the board
                int x = col * squareLength; // x and y dimensions
                int y = row * squareLength;
                if ((row + col) % 2 == 0 ) {
                    Color squareColor = whiteSquare;
                }
                else {
                    Color squareColor = graySquare;
                }
                g2d.setColor(squareColor);
                g2d.fillRect(x, y, squareLength, squareLength); // fills them all in
            }
        }

//         Draw each piece on the chessboard
        g2d.setFont(pieceFont);
        g2d.setColor(pieceColor);
        for (int row = 0; row < boardLength; row++) {
            for (int col = 0; col < boardLength; col++) {
                int x = col * squareLength + squareLength / 2; // prints each piece in the middle of each square
                int y = row * squareLength + squareLength / 2;
                String pieceSymbol = pieceSymbols[row * boardLength + col]; // REVISE
                g2d.drawString(pieceSymbol, x - squareLength / 4, y + squareLength / 4); // based on the font-size, the "cursor" needs to start 1/4 of the squareLength to the left of the middle
            }
        }
    }
}