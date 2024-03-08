import java.util.ArrayList;
import java.util.List;

/**
   A test for testing the CopyOnWriteList proxy
*/
public class CopyOnWriteListTester
{
   /**
      Constructs two CopyOnWriteLists, adds to one of them and compares
      hash codes.
      @param args unused
   */
   public static void main(String[] args)
   {
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(new Integer(1));
      list.add(new Integer(2));

      CopyOnWriteList<Integer> copy1 = new CopyOnWriteList<Integer>(list);
      CopyOnWriteList<Integer> copy2 = new CopyOnWriteList<Integer>(list);

      System.out.println(copy1.getList() == list);  // true
      System.out.println(copy2.getList() == list);  // true

      copy1.add(new Integer(3));

      System.out.println(copy1.getList() == list);  // false
      System.out.println(copy2.getList() == list);  // true

      List<Integer> temp = copy1.getList();

      copy1.add(new Integer(4));

      System.out.println(temp == copy1.getList());  // true
   }
}
