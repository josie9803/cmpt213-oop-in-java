package ca.cmpt213.as4.DrawBorder;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;
/**
 * A concrete class of Border interface
 * Requirement: Draw the border with the lineChar character
 */
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

        for (currentCol--, currentRow++; currentRow < description.getHeight(); currentRow++){
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), lineChar);
        }

        if (currentRow == 0 && currentCol == 0){
            return;
        }

        for (currentRow--, currentCol--; currentCol > -1; currentCol--){
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), lineChar);
        }

        for (currentCol++, currentRow--; currentRow > 0; currentRow--){
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), lineChar);
        }
    }
}
