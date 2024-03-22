package ca.cmpt213.as4.DrawBorder;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;

public class AsciiLineBorder implements Border {
    @Override
    public void drawBorder(Canvas canvas, ShapeDescription description) {
        char horizontalChar = '═';
        char verticalChar = '║';
        char topLeftChar  = '╔';
        char topRightChar = '╗';
        char bottomLeftChar = '╚';
        char bottomRightChar = '╝';

        for (int row = 0; row < description.getHeight(); row++) {
            for (int col = 0; col < description.getWidth(); col++) {
                // Check if current cell is on border
                int positionedRow = row + description.getTop();
                int positionedCol = col +description.getLeft();

                boolean isHorizontalBorder = positionedRow == 0 || positionedRow == description.getHeight() - 1;
                boolean isVerticalBorder = positionedCol == 0 || positionedCol == description.getWidth() - 1;

                if (isHorizontalBorder) {
                    // Draw horizontal border
                    if (positionedCol == 0) {
                        canvas.setCellText(positionedCol, positionedRow, topLeftChar);
                        System.out.println(topLeftChar);
                    } else if (positionedCol == description.getWidth() - 1) {
                        canvas.setCellText(positionedCol, positionedRow, topRightChar);
                    } else {
                        canvas.setCellText(positionedCol, positionedRow, horizontalChar);
                    }
                } else if (isVerticalBorder) {
                    // Draw vertical border
                    if (positionedRow == description.getHeight() - 1 && col == 0) {
                        canvas.setCellText(positionedCol, positionedRow, bottomLeftChar);
                    } else if (positionedRow == description.getHeight() - 1 && col == description.getWidth() - 1) {
                        canvas.setCellText(positionedCol, positionedRow, bottomRightChar);
                    } else {
                        canvas.setCellText(positionedCol, positionedRow, verticalChar);
                    }
                }
            }
        }
    }
}
