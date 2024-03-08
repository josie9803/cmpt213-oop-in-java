import java.awt.*;
import java.awt.geom.*;
import java.io.*;

/**
   A rectangular node that is filled with a color.
*/
public class RectangleNode implements Node
{
   /**
      Construct a rectangle node with a given color and the default width
      and height.
      @param aColor the fill color
   */
   public RectangleNode(Color aColor)
   {
      height = DEFAULT_SIZE;
      width = DEFAULT_SIZE;
      x = 0;
      y = 0;
      color = aColor;
   }

   public void setColor(Color aColor)
   {
      color = aColor;
   }

   public Color getColor()
   {
      return color;
   }


   public Object clone()
   {
      try
      {
         return super.clone();
      }
      catch (CloneNotSupportedException exception)
      {
         return null;
      }
   }

   public void draw(Graphics2D g2)
   {
      Rectangle2D rectangle = new Rectangle2D.Double(
         x, y, width, height);
      Color oldColor = g2.getColor();
      g2.setColor(color);
      g2.fill(rectangle);
      g2.setColor(oldColor);
      g2.draw(rectangle);
   }

   public void translate(double dx, double dy)
   {
      x += dx;
      y += dy;
   }

   public boolean contains(Point2D p)
   {
      Rectangle2D rectangle = new Rectangle2D.Double(
         x, y, width, height);
      return rectangle.contains(p);
   }

   public Rectangle2D getBounds()
   {
      return new Rectangle2D.Double(
         x, y, width, height);
   }

   public Point2D getConnectionPoint(Point2D other)
   {
      double halfHeight = height / 2;
      double halfWidth = width / 2;

      double centerX = x + halfWidth;
      double centerY = y + halfHeight;

      double dx = other.getX() - centerX;
      double dy = other.getY() - centerY;
      double distance = Math.sqrt(dx * dx + dy * dy);


      if (distance == 0)
         return other;

      double xOffset;
      double yOffset;
      if (dx == 0)
      {
         xOffset = 0;
         yOffset = halfHeight * sign(dy);
      }
      else if (dy == 0)
      {
         xOffset = halfWidth * sign(dx);
         yOffset = 0;
      }
      else
      {
         xOffset =
            Math.min(halfWidth, Math.abs(halfHeight * dx / dy)) * sign(dx);

         yOffset =
            Math.min(halfHeight, Math.abs(halfWidth * dy / dx)) * sign(dy);
      }

      return new Point2D.Double(centerX + xOffset, centerY + yOffset);
   }

   private final double sign(double d)
   {
      if (d >= 0)
         return 1.0;
      else
         return -1.0;

   }
   private int x;
   private int y;
   private int width;
   private int height;
   private Color color;
   private static final int DEFAULT_SIZE = 20;
}
