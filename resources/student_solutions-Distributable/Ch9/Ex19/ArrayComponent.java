import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
   This component draws an array and marks two elements in the
   array.
*/
public class ArrayComponent extends JComponent
{
   public synchronized void paintComponent(Graphics g)
   {
      if (values == null) return;
      Graphics2D g2 = (Graphics2D) g;
      int width = getWidth() / values.length;
      for (int i = 0; i < values.length; i++)
      {
         int v =  values[i];
         Rectangle2D bar = new Rectangle2D.Double(
            width * i, 0, width, v);
         if (i == marked1 || i == marked2)
            g2.fill(bar);
         else
            g2.draw(bar);
      }
   }

   /**
      Sets the values to be painted.
      @param values the array of values to display
      @param marked1 the first marked position
      @param marked2 the second marked position
   */
   public synchronized void setValues(int[] values,
      int marked1, int marked2)
   {
      this.values = (int[]) values.clone();
      this.marked1 = marked1;
      this.marked2 = marked2;
      repaint();
   }

   private int[] values;
   private int marked1;
   private int marked2;
}
