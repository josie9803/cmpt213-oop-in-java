import java.awt.event.*;

/**
   A class for testing the contents of an anonymous inner class that
   accesses a local variable and a paramter from the enclosing scope.
*/
public class InnerClassDumpTester
{
   /**
     This program creates an instance of this class and in doing so, 
     creates and peeks into an instance of an anonymous inner class.
     @param args unused
   */
   public static void main(String[] args) 
   {
      new InnerClassDumpTester(3);
   }

   private InnerClassDumpTester(final int someParameter)
   {
      final int local1 = someParameter;
      final int local2 = 2;

      // Variable l references an instance of an anonymous inner class
      ActionListener l = new 
         ActionListener() 
         {
            private int inner;
            public void actionPerformed(ActionEvent e)
            {
               System.out.println(someParameter + local1 + local2 + field);
            }
         };

      // Peek at the anonymous inner class
      Dumper.dumpClass(l);
   }

   private int field;
}

/* OUTPUT:
class InnerClassDumpTester$1
   implements java.awt.event.ActionListener
{
   InnerClassDumpTester$1(InnerClassDumpTester,int,int);

   public void actionPerformed(java.awt.event.ActionEvent);

   private int inner;
   private final int val$someParameter;
   private final int val$local1;
   private final InnerClassDumpTester this$0;
}
*/
