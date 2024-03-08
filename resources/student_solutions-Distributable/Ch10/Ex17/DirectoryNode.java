import java.io.*;

public class DirectoryNode implements FileSystemNode
{
   public DirectoryNode(File directory)
   {
      this.directory = directory;
   }

   public void accept(FileSystemVisitor v)
   {
      v.visitDirectoryNode(this);
   }

   public File getDirectory() { return directory; }

   public FileSystemNode[] getChildren()
   {
      File[] files = directory.listFiles();
      FileSystemNode[] children
         = new FileSystemNode[files.length];
      int i = 0;
      for (File f : files)
      {
         if (f.isDirectory())
            children[i] = new DirectoryNode(f);
         else
            children[i] = new FileNode(f);
         i++;
      }
      return children;
   }

   private File directory;
}
