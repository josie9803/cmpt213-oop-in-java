import java.awt.event.*;

/**
   This class is used to get the properties of class JSlider.
   Note that it uses a modified version of Dumper.dumpClass 
   that gets all methods instead of just the declared methods.
*/
public class DumperTester
{
   /**
     This program calls a method that uses reflection to allow the user 
     to print information about a class
     @param args unused
   */
   public static void main(String[] args) 
   {
      javax.swing.JSlider r = new javax.swing.JSlider();
      Dumper.dumpClass(r);
   }
}

