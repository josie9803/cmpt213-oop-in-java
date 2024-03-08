import java.util.Scanner;

/**
   An appointment time.
*/
public class AppointmentTime
{
   /**
      Constructs an AppointmentTime object
      @param t the time
   */
   public AppointmentTime(String t)
   {
      Scanner s = new Scanner(t).useDelimiter(":");
      hours = s.nextInt();
      minutes = s.nextInt();
   }

   /**
      Determines if the appointment times are equal.
      @param other the other time
      @return true if the appointment times are equal, false otherwise
   */
   public boolean equals(AppointmentTime other)
   {
      if (other == null)
         return false;
      AppointmentTime b = other;
      return hours == b.hours && minutes == b.minutes;
   }

   /**
      Prints a string representation of the time.
      @return the time
   */
   public String toString()
   {
      String r = hours + ":";
      if (minutes < 10) r = r + "0";
      r = r + minutes;
      return r;
   }

   private int hours;
   private int minutes;
}
