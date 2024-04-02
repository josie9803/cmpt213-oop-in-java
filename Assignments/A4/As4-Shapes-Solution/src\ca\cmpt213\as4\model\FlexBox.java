package ca.cmpt213.as4.model;

import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.UI.DrawableShape;
import ca.cmpt213.as4.model.characterfillers.CharacterFiller;
import ca.cmpt213.as4.model.colorers.Colorer;
import ca.cmpt213.as4.model.linestylers.LineStyler;

import javax.swing.*;

/**
 *
 */
public class FlexBox implements DrawableShape {
    private final Coord topLeft;
    private final Coord bottomRight;

    private Colorer colorer;
    private LineStyler lineStyler;
    private CharacterFiller characterFiller;



    public FlexBox(Coord topLeft, Coord bottomRight, Colorer colorer, LineStyler lineStyler, CharacterFiller characterFiller) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.colorer = colorer;
        this.lineStyler = lineStyler;
        this.characterFiller = characterFiller;

        assert topLeft.getX() <= bottomRight.getX();
        assert topLeft.getY() <= bottomRight.getY();
        assert colorer != null;
        assert lineStyler != null;
        assert characterFiller != null;
    }

    public Colorer getColorer() {
        return colorer;
    }

    public void setColorer(Colorer colorer) {
        this.colorer = colorer;
    }

    public LineStyler getLineStyler() {
        return lineStyler;
    }

    public void setLineStyler(LineStyler lineStyler) {
        this.lineStyler = lineStyler;
    }

    public CharacterFiller getCharacterFiller() {
        return characterFiller;
    }

    public void setCharacterFiller(CharacterFiller characterFiller) {
        this.characterFiller = characterFiller;
    }

    public boolean isInBoxArea(Coord coord) {
        int x = coord.getX();
        int y = coord.getY();
        boolean inRangeX = x >= topLeft.getX() && x <= bottomRight.getX();
        boolean inRangeY = y >= topLeft.getY() && y <= bottomRight.getY();
        return inRangeX && inRangeY;
    }

    public boolean isBorder(Coord coord) {
        int x = coord.getX();
        int y = coord.getY();
        boolean onLeftOrRight = x == topLeft.getX() || x == bottomRight.getX();
        boolean onTopOrBottom = y == topLeft.getY() || y == bottomRight.getY();
        return isInBoxArea(coord) && (onLeftOrRight || onTopOrBottom);
    }

    @Override
    public void draw(Canvas canvas) {
        for (int y = topLeft.getY(); y <= bottomRight.getY(); y++) {
            for (int x = topLeft.getX(); x <= bottomRight.getX(); x++) {
                Coord coord = new Coord(x, y);
                canvas.setCellColor(x, y, colorer.getColor(coord, this));
                if (isBorder(coord)) {
                    canvas.setCellText(x, y, lineStyler.getLineStyleAt(coord, this));
                } else {
                    canvas.setCellText(x, y, characterFiller.getFillCharacter(coord, this));
                }
            }
        }
    }

    public Coord getTopLeft() {
        return topLeft;
    }
    public Coord getBottomRight() {
        return bottomRight;
    }
}
