import java.util.*;

/**
   A class for using a Scanner to input a name and create
   a greeter with that name.
*/
public class GreeterTester
{
   /**
      Creates a Scanner and creates and uses a greeter object from the
      string that was entered.
      @param args unused
   */
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter your name: ");
      String input = in.nextLine();

      Greeter worldGreeter = new Greeter(input);
      String greeting = worldGreeter.sayHello();
      System.out.println(greeting);
   }
}
