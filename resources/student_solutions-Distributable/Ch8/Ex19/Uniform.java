/**
   Implements a uniform random distribution centered around the mean
*/
public class Uniform implements Distribution
{
   public double get(double mean)
   {
      return random.nextDouble() * mean * 2.0;
   }

   private java.util.Random random = new java.util.Random();
}
