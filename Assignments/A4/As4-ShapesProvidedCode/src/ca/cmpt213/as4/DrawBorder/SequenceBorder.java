package ca.cmpt213.as4.DrawBorder;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;
/**
 * A concrete class of Border interface
 * Requirement: Draw the border with the numbers 1 through 5.
 * Starting in the top left with a 1, count up to 5 as you go around the box clockwise.
 * When you get to 5, the next character will be 1.
 */
public class SequenceBorder implements Border {
    private char getNextNumber(char currentNumber) {
        int nextNumber = (Character.getNumericValue(currentNumber) % 5) + 1;
        System.out.println(nextNumber);
        return Character.forDigit(nextNumber, 10);
    }

    @Override
    public void drawBorder(Canvas canvas, ShapeDescription description){
        int currentRow = 0;
        int currentCol = 0;
        char currentNumber = '1';

        while(currentCol < description.getWidth()){
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), currentNumber);
            currentNumber = getNextNumber(currentNumber);
            currentCol++;
        }
        currentCol--;
        currentRow++;

        while(currentRow < description.getHeight()){
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), currentNumber);
            currentNumber = getNextNumber(currentNumber);
            currentRow++;
        }
        currentRow--;
        currentCol--;

        if (currentRow == 0 && currentCol == 0){
            return;
        }

        while (currentCol > -1) {
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), currentNumber);
            currentNumber = getNextNumber(currentNumber);
            currentCol--;
        }
        currentCol++;
        currentRow--;

        while (currentRow > 0) {
            canvas.setCellText(currentCol + description.getLeft(),
                    currentRow + description.getTop(), currentNumber);
            currentNumber = getNextNumber(currentNumber);
            currentRow--;
        }

    }

}
