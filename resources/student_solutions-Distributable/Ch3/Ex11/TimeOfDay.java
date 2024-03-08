import java.lang.Math;

/**
   A class for keeping the time of day
*/
public class TimeOfDay
{
   /**
      Construct a time of day object
      @arg hours hour of the time
      @arg minutes minutes of the time
      @arg seconds seconds of the time
   */
   public TimeOfDay(int hours, int minutes, int seconds)
   {
      totalSeconds = hours * SECONDS_PER_HOUR
         + minutes * SECONDS_PER_MINUTE + seconds;
   }

   /**
      Get the hours part of the time
      @return hours
   */
   public int getHours()
   {
      return totalSeconds / SECONDS_PER_HOUR;
   }

   /**
      Get the minutes part of the time
      @return minutes
   */
   public int getMinutes()
   {
      return (totalSeconds - getHours() * SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
   }

   /**
      Get the seconds part of the time
      @return seconds
   */
   public int getSeconds()
   {
      return totalSeconds % SECONDS_PER_MINUTE;
   }

   /**
      Add a specified number of seconds to this time and return the new time
      @arg seconds the number of seconds to add
      @return the new time
   */
   public TimeOfDay addSeconds(int seconds)
   {
      seconds = (totalSeconds + seconds) % SECONDS_PER_DAY;
      int hours = seconds / SECONDS_PER_HOUR;
      int minutes = (seconds - hours * SECONDS_PER_HOUR) 
         / SECONDS_PER_MINUTE;
      seconds = seconds % SECONDS_PER_MINUTE;
      return new TimeOfDay(hours, minutes, seconds);
   }

   /**
      Find the number of seconds between this time and another
      @arg other the other time
      @return number of seconds between this time and other
   */
   public int secondsFrom(TimeOfDay other)
   {
       return Math.abs(this.totalSeconds - other.totalSeconds);
   }

   private static final int SECONDS_PER_HOUR = 60 * 60;
   private static final int SECONDS_PER_MINUTE = 60;
   private static final int MINUTES_PER_HOUR = 60;
   private static final int HOURS_PER_DAY = 24;
   private static final int SECONDS_PER_DAY = 24 * SECONDS_PER_HOUR;

   private int totalSeconds;

}
         
