/**
   An interface for various probability distributions
*/
interface Distribution
{
   /**
      Returns a value in the distribution with the given mean.
      @return the value in the distribution
   */
   double get(double mean);
}
