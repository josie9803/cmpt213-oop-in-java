package ca.cmpt213.as4.DrawBorder;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;
/**
 * Defines a Border interface
 * Classes that implements this interface can draw Border based on the ShapeDescription
 */
public interface Border {
    void drawBorder(Canvas canvas, ShapeDescription description);
}
