/**
   A class for calculating the integer square root of an integer
*/
public class Sqrt
{
   /**
      Calculates and prints the square root of 1000
      @param args unused
   */
   public static void main(String[] args)
   {
      // The number to find the square root of.
      // It must be positive.
      final int x = 1000; 

      int y = 0;

      while (y * y < x) 
         y++; 

      int errorAbove = y * y - x;
      int errorBelow = x - (y - 1) * (y - 1);
      
      if (errorBelow < errorAbove)
         y = y - 1;

      System.out.println("The integer square root of " + x + " is " + y);
   }
}
