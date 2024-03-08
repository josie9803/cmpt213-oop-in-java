/**
   A class for testing the TimeOfDay class
*/
public class TimeOfDayTester
{
   /**
      Create and uses TimeOfDay object 
      @arg args unused
   */
   public static void main(String[] args)
   {
      TimeOfDay t = new TimeOfDay(12, 30, 40); // February 3, 2001
      printTime(t);

      TimeOfDay u = new TimeOfDay(1, 0, 0); // February 3, 2001
      printTime(u);

      TimeOfDay later = t.addSeconds(1);
      printTime(later);

      later = t.addSeconds(61);
      printTime(later);

      later = t.addSeconds(3601);
      printTime(later);

      TimeOfDay muchLater = t.addSeconds(24*60*60);
      printTime(muchLater);

      muchLater = t.addSeconds(24 * 60 * 60 - 1);
      printTime(muchLater);

      System.out.println(t.secondsFrom(t));
      System.out.println(t.secondsFrom(u));
      System.out.println(t.secondsFrom(later));
      System.out.println(t.secondsFrom(muchLater));

      System.out.println(u.secondsFrom(t));
      System.out.println(u.secondsFrom(u));
      System.out.println(u.secondsFrom(later));
      System.out.println(u.secondsFrom(muchLater));

      System.out.println(later.secondsFrom(t));
      System.out.println(later.secondsFrom(u));
      System.out.println(later.secondsFrom(later));
      System.out.println(later.secondsFrom(muchLater));

      System.out.println(muchLater.secondsFrom(t));
      System.out.println(muchLater.secondsFrom(u));
      System.out.println(muchLater.secondsFrom(later));
      System.out.println(muchLater.secondsFrom(muchLater));

   }
   
   private static void printTime(TimeOfDay t)
   {
      System.out.println(
         t.getHours() + ":" + t.getMinutes() + ":" + t.getSeconds());
   }

}
