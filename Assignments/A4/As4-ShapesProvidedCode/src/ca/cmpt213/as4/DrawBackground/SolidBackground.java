package ca.cmpt213.as4.DrawBackground;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.UI.ColorMapper;
import ca.cmpt213.as4.trivial_model.ShapeDescription;

import java.awt.*;

public class SolidBackground implements Background{
    @Override
    public void drawBackground(Canvas canvas, ShapeDescription description) {
        Color bgColor = ColorMapper.getColor(description.getBackgroundColor());

        for (int row = 0; row < description.getHeight(); row++) {
            for (int col = 0; col < description.getWidth(); col++) {
                canvas.setCellColor(description.getLeft() + col, description.getTop() + row, bgColor);
            }
        }
    }
}
