import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.Font;
import java.awt.font.FontRenderContext;

/**
  A class for labeled points
*/
public class LabeledRectangle extends Rectangle
{
   /**
      Constructs a LabeledRectangle object
      @param x the x location of the LabeledRectangle
      @param y the y location of the LabeledRectangle
      @param width the width of the LabeledRectangle
      @param height the height of the LabeledRectangle
      @param text the label for the LabeledRectangle
   */
   public LabeledRectangle(int x, int y, int width, int height, String text)
   {
      super(x, y, width, height);
      this.text = text;
   }

   /**
      Draws the labeled rectangle
      @param g the Graphics object for drawing the point
   */
   public void draw(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      g2.draw(new Rectangle2D.Double(x, y, width, height));


      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D bounds = font.getStringBounds(text, context);

      double ascent = -bounds.getY();
      double descent = bounds.getHeight() - ascent;
      double extent = bounds.getWidth();

      double xLoc = x + (width - extent) / 2;
      double yLoc = y + (height + ascent - descent) / 2;

      g2.drawString(text, (int) xLoc, (int) yLoc);
   }

   private String text;
}
