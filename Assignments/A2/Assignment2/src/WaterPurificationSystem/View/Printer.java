package WaterPurificationSystem.View;

import WaterPurificationSystem.Model.WaterUnit;
import WaterPurificationSystem.Model.WaterUnitsManager;

import java.util.List;

public class Printer {
    private static final int EXTRA_CHARACTERS_IN_TITLE = 4;
    private static void displayRowOfStars(int length, String symbol) {
        for (int i = 0; i < length + EXTRA_CHARACTERS_IN_TITLE; i++) {
            System.out.print(symbol);
        }
    }
    public static void displayTable(WaterUnitsManager waterUnits, String title, String[] columns){
        System.out.println(title);
        displayRowOfStars(title.length(), "*");
        System.out.println();

        for (String column : columns) {
            System.out.printf("%-15s ", column);
        }
        System.out.println();

        for (int i = 0; i < columns.length; i++) {
            System.out.print("-".repeat(columns[i].length()));
            if (i < columns.length - 1) {
                System.out.print("  ");
            }
        }
        System.out.println();

        for (WaterUnit waterUnit : waterUnits) {
            for (String column : columns) {
                String value = getColumnValue(waterUnit, column);
                System.out.print(String.format("%-15s ", value));
            }
            System.out.println();
        }
    }

    private static String getColumnValue(WaterUnit waterUnit, String column) {
        switch (column) {
            case "Model":
                return waterUnit.getModel();
            case "Serial Number":
                return waterUnit.getSerialNumber();
            case "# Tests":
                return String.valueOf(waterUnit.getTests().size());
            case "Ship Date":
                return waterUnit.getDateShipped() != null ? waterUnit.getDateShipped().toString() : "-";
            case "Test Date":
                return waterUnit.getMostRecentTest().getDate().toString();
            case "Comments":
                return waterUnit.getMostRecentTest().getTestResultComment();
            default:
                return "";
        }
    }
}
