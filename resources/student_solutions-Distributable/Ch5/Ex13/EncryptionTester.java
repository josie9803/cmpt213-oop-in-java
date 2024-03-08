import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;


/** 
   Tests the EncryptingWriter and DecryptingReader classes
*/
class EncryptionTester
{
   /** 
     Creates EncryptingWriter and DecryptingReader objects and uses them
     to write to and read from a file
   */
   public static void main(String[] args) throws IOException
   {
      EncryptingWriter e = new EncryptingWriter(new FileWriter("test.out"));
      e.write("abcdefghijklmnopqrstuvwxyz1abcdefghijklmnopqrstuvwxyz", 20, 27);
      e.write("ABCDEFGHIJKLMNOPQRSTUVWXYZ1ABCDEFGHIJKLMNOPQRSTUVWXYZ", 20, 27);

      PrintWriter w = new PrintWriter(e, true);  // autoflush mode
      w.println("abcdefghijkl2mnopqrstuvwxyz");
      w.println("ABCDEFGHIJKL2MNOPQRSTUVWXYZ");

      char inChars[] = 
         "----------------------------------------------".toCharArray();

      DecryptingReader r = new DecryptingReader(new FileReader("test.out"));
      r.read(inChars, 10, 27);
      System.out.println(inChars);
      r.read(inChars, 10, 27);
      System.out.println(inChars);

      BufferedReader b = new BufferedReader(r);
      String s = b.readLine();
      System.out.println(s);
      s = b.readLine();
      System.out.println(s);
   } 
}
