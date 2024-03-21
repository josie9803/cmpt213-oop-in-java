package ca.cmpt213.as4.trivial_model;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.UI.ColorMapper;

import java.awt.*;

public class FillTextModel extends CharLineBorder {

    public FillTextModel(ShapeDescription description) {
        super(description);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas); // Call the superclass draw method to draw the border

        // Additional logic for filling the text inside the border
        String fillText = description.getFillText();
        Color textColor = ColorMapper.getColor(description.getBackgroundColor()); // Using background color for text color

        for (int i = 1; i < description.getHeight() - 1; i++) {
            for (int j = 1; j < description.getWidth() - 1; j++) {
                canvas.setCellColor(description.getLeft() + j, description.getTop() + i, textColor);
                canvas.setCellText(description.getLeft() + j, description.getTop() + i, fillText.charAt(0)); // Using the first character of fillText
            }
        }
    }
}