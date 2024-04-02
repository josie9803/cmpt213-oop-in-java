package ca.cmpt213.as4.model.characterfillers;

import ca.cmpt213.as4.model.Coord;
import ca.cmpt213.as4.model.FlexBox;

public class WordWrapperCharacterFiller implements CharacterFiller{
    private final String text;
    private WordWrapper wrapper;
    private final int BORDER_WIDTH = 1;

    public WordWrapperCharacterFiller(String text) {
        this.text = text;
    }
    @Override
    public char getFillCharacter(Coord coord, FlexBox b) {
        int width = b.getBottomRight().getX() - b.getTopLeft().getX() + 1;
        int maxCharPerLine = width - 2 * BORDER_WIDTH;

        // Only instantiate it once to save processing
        if (wrapper == null) {
            wrapper = new WordWrapper(text, maxCharPerLine);
        }

        int lineNum = coord.getY() - b.getTopLeft().getY() - BORDER_WIDTH;
        String line = wrapper.getLine(lineNum);

        // If odd amount of space, put extra space at front of line.
        int extraSpaces = maxCharPerLine - line.length();
        int extraSpacesAtStart = (int) Math.ceil((double)extraSpaces / 2);

        int charIdx = coord.getX() - b.getTopLeft().getX() - 1 - extraSpacesAtStart;
        if (charIdx >= 0 && charIdx < line.length()) {
            return line.charAt(charIdx);
        } else {
            return ' ';
        }
    }
}
