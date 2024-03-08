import java.util.ArrayList;

/**
   A class for keeping an address book
*/
public class AppointmentBook
{
   /**
      adds an Appointment to an appointment book
      @param a the appointment to add
   */
   public void add(Appointment a)
   {
      // A sorted list would be better
      appointmentList.add(a);
   }


   /**
      determines if an appointment is in the book
      @param a the appointment to find
   */
   public boolean isInBook(Appointment a)
   {
      return find(a) != NOTFOUND;
   }

   /**
      removes an appointment from an book
      @param toRemove the appointment to remove
   */
   public void remove(Appointment toRemove)
   {
      int location = find(toRemove);
      if (location != NOTFOUND)
         appointmentList.remove(location);
      else
         throw new IllegalArgumentException("Appointment not found");
   }

   /**
      extracts, from an appointment book, a list of the appointments that
         occur on a particular day
      @param date the day of the appointments to list
      @return returns an Arraylist of appointments on a particular day
   */
   public ArrayList<Appointment> getDayList(AppointmentDate date)
   {
      ArrayList<Appointment> l = new ArrayList<Appointment>();

      for (Appointment a : appointmentList)
      {
         if (a.getDate().equals(date))
            l.add(a);
      }
      return l;
   }

   /**
      creates a list of all of the appointments from an appointment book
      @return returns an Arraylist of Appointments
   */
   public ArrayList<Appointment> getAllAppointments()
   {
      ArrayList<Appointment> l = new ArrayList<Appointment>(appointmentList);

      return l;
   }

   // Find the location of a particular appointment
   // Returns -1 if not in book
   // Would be better to use a sorted list and a binary search
   private int find(Appointment toFind)
   {
      int i = 0;
      for (Appointment a : appointmentList)
      {
         if (a.equals(toFind))
            return i;
         i++;
      }
      return NOTFOUND;
   }


   private static final int NOTFOUND = -1;

   private ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
}
