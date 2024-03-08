import javax.swing.*;

/**
   A class for testing the MugIcon class
*/
public class MugIconTester
{
   /**
      Create a MugIcon object as part of a MessageDialog
      @param args unused
   */
   public static void main(String[] args)
   {
      JOptionPane.showMessageDialog(
            null,
            "Have a cup!",
            "Message",
            JOptionPane.INFORMATION_MESSAGE,
            new MugIcon(400)
            );

      JOptionPane.showMessageDialog(
            null,
            "Have a cup!",
            "Message",
            JOptionPane.INFORMATION_MESSAGE,
            new MugIcon(200)
            );

      JOptionPane.showMessageDialog(
            null,
            "Have a cup!",
            "Message",
            JOptionPane.INFORMATION_MESSAGE,
            new MugIcon(100)
            );

      System.exit(0);
   }
}
