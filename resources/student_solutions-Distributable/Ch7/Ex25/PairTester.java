/**
 * A class for testing the static method getFirstLast of Utils class.
 */

import java.util.*;

public class PairTester
{
   public static void main(String[] args)
   {
      ArrayList<Integer> a = new ArrayList<Integer>();
      
      for (int i = 0; i < 10 ; i++)
         a.add(i);
      
      Pair<Integer> p = Utils.getFirstLast(a);
      
      System.out.println(p);
   }
}
