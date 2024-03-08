import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
  A class for drawing a coffee mug
*/
public class MugIcon implements Icon
{

   /**
      Constructs a MugIcon object
      @param aSize The size in pixels of the drawing
   */
   public MugIcon(int aSize)
   {
      size = aSize / 2;
   }

   public int getIconWidth()
   {
      return size * 2;
   }

   public int getIconHeight()
   {
      return size * 2;
   }

   public void paintIcon(Component c, Graphics g, int x, int y)
   {

      Graphics2D g2 = (Graphics2D) g;

      int offset = (int) (size / 3.0);
      int radius = size;
      int handleOffset = (int) (size / 5.0);

      Ellipse2D.Double handle = new Ellipse2D.Double
         (x+size/2+offset, y+offset+handleOffset, size, size);
      g2.setColor(Color.BLUE);
      g2.fill(handle);

      handle = new Ellipse2D.Double
         (x+3*size/4+offset, y+size/4+offset+handleOffset, size/2, size/2);
      g2.setColor(c.getBackground());
      g2.fill(handle);

      RoundRectangle2D.Double body = new RoundRectangle2D.Double
         (x+offset, y+offset, size, size*1.3, 10, 10);
      g2.setColor(Color.BLUE);
      g2.fill(body);

      Ellipse2D.Double top = new Ellipse2D.Double
         (x+offset, y+offset-size/10, size, size*0.3);
      g2.setColor(Color.GRAY);
      g2.fill(top);
   }

   private int size;
}
