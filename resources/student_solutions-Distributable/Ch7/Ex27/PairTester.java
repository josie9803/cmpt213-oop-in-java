/**
 * A class for testing the static method getMinMax of Utils class with appropriate type bounds.
 */

import java.util.*;

public class PairTester
{

   public static void main(String[] args)
   {
      ArrayList<GregorianCalendar> dates = new ArrayList<GregorianCalendar>();
      for (int i = 1 ; i <= 10000; i++)
         dates.add(new GregorianCalendar());

      Collections.shuffle(dates);

      Pair<GregorianCalendar> p = Utils.getMinMax(dates);
      
      System.out.println(p);
   }
}
