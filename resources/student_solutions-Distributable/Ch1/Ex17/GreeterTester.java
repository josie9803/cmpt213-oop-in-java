/**
  A class for creating greeters for each command line argument and calling
  sayHello for each.
*/
public class GreeterTester
{
   /**
     Creates and prints the greeting from a greeter object created for
     each command line argument.
     @param args a greeter object is created for each of the command line
         arguments
   */
   public static void main(String[] args)
   {
      for (String s : args)
      {
         Greeter worldGreeter = new Greeter(s);
         String greeting = worldGreeter.sayHello();
         System.out.println(greeting);
      }
   }
}
