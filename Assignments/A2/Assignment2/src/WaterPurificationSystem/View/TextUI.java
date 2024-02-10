package WaterPurificationSystem.View;

import WaterPurificationSystem.Model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TextUI {
    WaterUnitsManager waterUnits;

    public TextUI(WaterUnitsManager waterUnits) {
        this.waterUnits = waterUnits;
    }

    public void start() {
        displayTitle();

        GeneralTextMenu.MenuEntry[] menuEntries = new GeneralTextMenu.MenuEntry[]{
                new GeneralTextMenu.MenuEntry("Read JSON input file.", this::readJSONFilePath),
                new GeneralTextMenu.MenuEntry("Display info on a unit.", this::displayUnitInfo),
                new GeneralTextMenu.MenuEntry("Create new unit.", this::createUnit),
                new GeneralTextMenu.MenuEntry("Test a unit.", this::testUnit),
                new GeneralTextMenu.MenuEntry("Ship a unit.", this::shipUnit),
                new GeneralTextMenu.MenuEntry("Print report.", this::printReport),
                new GeneralTextMenu.MenuEntry("Set report sort order.", this::setReportSortOrder),
                new GeneralTextMenu.MenuEntry("Exit.", null),
        };

        GeneralTextMenu mainMenu = new GeneralTextMenu("Main Menu", menuEntries);
        mainMenu.doMenu();
    }
    private void displayTitle() {
        System.out.println("**********************************");
        System.out.println("Water Purification Inventory Management");
        System.out.println("by Josie.");
        System.out.println("**********************************");
    }
    private void readJSONFilePath(){
        Scanner in = new Scanner(System.in);
        String filePath;
        do {
            System.out.print("Enter the path to the input JSON file; blank to cancel.\n" +
                    "WARNING: This will replace all current data with data from the file.\n" + "> ");
            filePath = in.nextLine();
            try {
                waterUnits.loadJSONFile(filePath);
                return;
            } catch (RuntimeException e) {
                System.out.println("Error loading file: " + e.getMessage());
            }
        } while (!filePath.isEmpty());
    }
    private WaterUnit processUnitInput(){
        if(waterUnits.isEmpty()){
            System.out.println("No units defined.\n" +
                    "Please create a unit and then re-try this option.");
            return null;
        }
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("Enter the serial number (0 for list, -1 for cancel): ");
            String input = in.nextLine();
            if (input.equals("0")) {
                printAll();
            } else if (input.equals("-1")) {
                return null;
            }
            else {
                WaterUnit waterUnit = waterUnits.getUnitBySerialNumber(input);
                if (waterUnit != null) {
                    return waterUnit;
                } else {
                    System.out.println("No unit found matching serial '" + input + "'");
                }
            }
        }
    }

    private void displayUnitInfo(){
        WaterUnit w = processUnitInput();
        if (w != null) {
            System.out.printf("Unit details:%n" +
                            "    Serial: %-10s%n" +
                            "     Model: %-10s%n" +
                            " Ship Date: %-10s%n",
                    w.getSerialNumber(), w.getModel(),
                    w.getDateShipped() == null ? w.getDateShipped() : "-");
            List<Test> tests = w.getTests();
            if ((tests != null) && (!tests.isEmpty())){
                System.out.println("Tests");
                System.out.println("*********");
                System.out.printf("%-12s %-8s %-15s%n", "Date", "Passed?", "Test Comments");
                System.out.println("------------  --------  -------------");
                for (Test test : tests) {
                    System.out.printf("%-12s %-8s %-15s%n",
                            test.getDate(),
                            test.isTestPassed() ? "Passed" : "FAILED",
                            test.getTestResultComment());
                }
            }
            else{
                System.out.println("No tests.");
            }
        }
    }
    private void testUnit(){
        WaterUnit w = processUnitInput();

        System.out.println("Pass? (Y/n): ");
        Scanner in = new Scanner(System.in);

        String passedTest = in.nextLine();
        Test test = new Test(LocalDate.now(), false, null);

        //need to handle the case user enter not y or n --> loop
        if (passedTest.isBlank() || passedTest.equals("y") || passedTest.equals("Y")){
            test.setTestPassed(true);
        }

        System.out.println("Comment: ");
        String comment = in.nextLine();
        test.setTestResultComment(comment);

        if (w != null) {
            w.setTests(test);
        }
        System.out.println("Test recorded.");
    }

    private void shipUnit(){
        WaterUnit w = processUnitInput();
        w.setDateShipped(LocalDate.now());
        System.out.println("Unit successfully shipped.");
    }

    private void createUnit(){
        System.out.println("Enter product info; blank line to quit.");
        Scanner in = new Scanner(System.in);
        String model, serialNumber;

        System.out.print("Model: ");
        model = in.nextLine();
        if (model.isBlank()) { return; }

        while (true){
            System.out.print("Serial number: ");
            serialNumber = in.nextLine();
            if (serialNumber.isBlank()) { return; }
            try {
                SerialNumberValidator.validateSerialNumber(serialNumber);
            } catch (Exception e) {
                System.out.println("Unable to add the product.\n" +
                        "     'Serial Number Error: Checksum does not match.'");
                continue;
            }
            break;
        }

        WaterUnit createdUnit = null;
        try {
            createdUnit = new WaterUnit(serialNumber, model, null, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        waterUnits.add(createdUnit);
    }

    private void printReport(){
        GeneralTextMenu.MenuEntry[] menuEntries = new GeneralTextMenu.MenuEntry[]{
                new GeneralTextMenu.MenuEntry("ALL:           All products.", this::printAll),
                new GeneralTextMenu.MenuEntry("DEFECTIVE:     Products that failed their last test.", this::printDefective),
                new GeneralTextMenu.MenuEntry("READY-TO-SHIP: Products passed tests, not shipped.", this::printReadyToShip),
                new GeneralTextMenu.MenuEntry("Cancel report request.", null),
        };

        GeneralTextMenu reportOptions = new GeneralTextMenu("Report Options", menuEntries);
        reportOptions.doOption();
    }
    private void printAll(){
//        System.out.println("List of Water Purification Units:\n" +
//                "*************************************");
//        System.out.format("%-10s %-15s %-10s %-10s%n", "Model", "Serial Number", "# Tests", "Ship Date");
//        System.out.println("---------  --------------  ---------  ----------");
//
//        for (WaterUnit waterUnit : this.waterUnits.getWaterUnits()) {
//            System.out.format("%-10s %-15s %-10s %-10s%n",
//                    waterUnit.getModel(),
//                    waterUnit.getSerialNumber(),
//                    waterUnit.getTests().size(),
//                    waterUnit.getDateShipped() != null ? waterUnit.getDateShipped() : "-");
//        }
        Printer.displayTable(waterUnits, "List of Water Purification Units:",
                new String[]{"Model", "Serial Number", "# Tests", "Ship Date"});
    }
    private void printDefective(){
        System.out.println("DEFECTIVE Water Purification Units:\n" +
                "***************************************");
        System.out.format("%-10s %-15s %-25s %-15s %-20s%n", "Model", "Serial Number", "# Tests", "Test Date", "Comments");
        System.out.println("----------  ---------------  ----------  ----------");

        for (WaterUnit waterUnit : this.waterUnits.getDefectiveUnits()) {
            System.out.format("%-10s %-15s %-25s %-15s %-20s%n",
                    waterUnit.getModel(),
                    waterUnit.getSerialNumber(),
                    waterUnit.getTests().size(),
                    waterUnit.getMostRecentTest().getDate(),
                    waterUnit.getMostRecentTest().getTestResultComment());
        }
    }
    private void printReadyToShip(){
        System.out.println("READ-TO-SHIP Water Purification Units:\n" +
                "******************************************");
        System.out.format("%-10s %-15s %-25s%n", "Model", "Serial Number", "Test Date");
        System.out.println("---------  --------------  ----------");

        for (WaterUnit waterUnit : this.waterUnits.getReadyToShipUnits()) {
            System.out.format("%-10s %-15s %-25s%n",
                    waterUnit.getModel(),
                    waterUnit.getSerialNumber(),
                    waterUnit.getMostRecentTest().getDate());
        }
    }
    private void setReportSortOrder(){
        GeneralTextMenu.MenuEntry[] menuEntries = new GeneralTextMenu.MenuEntry[]{
                new GeneralTextMenu.MenuEntry("Sort by serial number", WaterUnitsManager::sortBySerialNumber),
                new GeneralTextMenu.MenuEntry("Sort by model, then serial number.", WaterUnitsManager::sortByModelAndSerialNumber),
                new GeneralTextMenu.MenuEntry("Sort by most recent test date.", WaterUnitsManager::sortByRecentTestDate),
                new GeneralTextMenu.MenuEntry("Cancel", null),
        };

        GeneralTextMenu reportOptions = new GeneralTextMenu("Select desired report sort order:", menuEntries);
        reportOptions.doOption();
    }
}
