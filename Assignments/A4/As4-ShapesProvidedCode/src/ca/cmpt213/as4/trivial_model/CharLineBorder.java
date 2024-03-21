package ca.cmpt213.as4.trivial_model;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.UI.ColorMapper;
import ca.cmpt213.as4.UI.DrawableShape;

import java.awt.*;

public class CharLineBorder implements DrawableShape {
    protected ShapeDescription description;

    public CharLineBorder(ShapeDescription description) {
        this.description = description;
    }

    @Override
    public void draw(Canvas canvas) {
        char lineChar = description.getLineChar().charAt(0);
        Color bgColor = ColorMapper.getColor(description.getBackgroundColor());

        for (int i = 0; i < description.getHeight(); i++) {
            for (int j = 0; j < description.getWidth(); j++) {
                canvas.setCellColor(description.getLeft() + j, description.getTop() + i, bgColor);
                canvas.setCellText(description.getLeft() + j, description.getTop() + i, lineChar);
            }
        }
    }

}
