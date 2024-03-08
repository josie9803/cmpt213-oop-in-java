/**
 * A class for testing the generic Pair<E> class.
 */
public class PairTester
{
   public static void main(String[] args)
   {
      Pair<Integer> p = new Pair<Integer>(2,3);

      System.out.println(p.getFirst() +  " : " + p.getSecond());

      p.setFirst(3);
      p.setSecond(4);

      System.out.println(p.getFirst() +  " : " + p.getSecond());
   }
}
