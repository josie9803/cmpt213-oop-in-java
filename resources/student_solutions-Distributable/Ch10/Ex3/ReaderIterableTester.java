import java.io.*;

/**
   Tests the ReaderIterable class
*/
public class ReaderIterableTester
{
   public static void main(String[] args)
   {
      ReaderIterable test = new ReaderIterable(new StringReader("1 22 333"));
      for (Integer i : test)
      {
         System.out.println(i);
      }
   }
}
