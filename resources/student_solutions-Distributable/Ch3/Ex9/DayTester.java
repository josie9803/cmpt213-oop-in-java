/**
   A class for testing the calendar class
*/
public class DayTester
{
   /**
      Tests the before and after methods of the Day class.
      @arg args unused
   */
   public static void main(String[] args)
   {
      Day today = new Day(2001, 2, 3); // February 3, 2001
      Day later = today.addDays(999);

      System.out.println(today.before(later));
      System.out.println(later.after(today));

      System.out.println(today.before(today));
      System.out.println(today.after(today));

      System.out.println(today.after(later));
      System.out.println(later.before(today));
   }
}
