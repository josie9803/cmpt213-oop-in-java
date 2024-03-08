import java.io.*;

/**
   Finds files whose names contain a given keyword
*/
public class VisitorTester
{
   /**
      Finds files and print file names that have a keyword specified 
      as a command line argument.  Begins visit in parent of current 
      directory.
      @param args the string to search for
   */
   public static void main(String[] args)
   {
      DirectoryNode node = new DirectoryNode(new File(".."));
      FindVisitor findVisitor = new FindVisitor(args[0]);
      node.accept(findVisitor);
      System.out.println(findVisitor.getFileList());
   }   
}
