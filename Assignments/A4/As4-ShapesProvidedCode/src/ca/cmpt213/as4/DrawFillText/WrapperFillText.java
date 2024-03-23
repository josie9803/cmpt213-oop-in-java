package ca.cmpt213.as4.DrawFillText;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.trivial_model.ShapeDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * Idea from this repo: https://github.com/erminwang/cmpt-213/blob/master/A4_Shapes/src/ca/cmpt213/as4/shapes/TextBox.java
 */
public class WrapperFillText implements FillText{
    @Override
    public void drawFillText(Canvas canvas, ShapeDescription description) {
        int lineWidth = description.getWidth() - 2;
        String[] messageArray = description.getFillText().split("\\s+");
        List<String> messageList = new ArrayList<>();
        String lineBuffer = "";
        for (int i = 0; i < messageArray.length; i++) {
            String word = messageArray[i].trim();
            if (word.length() == 0) {
                continue;
            }
            if (lineBuffer.length() > lineWidth) {
                messageList.add(lineBuffer.substring(0, lineWidth));
                lineBuffer = lineBuffer.substring(lineWidth);
                i--;
            } else if (lineBuffer.equals("")) {
                lineBuffer = word;
            } else if (lineBuffer.length() + word.length() + 1 > lineWidth) { //1 for a space between two words
                messageList.add(lineBuffer);
                lineBuffer = "";
                i--;
            } else {
                lineBuffer += " " + word;
            }
        }
        while (lineBuffer.length() > lineWidth) {
            messageList.add(lineBuffer.substring(0, lineWidth));
            lineBuffer = lineBuffer.substring(lineWidth);
        }
        messageList.add(lineBuffer);

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
