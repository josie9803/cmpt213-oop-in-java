import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
   Draws a mars Icon using an anonymous class
*/
public class IconTester
{
   /**
      Constructs and displays a mars icon of a given size using an 
      anonymous constructor.
      @param args unused
   */
   public static void main(String[] args)
   {
      final int size = 50;
      Icon mars = new
         Icon()
         {
            public int getIconWidth()
            {
               return size;
            }

            public int getIconHeight()
            {
               return size;
            }

            public void paintIcon(Component c, Graphics g, int x, int y)
            {
               Graphics2D g2 = (Graphics2D)g;
               Ellipse2D.Double planet = new Ellipse2D.Double(x, y,
                     size, size);
               g2.setColor(Color.RED);
               g2.fill(planet);
            }
         };

      JOptionPane.showMessageDialog(
            null, 
            "Hello, Mars!",
            "Message",
            JOptionPane.INFORMATION_MESSAGE,
            mars);

      System.exit(0);
   }
}

