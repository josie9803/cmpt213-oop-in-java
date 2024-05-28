package ca.cmpt213.as4.model.colorers;

import ca.cmpt213.as4.model.Coord;
import ca.cmpt213.as4.model.FlexBox;

import java.awt.Color;

/**
 * Fill top-right of triangular background
 */
public class TriangleColorer implements Colorer {
    private final Color color;

    public TriangleColorer(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor(Coord coord, FlexBox b) {
        int x = coord.getX() - b.getTopLeft().getX() + 1;
        int y = coord.getY() - b.getTopLeft().getY() + 1;
        int width = b.getBottomRight().getX() - b.getTopLeft().getX() + 1;
        int height = b.getBottomRight().getY() - b.getTopLeft().getY() + 1;

        double xPercent = (double) x / (double) width;
        double yPercent = (double) y / (double) height;
        if (xPercent >= yPercent) {
            return color;
        } else {
            return Color.WHITE;
        }
    }
}
