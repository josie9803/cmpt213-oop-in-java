import java.util.*;
import java.math.*;

public class Ex4_5
{
   public static void main(String[] args)
   {
      ArrayList values = new ArrayList();
      values.add(new BigDecimal("1230990480229874019780"));
      values.add(new BigDecimal("1230990480129874019780"));
      values.add(new BigDecimal("1230990480129874039780"));
      System.out.println(minimum(values));
   }

   /**
      Finds the smallest element in the ArrayList
      @arg a the ArrayList
      @return the smallest object
      @precondition the elements of a 
         implement the interface java.lang.Comparable 
      @precondition array a != null
   */
   public static Object minimum(ArrayList a)
   {
      Comparable min = (Comparable) a.get(0);
      for (int i = 1; i < a.size(); i++)
      {
         Comparable toTest = (Comparable) a.get(i);
         if (toTest.compareTo(min) < 0)
            min = toTest;
      }

      return min;
   }
}
