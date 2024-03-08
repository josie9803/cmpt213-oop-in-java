/**
  An interface for specifying that an object has a measure method
*/
public interface Measurer
{
   /**
      Provides a measure for an object
      @param x the object to measure
   */
   public double measure(Object x);
}
