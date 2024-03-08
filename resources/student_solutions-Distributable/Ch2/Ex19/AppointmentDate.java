import java.util.Scanner;

/**
   An appointment date.
*/
public class AppointmentDate
{
   /**
      Constructs an AppointmentDate object.
      @param d the date
   */
   public AppointmentDate(String d)
   {
      Scanner s = new Scanner(d).useDelimiter("/");
      year = s.nextInt();
      month = s.nextInt();
      day = s.nextInt();
   }

   /**
      Determines if dates are equal.
      @param the other date
      @return true if the dates are equal, false otherwise
   */
   public boolean equals(AppointmentDate other)
   {
      if (other == null) return false;
      AppointmentDate b = other;
      return year == b.year && month == b.month && day == b.day;
   }

   /**
      Prints a string representation of the date.
      @return the date
   */
   public String toString()
   {
      return year + "/" + month + "/" + day;
   }

   private int year;
   private int month;
   private int day;
}
