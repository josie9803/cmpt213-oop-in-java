import util.Stack;

/**
   A class for testing the Stack class
*/
class StackTester
{
   /**
      Create and use a Stack object
      @param args unused
   */
   public static void main(String[] args)
   {
      Stack<String> s = new Stack<String>();
      s.push("A");
      s.push("B");
      s.push("C");
      while (s.size() > 0)
         System.out.println(s.pop());

      s.push("A");
      s.push("B");
      s.push("C");
      while (!s.isEmpty())
         System.out.println(s.pop());
   }
}
