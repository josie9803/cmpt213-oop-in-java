import java.awt.*;

/**
   Demonstrates the independent thread created for a GUI.
*/
public class ThreadTester extends Frame
{
   public static void main(String[] args)
   {
      new ThreadTester().setVisible(true);

      try
      {
         for (int i = 0; i < REPS; i++)
         {
            System.out.println(i);
            Thread.sleep(DELAY);
         }
      }
      catch (InterruptedException e)
      {
      }
   }

   public void paint(Graphics g)
   {
      System.out.println("Paint starts");
      try
      {
         Thread.sleep(5 * DELAY);
      }
      catch (InterruptedException e)
      {
      }

      System.out.println("Paint is done");
   }

   private static final int REPS = 20;
   private static final int DELAY = 1000;
}
