package ca.cmpt213.as4.DrawFillText;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;
/**
 * Defines a FillText interface
 * Classes that implements this interface can draw FillText based on the ShapeDescription
 */
public interface FillText {
    void drawFillText(Canvas canvas, ShapeDescription description);
}
