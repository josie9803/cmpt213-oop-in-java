package ca.cmpt213.as4.model.colorers;

import ca.cmpt213.as4.model.Coord;
import ca.cmpt213.as4.model.FlexBox;

import java.awt.*;

/**
 * Checker-board background colour
 */
public class CheckerColorer implements Colorer {
    private final Color color;
    public CheckerColorer(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor(Coord coord, FlexBox b) {
        int x = coord.getX() - b.getTopLeft().getX();
        int y = coord.getY() - b.getTopLeft().getY();

        if ((x + y) % 2 == 0) {
            return color;
        } else {
            return Color.WHITE;
        }
    }
}
