package ca.cmpt213.as4.model.linestylers;

import ca.cmpt213.as4.model.FlexBox;
import ca.cmpt213.as4.model.Coord;

public interface LineStyler {
    char getLineStyleAt(Coord coord, FlexBox b);
}

