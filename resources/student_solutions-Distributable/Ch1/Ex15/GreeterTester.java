import edu.sjsu.cs.CS200.johnDoe.Greeter;

/**
  A class for testing packages.
*/
public class GreeterTester
{
   /**
     Creates and uses a greeter object using a class that is in a package.
     @param args unused
   */
   public static void main(String[] args)
   {
      Greeter worldGreeter = new Greeter("World");
      String greeting = worldGreeter.sayHello();
      System.out.println(greeting);
   }
}
