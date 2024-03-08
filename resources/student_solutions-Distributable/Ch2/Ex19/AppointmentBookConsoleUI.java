/**
    A class for accessing an AppointmentBook via the console
*/
import java.util.ArrayList;
import java.io.PrintStream;
import java.io.IOException;
import java.util.Scanner;

public class AppointmentBookConsoleUI
{
   /**
      constructs a console user interface for the appointmentbook
      @param br the buffered reader to use for the console
      @param out the printstream to write to
      @param book the appointment book to use for the commands
   */
   public AppointmentBookConsoleUI(Scanner in, PrintStream out,
         AppointmentBook book)
   {
      this.in = in;
      this.out = out;
      this.book = book;
   }

   private void doRemove()
   {
      Appointment a = getAppointment();
      if (book.isInBook(a))
      {
         book.remove(a);
         out.println("Removed appointment " + a);
      }
      else
         out.println("Appointment not found");
   }

   private void doAdd() throws java.io.IOException
   {
      Appointment a = getAppointment();
      book.add(a);
      out.println("Added appointment " + a + "\n");
   }

   private void doList() throws java.io.IOException
   {
      out.print("Enter the date: ");
      AppointmentDate d = new AppointmentDate(in.nextLine().trim());
      ArrayList<Appointment> l = book.getDayList(d);

      if (l.size() > 0)
      {
         out.println();
         out.println("Appointments for " + d + ":");
         for (Appointment a : l)
            out.println(a);
         out.println();
      }
      else
         out.println("No appointments for that day!\n");
   }

   private void doShowAllAppointments() //throws java.io.IOException
   {
      ArrayList<Appointment> l = book.getAllAppointments();
      out.println();
      out.println("All appointments:");
      for (Appointment a : l)
        out.println(a);
      out.println();
   }

   /**
      display and process the main menu commands
   */
   public void doMainMenu()
   {
      out.println("Welcome to the address book program!");
      out.println("Please enter your command");
      while (true)
      {
         out.print
            ("Enter A)dd, R)emove, L)ist Day, S)how all, or Q)uit: ");
         try
         {
            char command = in.nextLine().trim().toUpperCase().charAt(0);

            if (command =='A')
               doAdd();
            else if (command == 'R')
               doRemove();
            else if (command == 'L')
               doList();
            else if (command == 'S')
               doShowAllAppointments();
            else if (command == 'Q')
            {
               out.println("Goodbye");
               System.exit(0);
            }
            else
               out.println("Invalid command");

         }
         catch(Exception e)
         {
            out.println("An error occurred.  Try again.");
         }
      }
   }

   // input a date
   private Appointment getAppointment()
   {
      out.print("Enter the appointment (description date start end): ");
      return new Appointment(in.nextLine());
   }

   private Scanner in;
   private PrintStream out;
   private AppointmentBook book;
}
