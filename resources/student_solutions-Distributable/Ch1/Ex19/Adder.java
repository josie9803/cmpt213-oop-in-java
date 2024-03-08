/**
   A class for summing the command line arguments
*/
public class Adder
{
   /**
     Sums the command line arguments
     @param args unused
   */
   public static void main(String[] args)
   {
      double sum = 0.0;
      for (String s : args)
      {
         double a = Double.parseDouble(s);
         sum = sum + a;
      }

      System.out.println(sum);
   }
}
