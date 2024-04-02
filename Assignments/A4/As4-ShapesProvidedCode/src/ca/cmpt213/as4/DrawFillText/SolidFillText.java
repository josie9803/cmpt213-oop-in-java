package ca.cmpt213.as4.DrawFillText;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;
/**
 * A concrete class of FillText interface
 * Requirement: Each cell filled with first character of fillText (not including the border)
 */
public class SolidFillText implements FillText{
    @Override
    public void drawFillText(Canvas canvas, ShapeDescription description) {
        String fillText = description.getFillText();

        for (int row = 1; row < description.getHeight() - 1; row++) {
            for (int col = 1; col < description.getWidth() - 1; col++) {
                canvas.setCellText(description.getLeft() + col, description.getTop() + row, fillText.charAt(0));
            }
        }
    }
}