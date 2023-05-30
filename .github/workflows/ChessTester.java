import java.util.Scanner;
public class ChessTester {
  public static void main (String [] args) {
    
    Game g = new Game(); // declare and initialize new Game??
    
    System.out.println("Hello and welcome to our Chess Player vs. Player Game. Please get a friend and input String standard notation chess commands -- the first player will be White.");
    
    System.out.println("First, what are your names?: ");
    Scanner in = new Scanner(System.in);
    String player1 = in.next();
    String player2 = in.next();
    
    System.out.println("Now, let's begin the game."); // where do graphics go?
    
    while (!checkMate() && !checkStaleMate()) { // initial check, after each player2 move
    
      System.out.println(player1 + ", your turn.");

      move(in.next()); // From piece class -- make a piece object?
      
      if (checkMate() || checkStaleMate()) {
        break;
      }
      
      if (checkCheck) {
        System.out.println(player2 + ", Check!");
      }
      
      System.out.println(player2 + ", your turn.");
      
      move(in.next());
      
      if (checkCheck) {
        System.out.println(player1 + ", Check!");
      }
    }
    
    if (checkMate()) {
      System.out.println("Game Over!"); // can we determine who the winner was ?
      in.close();
    }
    else {
      System.our.println("Game drawn by Stalemate!");
      in.close();
    }
  }
    
                         
      
      
    
      
      
      
      
    }
                         
