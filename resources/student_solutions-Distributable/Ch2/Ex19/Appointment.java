import java.util.StringTokenizer;

/**
   A class for appointment objects
*/

public class Appointment
{
   /**
      creates an Appointment object with the specified item and date
      @param item what the appointment is
      @param when when the appointment is
   */
   public Appointment(String appointmentLine)
   {
      StringTokenizer t = new StringTokenizer(appointmentLine);

      int descriptionCount = t.countTokens() - 3;
      String description = "";
      for (int i = 1; i <= descriptionCount; i++)
      {
         description += t.nextToken();
         if (i < descriptionCount)
            description += " ";
      }

      String date = t.nextToken();

      String startTime = t.nextToken();

      String endTime = t.nextToken();

      this.item         = description;
      this.date         = new AppointmentDate(date);
      this.startTime    = new AppointmentTime(startTime);
      this.endTime      = new AppointmentTime(endTime);
   }

   /**
      gets the date of an Appointment
      @return the date of the Appointment
   */
   public AppointmentDate getDate()
   {
      return this.date;
   }

   /**
      checks if this Appointment has the same item,date, and start and
         end times as another
      @param other the appointment to compare this to
   */
   public boolean equals(Appointment other)
   {
      if (other == null)
         return false;
      else
      {
         Appointment a =  other;
         return this.item.equals(a.item)
            && this.date.equals(a.date)
            && this.startTime.equals(a.startTime)
            && this.endTime.equals(a.endTime)
            ;
      }
   }

   /**
      creates a String from this appointment
      @return a String that represents this Appointment object
   */
   public String toString()
   {
      return item + " " + date + " " + startTime + " " + endTime;
   }

   private String item;
   private AppointmentDate date;
   private AppointmentTime startTime;
   private AppointmentTime endTime;
}
