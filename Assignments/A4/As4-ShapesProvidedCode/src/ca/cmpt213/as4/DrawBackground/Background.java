package ca.cmpt213.as4.DrawBackground;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;
/**
 * Defines a Background interface
 * Classes that implements this interface can draw Background based on the ShapeDescription
 */
public interface Background {
    void drawBackground(Canvas canvas, ShapeDescription description);
}
