import java.util.Scanner;

/**
    A class for testing the appointment book classes
*/
public class AppointmentBookTester
{
   /**
      creates a reader, an appointment book, and an appointment book
      console interface, and runs the interface
   */
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      AppointmentBook book = new AppointmentBook();
      AppointmentBookConsoleUI u =
         new AppointmentBookConsoleUI(in, System.out, book);
      u.doMainMenu();
   }
}
