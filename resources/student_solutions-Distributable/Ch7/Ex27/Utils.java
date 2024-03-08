import java.util.*;

public class Utils
{

   /**
      Gets the smallest and largest element of an array list
      @param a an array list
      @return a pair consisting of the smallest and largest element of a
   */

   public static <E extends Comparable<? super E>> Pair<E> getMinMax(ArrayList<E> a)
   {
      E max = a.get(0);
      E min = max;

      for (E e : a)
      {
         if (e.compareTo(max) > 0) max = e;
         else if (e.compareTo(min) < 0) min = e;
      }

      return new Pair<E>(min, max);
   }
}


