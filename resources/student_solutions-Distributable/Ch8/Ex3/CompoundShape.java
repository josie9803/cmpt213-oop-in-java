import java.awt.*;
import java.awt.geom.*;

/**
   A scene shape that is composed of multiple geometric shapes.
*/
public abstract class CompoundShape extends SelectableShape
{
   public CompoundShape()
   {
      path = new GeneralPath();
   }

   protected void add(Shape s)
   {
      path.append(s, false);
   }

   public boolean contains(Point2D aPoint)
   {
      return path.contains(aPoint);
   }

   public void translate(double dx, double dy)
   {
      AffineTransform t 
         = AffineTransform.getTranslateInstance(dx, dy);
      path.transform(t);
   }

   public void draw(Graphics2D g2)
   {
      g2.draw(path);
   }
   
   private GeneralPath path;
}







