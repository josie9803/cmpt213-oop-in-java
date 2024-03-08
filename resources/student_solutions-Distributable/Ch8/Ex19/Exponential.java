import java.util.Random;

/**
   A class for computing exponentially distributed random numbers
*/
public class Exponential implements Distribution
{
   /**
      Returns an exponentially distributed random number with the given mean
      This algorithm, due to Marsaglia, Sibuya and Ahrens, is from
      Knuth, Seminumerical Algorithms, Addison-Wesley 1981, p. 128
      Note that Knuth has two typos: j should start at 0, and in
      step 4 set X to mean (j ln 2 + V), not mean (j + V)ln 2.
      @param mean the mean of the number sequence
      @return the random number
   */
   public double get(double mean)
   {  
      if (kmax == 0) 
         precompute();

      int iu = random.nextInt(RAND_MAX);

      // Find the first 0 bit
      int j = 0;
      while ((MASK & iu) != 0)
      {  
         iu <<= 1;
         j++;
      }

      // Shift out the first 0 bit.  It goes into the sign bit, leaving a
      // positive number.
      iu <<= 1;

      // Convert to a fraction 
      double u = iu / DENOM;

      if (u < LN2) 
         return mean * (j * LN2 + u);

      int k = 2;
      while (k < kmax && u >= q[k]) 
         k++;

      int uv = RAND_MAX;
      for (int i = 0; i < k; i++)
      {  
         int uui = random.nextInt(RAND_MAX);
         if (uui < uv) 
            uv = uui;
      }

      double v = uv / DENOM;

      return mean * (j * LN2 + v);
   }

   /**
      Precompute q array for use in computing the exponential distribution
   */
   private void precompute()
   {  
      double s = 1;
      int k = 0;
      q[0] = 0;

      while (k < KMAX - 1 && q[k] <= (1 - 1 / DENOM))
      {  
         k++;
         s = s * LN2 / k;
         q[k] = q[k - 1] + s;
      }

      kmax = k;
   }

   private java.util.Random random = new java.util.Random();

   /**
      The following are for computing the exponential distribution.  
      See the description of the algorithm in Knuth.
   */

   private static int kmax = 0;
   private static final int KMAX = 30;

   private static double[] q = new double[KMAX];

   // int is signed 32 bit and we make RAND_MAX = 2^31 - 1 so that we
   // effectively have 31-bit, positive, random numbers.
   private static final int RAND_MAX = 0x7FFFFFFF;

   // MASK has a 1 in the most significant bit of the random numbers so
   // that we can find the first zero bit, ignoring the sign bit.
   private static final int MASK = 0x40000000;

   // DENOM is the denominator used to convert the random number to a fraction.
   // It is a long value to keep it positive.
   private static final double DENOM = 0x80000000L;

   private static final double LN2 = 0.693147180559945309417;
}
