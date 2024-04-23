package ca.cmpt213.as4.model.colorers;

import ca.cmpt213.as4.model.FlexBox;
import ca.cmpt213.as4.model.Coord;

import java.awt.Color;

public interface Colorer {
    Color getColor(Coord coord, FlexBox b);
}
