/**
   A class for testing reference variables by declaring two variables that
   point to the same Greeter object.
*/ 
public class GreeterTester 
{
   /**
      Creates a greeter object with two references, changes the name with
      one reference and then prints the greeting produced by the other
      reference.
      @param args unused
   */ 
   public static void main(String[] args) { 
      Greeter worldGreeter1 = new Greeter("World"); 
      Greeter worldGreeter2 = worldGreeter1;

      worldGreeter2.setName("Java");

      String greeting = worldGreeter1.sayHello();
      System.out.println(greeting);
   }
}
