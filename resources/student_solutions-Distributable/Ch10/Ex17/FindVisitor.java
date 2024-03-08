import java.io.*;
import java.util.ArrayList;

/**
   Finds files whose names contain a given keyword
*/
public class FindVisitor implements FileSystemVisitor
{
   /**
      Construct a FindVisitor for the given target.
      @param target the string to find
   */
   public FindVisitor(String target)
   {
      this.target = target;
      this.fileList = new ArrayList<String>();
   }


   /**
      Check a single file to see if its name contains the target string
      @param target the string to find
   */
   public void visitFileNode(FileNode node)
   {
      String name = node.getFile().getName();
      checkName(name);
   }

   /**
      Check a directory to see if its name or the names of any of its
      children contain the target string
      @param target the string to find
   */
   public void visitDirectoryNode(DirectoryNode node)
   {
      String name = node.getDirectory().getName();
      checkName(name);

      FileSystemNode[] children = node.getChildren();
      for (FileSystemNode c : children)
         c.accept(this);
   }

   /**
      Get the list of files
   */
   public ArrayList<String> getFileList()
   {
      return (ArrayList<String>) fileList.clone();
   }

   /**
      Check if a name contains the target string.  If so, collect the name.
      @param target the string to find
   */
   private void checkName(String name)
   {
      if (name.indexOf(target) >= 0)
         fileList.add(name);
   }

   private String target;

   private ArrayList<String> fileList;
}
