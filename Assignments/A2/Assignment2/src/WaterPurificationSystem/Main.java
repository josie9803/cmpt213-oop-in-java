package WaterPurificationSystem;

import WaterPurificationSystem.Model.WaterUnitsManager;
import WaterPurificationSystem.View.TextUI;

/**
 * Start the application
 */
public class Main {
    public static void main(String[] args) {
        WaterUnitsManager waterUnits = new WaterUnitsManager();
        TextUI ui = new TextUI(waterUnits);
        ui.start();
    }
}