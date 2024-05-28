package ca.cmpt213.as4.model.linestylers;

import ca.cmpt213.as4.model.FlexBox;
import ca.cmpt213.as4.model.Coord;

public class AsciiLineStyler implements LineStyler {
    @Override
    public char getLineStyleAt(Coord coord, FlexBox box) {
        Coord up = new Coord(coord.getX(), coord.getY() - 1);
        Coord down = new Coord(coord.getX(), coord.getY() + 1);
        Coord left = new Coord(coord.getX() - 1, coord.getY());
        Coord right = new Coord(coord.getX() + 1, coord.getY());

        boolean bUp = box.isBorder(up);
        boolean bDown = box.isBorder(down);
        boolean bRight = box.isBorder(right);
        boolean bLeft = box.isBorder(left);
        assert box.isBorder(coord);

        if (bUp && bDown) {
            return '║';
        }
        if (bLeft && bRight) {
            return '═';
        }
        if (bUp && bRight) {
            return '╚';
        }
        if (bUp && bLeft) {
            return '╝';
        }
        if (bDown && bRight) {
            return '╔';
        }
        if (bDown && bLeft) {
            return '╗';
        }

        // Height or width must be 1
        return '■';
    }
}
