package ca.cmpt213.as4.model.characterfillers;

import ca.cmpt213.as4.model.FlexBox;
import ca.cmpt213.as4.model.Coord;

public interface CharacterFiller {
    char getFillCharacter(Coord coord, FlexBox b);
}
