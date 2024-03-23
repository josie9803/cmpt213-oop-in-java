package ca.cmpt213.as4.DrawBorder;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;

public class SequenceBorder implements Border {
//    @Override
//    public void drawBorder(Canvas canvas, ShapeDescription description) {
//        int currentRow = 0;
//        int currentCol = 0;
//        char currentNumber = '1';
//
//        for (; currentCol < description.getWidth(); currentCol++) {
//            canvas.setCellText(currentCol + description.getLeft(),
//                    currentRow + description.getTop(), currentNumber);
//            currentNumber = getNextNumber(currentNumber);
//        }
//
//        for (currentCol--, currentRow++; currentRow < description.getHeight(); currentRow++) {
//            canvas.setCellText(currentCol + description.getLeft(),
//                    currentRow + description.getTop(), currentNumber);
//            currentNumber = getNextNumber(currentNumber);
//        }
//
//        currentRow--;
//        currentCol--;
//
//        if (currentRow == 0 && currentCol == 0){
//            return;
//        }
//
//        for (;currentCol > -1; currentCol--) {
//            canvas.setCellText(currentCol + description.getLeft(),
//                    currentRow + description.getTop(), currentNumber);
//            currentNumber = getNextNumber(currentNumber);
//        }
//
//        for (currentCol++, currentRow--; currentRow > 0; currentRow--) {
//            canvas.setCellText(currentCol + description.getLeft(),
//                    currentRow + description.getTop(), currentNumber);
//            currentNumber = getNextNumber(currentNumber);
//        }
//    }

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
