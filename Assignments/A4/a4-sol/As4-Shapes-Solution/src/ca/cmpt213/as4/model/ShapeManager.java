package ca.cmpt213.as4.model;

import ca.cmpt213.as4.ShapeModel;
import ca.cmpt213.as4.UI.DrawableShape;
import ca.cmpt213.as4.model.characterfillers.*;
import ca.cmpt213.as4.model.colorers.*;
import ca.cmpt213.as4.model.linestylers.*;
import com.google.gson.*;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Manage the shapes being shown in the application.
 * Used by the GUI (needs an ShapeModel)
 */
public class ShapeManager implements ShapeModel {
    private final List<FlexBox> boxes = new ArrayList<>();

    private class JsonShape {
        private Integer top;
        private Integer left;
        private Integer height;
        private Integer width;

        private String background;
        private String backgroundColor;

        private String line;
        private String lineChar;

        private String fill;
        private String fillText;

        void assertRequiredFields() {
            assert left != null;
            assert top != null;
            assert height != null;
            assert width != null;
            assert background != null;
            assert line != null;
            assert fill != null;
        }
    }

    @Override
    public void populateFromJSON(File jsonFile) {
        boxes.clear();
        try {
            Gson gson = new Gson();
            JsonElement fileElement = JsonParser.parseReader(new FileReader(jsonFile));
            JsonObject fileObject = fileElement.getAsJsonObject();

            // Extract shapes
            JsonArray shapes = fileObject.get("shapes").getAsJsonArray();
            for (JsonElement element : shapes) {
                JsonShape shape = gson.fromJson(element, JsonShape.class);
                shape.assertRequiredFields();

                FlexBox box = new FlexBox(
                        new Coord(shape.left, shape.top),
                        new Coord(shape.left + shape.width - 1, shape.top + shape.height - 1),
                        makeColorer(shape),
                        makeLineStyler(shape),
                        makeCharFiller(shape));

                boxes.add(box);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading JSON file.", e);
        }

    }

    private CharacterFiller makeCharFiller(JsonShape shape) {
        switch (shape.fill) {
            case "solid":
                return new SolidCharacterFiller(shape.fillText.charAt(0));
            case "wrapper":
                return new WordWrapperCharacterFiller(shape.fillText);
            default:
                throw new IllegalArgumentException("Bad shape fill: " + shape.fill);
        }
    }

    private LineStyler makeLineStyler(JsonShape shape) {
        switch (shape.line) {
            case "char":
                return new SingleCharacterLineStyler(shape.lineChar.charAt(0));
            case "ascii line":
                return new AsciiLineStyler();
            case "sequence":
                return new SequenceLineStyler();
            default:
                throw new IllegalArgumentException("Bad shape line: " + shape.line);
        }
    }

    private Colorer makeColorer(JsonShape shape) {
        switch(shape.background) {
            case "solid":
                return new SolidColorer(getColorFromName(shape.backgroundColor));
            case "triangle":
                return new TriangleColorer(getColorFromName(shape.backgroundColor));
            case "checker":
                return new CheckerColorer(getColorFromName(shape.backgroundColor));
            default:
                throw new IllegalArgumentException("Bad shape colorer: " + shape.background);
        }
    }

    private static Color getColorFromName(String name) {
        switch (name) {
            case "white": return Color.WHITE;
            case "light gray": return Color.LIGHT_GRAY;
            case "gray": return Color.GRAY;
            case "dark gray": return Color.DARK_GRAY;
            case "black": return Color.BLACK;
            case "red": return Color.RED;
            case "pink": return Color.PINK;
            case "orange": return Color.ORANGE;
            case "yellow": return Color.YELLOW;
            case "green": return Color.GREEN;
            case "magenta": return Color.MAGENTA;
            case "cyan": return Color.CYAN;
            case "blue": return Color.BLUE;
            default:
                throw new IllegalArgumentException("Bad color argument: " + name);
        }
    }

    @Override
    public void redact() {
        // Change all existing box objects to be gray box of X's, border +'s
        Colorer colorer = new SolidColorer(Color.LIGHT_GRAY);
        LineStyler lineStyler = new SingleCharacterLineStyler('+');
        CharacterFiller characterFiller = new SolidCharacterFiller('X');

        for (FlexBox box : boxes) {
            box.setColorer(colorer);
            box.setLineStyler(lineStyler);
            box.setCharacterFiller(characterFiller);
        }
    }

    @Override
    public Iterator<? extends DrawableShape> iterator() {
        return boxes.iterator();
    }

}
