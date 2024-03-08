/**
   A class for testing unicode
*/

public class GreetSanJose
{
   /**
      Prints a string with a unicode escape character in it.
      @param args unused
   */
   public static void main(String[] args)
   {
      // Character 00E9 in Latin 1 supplement is 
      //   small letter e with grave accent
      String greeting = "Hello, San Jos\u00E9";
      System.out.println(greeting);
   }
}
