import java.io.Reader;
import java.util.*;


public class ReaderIterable implements Iterable<Integer>
{
   ReaderIterable(Reader in)
   {
      s = new Scanner(in);
   }

   public Iterator<Integer> iterator()
   {
      return new Itr();
   }

   private class Itr implements Iterator<Integer>
   {
      public boolean hasNext()
      {
        return s.hasNextInt();
      }
      public Integer next()
      {
        return s.nextInt();
      }
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
   }

   private Scanner s;
}
