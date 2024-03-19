package ca.cmpt213.as4;

import ca.cmpt213.as4.UI.GUI;
import ca.cmpt213.as4.trivial_model.SimpleModel;
import ca.cmpt213.as4.trivial_model.TrivialShapeModel;

/**
 * Application to display the "picture" to the UI.
 */
public class Main {
    public static void main(String[] args) {
        // Instantiate model
        //ShapeModel model = new TrivialShapeModel();
        ShapeModel model = new SimpleModel();
        // Instantiate GUI (with DI)
        GUI gui = new GUI(model);

        // Run GUI application
        gui.start();
    }
}
