package ca.cmpt213.as4.DrawBorder;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;

public class CharLineBorder implements Border {
    @Override
    public void drawBorder(Canvas canvas, ShapeDescription description) {
        int currentRow = 0;
        int currentCol = 0;
        char lineChar = description.getLineChar().charAt(0);

        for (; currentCol < description.getWidth(); currentCol++){
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), lineChar);
        }

        for (currentCol--; currentRow < description.getHeight(); currentRow++){
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), lineChar);
        }

        for (currentRow--; currentCol > 0; currentCol--){
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), lineChar);
        }

        for (; currentRow > 0; currentRow--){
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), lineChar);
        }
    }
}
