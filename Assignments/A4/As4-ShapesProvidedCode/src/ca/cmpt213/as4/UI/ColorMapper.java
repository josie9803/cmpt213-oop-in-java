package ca.cmpt213.as4.UI;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ColorMapper {
    private static final Map<String, Color> colorMap = new HashMap<>();

    static {
        colorMap.put("red", Color.RED);
        colorMap.put("green", Color.GREEN);
        colorMap.put("blue", Color.BLUE);
        colorMap.put("yellow", Color.YELLOW);
        colorMap.put("orange", Color.ORANGE);
        colorMap.put("magenta", Color.MAGENTA);
        colorMap.put("light gray", Color.LIGHT_GRAY);
        colorMap.put("dark gray", Color.DARK_GRAY);
        colorMap.put("gray", Color.GRAY);
        colorMap.put("cyan", Color.CYAN);
        colorMap.put("pink", Color.PINK);
        colorMap.put("black", Color.BLACK);
    }

    public static Color getColor(String colorName) {
        return colorMap.getOrDefault(colorName.toLowerCase(), Color.WHITE);
    }
}

