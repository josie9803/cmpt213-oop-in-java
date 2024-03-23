package ca.cmpt213.as4.DrawShape;

import ca.cmpt213.as4.DrawBackground.Background;
import ca.cmpt213.as4.DrawBackground.CheckerBackground;
import ca.cmpt213.as4.DrawBackground.SolidBackground;
import ca.cmpt213.as4.DrawBackground.TriangleBackground;
import ca.cmpt213.as4.DrawBorder.AsciiLineBorder;
import ca.cmpt213.as4.DrawBorder.Border;
import ca.cmpt213.as4.DrawBorder.CharLineBorder;
import ca.cmpt213.as4.DrawBorder.SequenceBorder;
import ca.cmpt213.as4.DrawFillText.FillText;
import ca.cmpt213.as4.DrawFillText.SolidFillText;
import ca.cmpt213.as4.DrawFillText.WrapperFillText;
import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.DrawShape.DrawableShape;
import ca.cmpt213.as4.trivial_model.ShapeDescription;


public class ConcreteDrawableShape implements DrawableShape {
    private ShapeDescription description;
    public ConcreteDrawableShape(ShapeDescription description) {
        this.description = description;
    }

    @Override
    public void draw(Canvas canvas) {
        Border borderStyle = decideBorder(description);
        borderStyle.drawBorder(canvas, description);

        FillText fillTextStyle = decideInsideText(description);
        fillTextStyle.drawFillText(canvas, description);

        Background backgroundStyle = decideBackground(description);
        backgroundStyle.drawBackground(canvas, description);
    }

    public ShapeDescription getDescription() {
        return description;
    }

    public Border decideBorder(ShapeDescription description){
        switch (description.getLine()) {
            case "char":
                return new CharLineBorder();
            case "ascii line":
                return new AsciiLineBorder();
            case "sequence":
                return new SequenceBorder();
            default:
                return null;
        }
    }

    public FillText decideInsideText(ShapeDescription description){
        switch (description.getFill()) {
            case "solid":
                return new SolidFillText();
            case "wrapper":
                return new WrapperFillText();
            default:
                return null;
        }
    }

    public Background decideBackground(ShapeDescription description){
        switch (description.getBackground()) {
            case "solid":
                return new SolidBackground();
            case "checker":
                return new CheckerBackground();
            case "triangle":
                return new TriangleBackground();
            default:
                return null;
        }
    }

}
