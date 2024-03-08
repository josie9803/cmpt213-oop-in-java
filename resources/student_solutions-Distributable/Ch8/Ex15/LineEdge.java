import java.awt.*;
import java.awt.geom.*;

/**
   An edge that is shaped like a straight line.
   Modified to include a label.
*/
public class LineEdge extends AbstractEdge
{
   public LineEdge()
   {
      lineStyle = LineStyle.SOLID;
   }

   public void draw(Graphics2D g2)
   {
      Stroke oldStroke = g2.getStroke();
      Line2D line = getConnectionPoints();
      float midX = (float) ((line.getX1() + line.getX2()) / 2.0); 
      float midY = (float) ((line.getY1() + line.getY2()) / 2.0); 

      g2.setStroke(lineStyle.getStroke());
      g2.draw(line);
      g2.drawString(label, midX, midY);
      g2.setStroke(oldStroke);
   }

   public boolean contains(Point2D aPoint)
   {
      final double MAX_DIST = 2;
      return getConnectionPoints().ptSegDist(aPoint) 
         < MAX_DIST;
   }

   /**
      Sets the label property.
      @param newValue the new value
   */
   public void setLabel(String newValue) { label = newValue; }

   /**
      Gets the label property.
      @return the label
   */
   public String getLabel() { return label; }
   /**
      Sets the line style property.
      @param newValue the new value
   */

   public void setLineStyle(LineStyle newValue) { lineStyle = newValue; }

   /**
      Gets the line style property.
      @return the line style
   */
   public LineStyle getLineStyle() { return lineStyle; }
   
   private LineStyle lineStyle;
   private String label = "";
}
