import java.util.*;

public class Utils
{
   /**
      Get a pair that contains the first and last element of an array list
      Precondition: a has at least two elements.
      @param a an ArrayList type E
      @return Pair of type E.
   */
   public static <E> Pair<E> getFirstLast(ArrayList<E> a)
   {
      E first  = a.get(0);
      E second = a.get(a.size() - 1);
      return new Pair<E>(first, second);
   }
}
