/**
   A class for Tic Tac Toe moves
*/
public class TicTacToeMove
{
   /**
      Constructs a TicTacToeMove object that stores one move
   */
   public TicTacToeMove(int r, int c)
   {
      if (r < lowMove | r > highMove | c < lowMove | c > highMove)
         throw new IllegalArgumentException();

      row = r;
      column = c;
   }

   /**
      Returns the row value of a move
      @return the row value of a move
   */
   public int getRowMove()
   {
      return row;
   }

   /**
      Returns the column value of a move
      @return the column value of a move
   */
   public int getColumnMove()
   {
      return column;
   }

   /**
      Returns the row offset of a move
      @return the row offset of a move
   */
   public int getRowOffset()
   {
      return row - lowMove;
   }

   /**
      Returns the column offset of a move
      @return the column offset of a move
   */
   public int getColumnOffset()
   {
      return column - lowMove;
   }

   /**
      Returns the value of the lowest possible move
      @return the value of the lowest possible move
   */
   public static int getLowMove()
   {
      return lowMove;
   }

   /**
      Returns the value of the highest possible move
      @return the value of the highest possible move
   */
   public static int getHighMove()
   {
      return highMove;
   }


   private int row;
   private int column;

   private static final int lowMove  = 1;
   private static final int highMove = 3;
}
