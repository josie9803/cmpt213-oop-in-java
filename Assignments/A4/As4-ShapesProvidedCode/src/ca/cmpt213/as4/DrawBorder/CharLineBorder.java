package ca.cmpt213.as4.DrawBorder;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;

public class CharLineBorder implements Border {
    @Override
    public void drawBorder(Canvas canvas, ShapeDescription description) {
        char lineChar = description.getLineChar().charAt(0);

        for (int row = 0; row < description.getHeight(); row++) {
            for (int col = 0; col < description.getWidth(); col++) {
                canvas.setCellText(description.getLeft() + col, description.getTop() + row, lineChar);
            }
        }
    }

}
