package ca.cmpt213.as4.model.linestylers;

import ca.cmpt213.as4.model.FlexBox;
import ca.cmpt213.as4.model.Coord;

public class SingleCharacterLineStyler implements LineStyler{
    private final char fill;

    public SingleCharacterLineStyler(char fill) {
        this.fill = fill;
    }

    @Override
    public char getLineStyleAt(Coord coord, FlexBox b) {
        return fill;
    }
}
