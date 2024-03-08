public class WordCountTester
{
   /**
      Creates WordCount objects to count the words in the files
      specified in the command line arguments.
      @param args the list of files in which to count the words
   */
   public static void main(String args[])
   {
      for (String filename : args)
      {
         Runnable wcr = new WordCount(filename);

         Thread t = new Thread(wcr);
         t.start();
      }
   }
}
