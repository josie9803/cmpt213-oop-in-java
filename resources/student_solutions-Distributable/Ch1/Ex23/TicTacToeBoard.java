/**
   A class for storing, manipulating, and printing TicTacToe boards
*/
public class TicTacToeBoard
{
   /**
      Prints the board.
   */
   public void print()
   {
      System.out.println("Here is the current board:");
      System.out.println();

      for (int i = 0; i < BOARD_SIZE; i++)
      {
         for (int j = 0; j < BOARD_SIZE; j++)
         {
            System.out.print(board[i][j]);

            // Print strut after all but last column
            if (j != BOARD_SIZE-1) 
               System.out.print("|");
         }

         // Move to next row
         System.out.println();     

         // Print row line after all but last row
         if (i != BOARD_SIZE-1) 
            System.out.println("-----");
      }
   }
    
   /**
      Checks whether the board contains a win for either player
      @return whether the board contains a win for either player
   */
   public boolean isGameWon(){

      char[][] b = board;  // Use a local to give shorter expressions

      // Check (short circuit) all rows, columns and diagonals for a win
      return
           b[0][0] == b[0][1] && b[0][1] == b[0][2] && b[0][0] != EMPTY // Row 0
        || b[1][0] == b[1][1] && b[1][1] == b[1][2] && b[1][0] != EMPTY // Row 1
        || b[2][0] == b[2][1] && b[2][1] == b[2][2] && b[2][0] != EMPTY // Row 2
                                                                      
        || b[0][0] == b[1][0] && b[1][0] == b[2][0] && b[0][0] != EMPTY // Col 0
        || b[0][1] == b[1][1] && b[1][1] == b[2][1] && b[0][1] != EMPTY // Col 1
        || b[0][2] == b[1][2] && b[1][2] == b[2][2] && b[0][2] != EMPTY // Col 2
                                                                      
        || b[0][0] == b[1][1] && b[1][1] == b[2][2] && b[1][1] != EMPTY // Dia 1
        || b[2][0] == b[1][1] && b[1][1] == b[0][2] && b[1][1] != EMPTY // Dia 2
      ;
   }

   /**
      Checks whether the board is full
      @return whether the board is full
   */
   public boolean isFull()
   {
      for (int i = 0; i < BOARD_SIZE; i++)
         for (int j = 0; j < BOARD_SIZE; j++)
            if (board[i][j] == EMPTY)
               return false;
      return true;
   }
    
   /**
      Checks whether a move is valid on this board.
      @param theMove the move to check
      @return whether a move is valid on this board.
   */
   public boolean isMoveValid(TicTacToeMove theMove){

      // Get the move's row and column in the board's coordinates
      int r = theMove.getRowOffset();
      int c = theMove.getColumnOffset();

      return board[r][c] == EMPTY;
   }
    
   /**
      Displays a move and marks the board with that move.  
      Assumes that the move is valid.
      @param theMove the move to make
      @param p the character to be placed on the board
   */
   public void handleMove(TicTacToeMove theMove, char p)
   {
      // Get the row and column of the move, in move coordinates
      int r = theMove.getRowMove();
      int c = theMove.getColumnMove();

      System.out.println();
      System.out.println("The move for '" + p + "' is " + r + ", "+ c);


      // Get the move's row and column in the board's coordinates
      r = theMove.getRowOffset();
      c = theMove.getColumnOffset();

      // Place the player's mark on the board
      board[r][c] = p;
   }

   /**
      Returns the size of the board
      @return the size of the board
   */
   public static int getBoardSize()
   {
      return BOARD_SIZE;
   }

   /**
      Sets all squares of the board to EMPTY
   */
   public void clear()
   {
      for (int i = 0; i < BOARD_SIZE; i++)
         for (int j = 0; j < BOARD_SIZE; j++)
            board[i][j] = EMPTY;
   }

   private static final int BOARD_SIZE = 3;

   private static final char EMPTY = ' ';

   private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
}
