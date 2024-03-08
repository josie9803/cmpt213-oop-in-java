import java.util.Random;
import java.util.Scanner;

/**
   A class playing a game of TicTacToe
*/
public class TicTacToeGame
{
   /**
      Plays a game of TicTacToe
   */
   public void playAGame()
   {
      System.out.println();
      System.out.println("************************************************");
      System.out.println("Let's play Tic Tac Toe!");
      System.out.println("When asked for a move, enter location you want.");
      System.out.println("Enter the row first and then the column, ");
      System.out.println("   both on the same line.");
      System.out.println("The row and column must in the range 1 .. 3");
      System.out.println("************************************************");
      System.out.println();

      // Find out what character each player will use
      String request = "";
      do
      {
         try
         {
            System.out.print("Enter the character do you want to use: ");
            request = in.nextLine();
         }
         catch(Exception e)
         {
            System.out.println("Invalid input.  Try again!");
         }
      // Must be short a circuit or
      } while (request == null || request.length() == 0);

      person = request.charAt(0);

      // Computer is always x unless person is
      if (person != 'x')
         computer = 'x';
      else
         computer = 'o';

      // Find first player
      if (generator.nextBoolean())
         player = person;
      else
         player = computer;

      board.clear();
      board.print();
      System.out.println();

      boolean done = false;
      while (!done)
      {
         TicTacToeMove theMove = getAMove();

         board.handleMove(theMove, player);

         board.print();

         System.out.println();

         if (board.isGameWon() || board.isFull())
            done = true;
         else if (player == person)
            player = computer;
         else
            player = person;
      }

      // Done making moves
      if (board.isGameWon())
      {
         if (player == person)
            System.out.println("You won!");
         else
            System.out.println("I won!");
      }
      else if (board.isFull())
            System.out.println("We tied!");
      else
            System.out.println("Something went wrong!");

   }

   // Creates a move, either as random integers or as input from the user
   private TicTacToeMove getAMove()
   {
      TicTacToeMove m = null;

      if (player == computer)
      {
         System.out.println("It is my move.  I am '" + player + "'");
         do
         {
            int r = generator.nextInt(TicTacToeMove.getHighMove())
                       + TicTacToeMove.getLowMove();

            int c = generator.nextInt(TicTacToeMove.getHighMove())
                       + TicTacToeMove.getLowMove();

            m = new TicTacToeMove(r, c);

         }
         while ( !board.isMoveValid(m) );
      }
      else
      {
         System.out.println("It is your move.  You are '" + player + "'");
         while (true)
         {
            try
            {
               System.out.print("Enter a row and column on one line: ");
               int r = in.nextInt();
               int c = in.nextInt();

               // Generates an exception if you can't make a move from r and c
               m = new TicTacToeMove(r, c);

               if (board.isMoveValid(m))
                  break;
               else
                  System.out.println("Invalid move.  Try again!");
            }
            catch (Exception e)
            {
               System.out.print("There was an error in your input");
               System.out.println("  Try again!");
            }
         }
      }
      return m;
   }

   private char player;
   private char computer;
   private char person;

   private TicTacToeBoard board = new TicTacToeBoard();

   private static Random generator = new Random();

   private Scanner in = new Scanner(System.in);
}
