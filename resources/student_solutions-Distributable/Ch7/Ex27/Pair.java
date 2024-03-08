/**
   Write a generic class Pair<E> that stores two values of type E
 */

public class Pair<E>
{

   /**
      Constructs a Pair with the two initial values.
      @param first the Pair's first value
      @param second the Pair's second value
   */
   public Pair(E first, E second)
   {
      this.first  = first;
      this.second = second;
   }

   /**
      Set the first value of a Pair.
      @param value the value to be set
   */
   public void setFirst(E aValue)
   {
      first = aValue;
   }

   /**
      get the first value of a Pair.
      @return the first value.
   */
   public E getFirst()
   {
      return first;
   }

   /**
      Set the second value of a Pair.
      @param aValue the value to be set
   */
   public void setSecond(E aValue)
   {
      second = aValue;
   }

   /**
      get the second value of a Pair.
      @return the second value.
   */
   public E getSecond()
   {
      return second;
   }

   public String toString()
   {
      return getClass().getName() + "[first=" + first + ",second=" + second + "]";
   }

   private E first;
   private E second;
}
