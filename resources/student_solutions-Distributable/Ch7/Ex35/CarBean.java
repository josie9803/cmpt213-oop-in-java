import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
   A panel that draws a car shape.
*/
public class CarBean extends JComponent
{
   /**
      Constructs a default car bean.
   */
   public CarBean()
   {
      x = 0;
      y = 0;
      width = DEFAULT_WIDTH;
      height = DEFAULT_HEIGHT;
      color = DEFAULT_COLOR;
   }

   /**
      Sets the color property.
      @param color the new color
   */
   public void setColor(Color color)
   {
      this.color = color;
      repaint();
   }

   /**
      Gets the color property.
      @return the current color
   */
   public Color getColor() { return color; }

   /**
      Sets the dimension property.
      @param dimension the new dimension of the house
   */
   public void setDimension(Dimension dimension)
   {
      width = (int) dimension.getWidth();
      height = (int) dimension.getHeight();
      repaint();
   }

   /**
      Gets the dimension property.
      @return the current dimension of the house
   */
   public Dimension getDimension()
   {
      return new Dimension(width, height);
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      Rectangle2D.Double body
         = new Rectangle2D.Double(x, y + height / 3,
            width - 1, height / 3);
      Ellipse2D.Double frontTire
         = new Ellipse2D.Double(x + width / 6,
            y + height * 2 / 3, height / 3, height / 3);
      Ellipse2D.Double rearTire
         = new Ellipse2D.Double(x + width * 2 / 3,
            y + height * 2 / 3, height / 3, height / 3);

      // the bottom of the front windshield
      Point2D.Double r1
         = new Point2D.Double(x + width / 6, y + height / 3);
      // the front of the roof
      Point2D.Double r2
         = new Point2D.Double(x + width / 3, y);
      // the rear of the roof
      Point2D.Double r3
         = new Point2D.Double(x + width * 2 / 3, y);
      // the bottom of the rear windshield
      Point2D.Double r4
         = new Point2D.Double(x + width * 5 / 6, y + height / 3);
      Line2D.Double frontWindshield
         = new Line2D.Double(r1, r2);
      Line2D.Double roofTop
         = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield
         = new Line2D.Double(r3, r4);

      g2.setColor(color);
      g2.fill(body);
      g2.fill(frontTire);
      g2.fill(rearTire);
      g2.draw(frontWindshield);
      g2.draw(roofTop);
      g2.draw(rearWindshield);
   }

   private int x;
   private int y;
   private Color color;
   private int width;
   private int height;

   private static final int DEFAULT_WIDTH = 50;
   private static final int DEFAULT_HEIGHT = 80;
   private static final Color DEFAULT_COLOR = Color.BLACK;
}


