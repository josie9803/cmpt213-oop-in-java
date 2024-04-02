package ca.cmpt213.as4.DrawBackground;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.UI.ColorMapper;
import ca.cmpt213.as4.trivial_model.ShapeDescription;

import java.awt.*;
/**
 * A concrete class of Background interface
 * Requirement: checkerboard pattern with the top left cell being backgroundColor,
 * alternating with white to make a checkerboard.
 */
public class CheckerBackground implements Background {
    @Override
    public void drawBackground(Canvas canvas, ShapeDescription description) {
        boolean isBackgroundCellColor = true;
        Color bgColor = ColorMapper.getColor(description.getBackgroundColor());
        for (int row = 0; row < description.getHeight(); row++) {
            for (int col = 0; col < description.getWidth(); col++) {
                if (isBackgroundCellColor) {
                    canvas.setCellColor(description.getLeft() + col, description.getTop() + row, bgColor);
                } else {
                    canvas.setCellColor(description.getLeft() + col, description.getTop() + row, Color.WHITE);
                }
                isBackgroundCellColor = !isBackgroundCellColor;
            }
            if (description.getWidth() % 2 == 0) {
                isBackgroundCellColor = !isBackgroundCellColor;
            }
        }
    }
}
