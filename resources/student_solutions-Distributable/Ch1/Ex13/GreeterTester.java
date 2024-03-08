/**
   A class for testing the effects on parameters of the methods in section 1.6
*/
public class GreeterTester
{
   /**
      Creates a greeter object then calls several methods and prints the
      values of the parameter variables before and after each call.
      @param args unused
   */
   public static void main(String[] args)
   {
      Greeter g1 = new Greeter("Adam");

      System.out.println("Output from before and after setName:");
      String aName = "George";
      System.out.println(aName);
      g1.setName(aName);
      System.out.println(aName);
      System.out.println();

      System.out.println("Output from before and after copyNameTo:");
      Greeter g2 = new Greeter("Brenda");
      System.out.println( g2.sayHello() );
      g1.copyNameTo(g2);
      System.out.println( g2.sayHello() );
      System.out.println();

      System.out.println("Output from before and after copyLengthTo:");
      int x = -1;
      System.out.println( x );
      g1.copyLengthTo(x);
      System.out.println( x );
      System.out.println();

      System.out.println("Output from before and after copyGreeterTo:");
      Greeter g3 = new Greeter("Carl");
      System.out.println( g3.sayHello() );
      g1.copyGreeterTo(g3);
      System.out.println( g3.sayHello() );
      System.out.println();

   }
}

