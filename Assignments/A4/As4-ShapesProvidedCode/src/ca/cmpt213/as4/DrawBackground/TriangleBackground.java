package ca.cmpt213.as4.DrawBackground;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.UI.ColorMapper;
import ca.cmpt213.as4.trivial_model.ShapeDescription;

import java.awt.*;
/**
 * A concrete class of Background interface
 * Requirements: top-right half of the box will be filled in with backgroundColor;
 * the bottom-left will be white. Color the main diagonal the backgroundColor.
 */
public class TriangleBackground implements Background{
    @Override
    public void drawBackground(Canvas canvas, ShapeDescription description) {
        Color bgColor = ColorMapper.getColor(description.getBackgroundColor());

        for (int row = 0; row < description.getHeight(); row++) {
            for (int col = 0; col < description.getWidth(); col++) {
                if (col >= row) {
                    canvas.setCellColor(description.getLeft() + col, description.getTop() + row, bgColor);
                } else {
                    canvas.setCellColor(description.getLeft() + col, description.getTop() + row, Color.WHITE);
                }

                if (col == row) {
                    canvas.setCellColor(description.getLeft() + col, description.getTop() + row, bgColor);
                }
            }
        }
    }
}
