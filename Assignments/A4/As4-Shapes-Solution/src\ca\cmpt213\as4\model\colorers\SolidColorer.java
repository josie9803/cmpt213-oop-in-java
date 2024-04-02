package ca.cmpt213.as4.model.colorers;

import ca.cmpt213.as4.model.FlexBox;
import ca.cmpt213.as4.model.Coord;

import java.awt.*;

public class SolidColorer implements Colorer {
    private Color color;

    public SolidColorer(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor(Coord coord, FlexBox b) {
        return color;
    }
}
