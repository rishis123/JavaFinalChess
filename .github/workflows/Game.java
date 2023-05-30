public class Game {
    private int result;
    private Board b;
    private int wKingx;
    private int wKingy;
    private int bKingx;
    private int bKingy;

    public Game() {
        b = new Board();
    }

    public Game(Board _b) {
        b = _b;
    }

    public int[][] findPieces(boolean color, String name) {
        int[][] pieceLocations = new int[2][8]; //8 pawns is max
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                pieceLocations[i][j] = -1; // set initial values to -1
            }
        }
                
        int c = 0; //counter
        
         for (int i = 0; i < b.length; i++) {
             for (int j = 0; j < b[0].length; j++ ) {
            	 if (b[i][j] != null && b[i][j].getColor() == color && b[i][j].getName() == name) {
            		 pieceLocations[0][c] = b[i][j].getRow();
            		 pieceLocations[1][c] = b[i][j].getCol();
            		 c++;
            	 }
             }
         }
        return pieceLocations;     
    }
    
    
    
    public void movefromNotation (String moveNotation) {
        
       if (moveNotation.equals("O-O")) {
            // Castling kingside
            move("e1", "g1"); // FIGURE OUT WHICH SIDE GOES?
        } else if (moveNotation.equals("O-O-O")) {
            // Castling queenside
            move("e1", "c1"); // SAME HERE
        } else if (moveNotation.length() == 5) { 
           
           if (input.charAt(4) = 'Q'){ //promotion of a pawn -- e7e8Q
               String from = moveNotation.substring(0,2);
               String to = moveNotation.substring(2,4);
               move(from, to); // HOW DO WE FIGURE OUT ORIGINAL PIECE THERE
           else if (input.charAt(0) = 'K' || input.charAt(0) = 'Q' || input.charAt(0) = 'B' || input.charAt(0) = 'R' || input.charAt(0) = 'N' ) { // normal piece -- Qf3f4
               String from = moveNotation.substring(1,3);
               String to = moveNotation.substring(3,5);
               move(from,to);
           }
      
        } else if (moveNotation.length() == 4) { // e2e4 -- pawn but not promote
            String from = moveNotation.substring(0, 2);
            String to = moveNotation.substring(2, 4);
           move(from, to);
            }
      } else {
            System.out.println("Invalid move notation."); // HOW TO AVOID PRINT TO CONSOLE?
        }
        
    }
    
    
    public boolean checkCheck() {
        return false; //implement later
    }

    public int checkMate() {
        result = 1;
        return result; //implement later
    }

    public int checkStaleMate() {
        return 0; //this will be hard to implement
    }
}
