package ca.cmpt213.as4.model.characterfillers;

import ca.cmpt213.as4.model.FlexBox;
import ca.cmpt213.as4.model.Coord;

public class SolidCharacterFiller implements CharacterFiller{
    private char fillCharacter;

    public SolidCharacterFiller(char fillCharacter) {
        this.fillCharacter = fillCharacter;
    }

    @Override
    public char getFillCharacter(Coord coord, FlexBox b) {
        return fillCharacter;
    }
}
