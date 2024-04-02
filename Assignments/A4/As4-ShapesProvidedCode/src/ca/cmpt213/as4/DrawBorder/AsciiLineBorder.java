package ca.cmpt213.as4.DrawBorder;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;
/**
 * A concrete class of Border interface
 * Requirement: Draw the border with ║, ═, ╚, ╝, ╔, and ╗.
 * Use ■ for any box with width or height 1
 */
public class AsciiLineBorder implements Border {
    @Override
    public void drawBorder(Canvas canvas, ShapeDescription description) {
        int currentRow = 0;
        int currentCol = 0;
        char horizontalChar = '═';
        char verticalChar = '║';
        char topLeftChar = '╔';
        char topRightChar = '╗';
        char bottomLeftChar = '╚';
        char bottomRightChar = '╝';
        char blockChar = '■';

        if (description.getWidth() == 1){
            for (int i = 0; i < description.getHeight(); i++){
                canvas.setCellText(currentCol + description.getLeft(),
                        i + description.getTop(), blockChar);
            }
            return;
        }
        else if (description.getHeight() == 1){
            for (int i = 0; i < description.getWidth(); i++){
                canvas.setCellText(i + description.getLeft(),
                        currentRow + description.getTop(), blockChar);
            }
            return;
        }

        while (currentCol < description.getWidth()) {
            if (currentCol == 0) {
                canvas.setCellText(currentCol + description.getLeft(),
                        currentRow + description.getTop(), topLeftChar);
            } else if (currentCol == description.getWidth() - 1) {
                canvas.setCellText(currentCol + description.getLeft(),
                        currentRow + description.getTop(), topRightChar);
            } else {
                canvas.setCellText(currentCol + description.getLeft(),
                        currentRow + description.getTop(), horizontalChar);
            }
            currentCol++;
        }
        currentCol--;
        currentRow++;

        while (currentRow < description.getHeight()) {
            if (currentRow == description.getHeight() - 1) {
                canvas.setCellText(currentCol + description.getLeft(),
                        currentRow + description.getTop(), bottomRightChar);
            } else {
                canvas.setCellText(currentCol + description.getLeft(),
                        currentRow + description.getTop(), verticalChar);
            }
            currentRow++;
        }
        currentRow--;
        currentCol--;

        if (currentRow == 0 && currentCol == 0) {
            return;
        }

        while (currentCol > -1) {
            if (currentCol == 0){
                canvas.setCellText(currentCol + description.getLeft(),
                        currentRow + description.getTop(), bottomLeftChar);
            }
            else {
                canvas.setCellText(currentCol + description.getLeft(),
                        currentRow + description.getTop(), horizontalChar);
            }
            currentCol--;
        }
        currentCol++;
        currentRow--;

        while (currentRow > 0) {
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), verticalChar);
            currentRow--;
        }
    }
}
