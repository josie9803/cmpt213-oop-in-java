import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

/*
   A class for finding out how many days a person has lived
*/
class Days
{
   /*
      Calculate the number of days and print the results
      @arg args unused
   */
   public static void main(String[] args) throws java.text.ParseException
   {
      java.text.DateFormat df = DateFormat.getInstance();

      String dob = "3/22/1982 12:00 PM";
      if (args.length > 0)
      	dob = args[0];
      Date d = df.parse(dob);

      GregorianCalendar birthCal = new GregorianCalendar();
      birthCal.setTime(d);

      int birthDayOfYear = birthCal.get(Calendar.DAY_OF_YEAR);

      int year = birthCal.get(Calendar.YEAR);
      int month = birthCal.get(Calendar.MONTH);
      int date = birthCal.get(Calendar.DATE);

      // Add 1 because January is month 0
      Day birthDay = new Day(year, month+1, date);
      System.out.println(Day.toJulian(year, month, date));


      Date todayDate = new Date();
      GregorianCalendar todayCal = new GregorianCalendar();
      todayCal.setTime(todayDate);

      year = todayCal.get(Calendar.YEAR);
      month = todayCal.get(Calendar.MONTH);
      date = todayCal.get(Calendar.DATE);

      Day today = new Day(year, month+1, date);

      int daysAlive = today.daysFrom(birthDay) + 1;

      System.out.println( "Birthdate: " + dob);

      System.out.println( "Today: " + df.format(todayDate));

      System.out.println( "Days Alive: " + daysAlive);
   }
}

