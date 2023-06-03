public class Game {

	/**
	return the location(s) of a piece with a specific name and color in the passed in board object
	@param _b the passed in board object
	@param color the color of the desired piece(s)
	@param name the name of the desired piece(s)
	@return the position of the desired piece(s)
	*/
    public static int[][] findPieces(Board _b, boolean color, String name) {
        Piece[][] b = _b.getBoard();
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
    
	/**
	determines if a move is a check to opposing king
	@param _b the Board containing the opposing king
	@param color the color of the opposing king // verify opposing?
	@return whether or not it is a check
	*/
    public static boolean checkCheck(Board _b, boolean color) {
        Piece[][] b = _b.getBoard();
		int[][] kingLoc = findPieces(_b, color, "king"); // finds the location of the king
		int kingR = kingLoc[0][0];
		int kingC = kingLoc[1][0];
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) { // iterates through the board looking for pieces of the other color
				if (b[i][j] != null && b[i][j].getColor() != color) {
					int[][] moves = b[i][j].getPossibleMoves(_b);
					for (int k = 0; k < moves[0].length; k++) { // checks if the king's square is a possible move
						if (moves[0][k] == kingR && moves[1][k] == kingC) {
							return true;
						}
					}
				}
			}
		}		
		return false;
	}

/**
Returns whether board is resulting in a checkmate, assuming checkCheck works as expected
@param _b the board passed in
@param color the color of the checkMated side
@return whether or not checkmate
*/
    public static boolean checkMate(Board b, boolean color) {
        if (checkCheck(Board _b, boolean color) { // check at least is necessary, then first find the king
		for (int i = 0; i<b.length; i++) {
			for (int j = 0; j<b[0].length; j++) {
				if (b[i][j].getSquare().getName("king") && b[i][j[.getSquare().getColor(color)) {
					
	
		}
			
	}
	    
		
    }

   public static boolean checkStaleMate(Board _b, boolean c) {
        Piece[][] b = _b.getBoard();
        for (int i = 0; i < b.length; i++) {
        	for (int j = 0; j < b[0].length; j++) {
        		if (b[i][j] != null && b[i][j].getColor() == c) {
        			if (b[i][j].getPossibleMoves(_b)[0][0] != -1) {
        				return false;
        			}
        		}
        	}
        }
        return true;
    }
}
