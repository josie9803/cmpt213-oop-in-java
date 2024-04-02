package ca.cmpt213.as4.DrawFillText;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * A concrete class of FillText interface
 * Requirement: Use the fillText string to fill the box full of text. See sub-section below for details
 * Code reference from this repo: https://github.com/erminwang/cmpt-213/blob/master/A4_Shapes/src/ca/cmpt213/as4/shapes/TextBox.java
 * with modifications.
 */
public class WrapperFillText implements FillText{
    @Override
    public void drawFillText(Canvas canvas, ShapeDescription description) {
        int lineWidth = description.getWidth() - 2;
        String[] messageArray = description.getFillText().split("\\s+");
        List<String> messageList = new ArrayList<>();
        StringBuilder lineBuffer = new StringBuilder();
        for (int i = 0; i < messageArray.length; i++) {
            String word = messageArray[i].trim();
            if (word.isEmpty()) {
                continue;
            }
            if (lineBuffer.length() > lineWidth) {
                messageList.add(lineBuffer.substring(0, lineWidth));
                lineBuffer = new StringBuilder(lineBuffer.substring(lineWidth));
                i--;
            } else if (lineBuffer.toString().equals("")) {
                lineBuffer = new StringBuilder(word);
            } else if (lineBuffer.length() + word.length() + 1 > lineWidth) {
                messageList.add(lineBuffer.toString());
                lineBuffer = new StringBuilder();
                i--;
            } else {
                lineBuffer.append(" ").append(word);
            }
        }
        while (lineBuffer.length() > lineWidth) {
            messageList.add(lineBuffer.substring(0, lineWidth));
            lineBuffer = new StringBuilder(lineBuffer.substring(lineWidth));
        }
        messageList.add(lineBuffer.toString());

        for (int j = 0; j < messageList.size() && j < description.getHeight() - 2; j++) {
            String line = messageList.get(j);
            int spacesOnTheLeft = (lineWidth - line.length()) / 2 + (lineWidth - line.length()) % 2;
            for (int i = spacesOnTheLeft + 1; i < spacesOnTheLeft + line.length() + 1; i++) {
                canvas.setCellText(description.getLeft() + i, description.getTop() + j + 1,
                        line.charAt(i - spacesOnTheLeft - 1));
            }
        }
    }
}
