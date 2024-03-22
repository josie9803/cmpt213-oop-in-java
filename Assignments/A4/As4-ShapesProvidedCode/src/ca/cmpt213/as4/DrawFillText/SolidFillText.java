package ca.cmpt213.as4.DrawFillText;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.UI.ColorMapper;
import ca.cmpt213.as4.trivial_model.ShapeDescription;

import java.awt.*;

public class SolidFillText implements FillText{
    @Override
    public void drawFillText(Canvas canvas, ShapeDescription description) {
        String fillText = description.getFillText();
        Color textColor = ColorMapper.getColor(description.getBackgroundColor());

        for (int i = 1; i < description.getHeight() - 1; i++) {
            for (int j = 1; j < description.getWidth() - 1; j++) {
                canvas.setCellColor(description.getLeft() + j, description.getTop() + i, textColor);
                canvas.setCellText(description.getLeft() + j, description.getTop() + i, fillText.charAt(0));
            }
        }
    }
}