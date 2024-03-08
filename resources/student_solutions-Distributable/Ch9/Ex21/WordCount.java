import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
   Counts and reports the number of words in each of a group of files.
   Each count is done in a separate thread.
*/
public class WordCount implements Runnable
{
   /**
      Creates a WordCount objects that will count the words in the specified
      file
      @param filename the name of the file to count
   */
   public WordCount(String filename)
   {
      this.filename = filename;
   }

   public void run()
   {
      int count = 0;
      try
      {
         Scanner in = new Scanner(new File(filename));

         while (in.hasNext())
         {
            in.next();
            count++;
         }
         System.out.println(filename + ": " + count);
      }
      catch (FileNotFoundException e)
      {
         System.out.println(filename + " not found!");
      }
   }

   private String filename;
}
