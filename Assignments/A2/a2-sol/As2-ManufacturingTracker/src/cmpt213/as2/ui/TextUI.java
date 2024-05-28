package cmpt213.as2.ui;

import cmpt213.as2.model.Product;
import cmpt213.as2.model.ProductManager;
import cmpt213.as2.model.ProductTest;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Application to manage water purification units
 */
public class TextUI {
	private final ProductManager productManager;
	private final Scanner scan;
	private Comparator<Product> reportSortOrder = Product.sorterBySerialNumber();

	public TextUI(ProductManager productManager) {
		this.productManager = productManager;
		scan = new Scanner(System.in);

//		populateTestData();
	}

	private void populateTestData() {
		// Generate some test data (unneeded when loading from a file)
		Product p;

		p = new Product("GG135", "532515");
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 1), true, "Good 1"));
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 2), true, "Good 2"));
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 3), true, "Good 3"));
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 4), true, "Good 4"));
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 5), true, "Good 5"));
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 6), false, "WTF?!? Bad?"));
		productManager.add(p);

		p = new Product("ABC123", "99999999999201");
		p.setDateShipped(LocalDate.of(2000, 1, 1));
		p.addTest(new ProductTest(LocalDate.now(), true, ""));
		productManager.add(p);

		p = new Product("XYZ-335", "101");
		p.setDateShipped(LocalDate.now());
		p.addTest(new ProductTest(LocalDate.now(), true, "Retested after rework."));
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 1), false, "Failed on reset test."));
		productManager.add(p);

		productManager.add(new Product("ABC123", "202"));

		p = new Product("GG135", "303");
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 1), true, "Good 1"));
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 2), true, "#2 was bad"));
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 3), true, "Good 3"));
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 4), true, "Good 4"));
		p.addTest(new ProductTest(LocalDate.of(2000, 1, 5), true, "Good 5"));
		productManager.add(p);
	}

	public void start() {
		displayWelcomeMessage();

		TextMenu.MenuEntry[] menuEntries = new TextMenu.MenuEntry[]{
				new TextMenu.MenuEntry("Read JSON input file.", this::readInputJSONFile),
				new TextMenu.MenuEntry("Display info on a unit.", this::displayUnitInfo),
				new TextMenu.MenuEntry("Create new unit.", this::createAUnit),
				new TextMenu.MenuEntry("Test a unit.", this::testAUnit),
				new TextMenu.MenuEntry("Ship a unit.", this::shipAUnit),
				new TextMenu.MenuEntry("Print report.", this::doPrintReportMenu),
				new TextMenu.MenuEntry("Set report sort order.", this::setReportSortOrder),
//				new TextMenu.MenuEntry("Write JSON to output file.", this::writeOutputJSONFile),
				new TextMenu.MenuEntry("Exit", null),
		};

		TextMenu mainMenu = new TextMenu("Main Menu", menuEntries);
		mainMenu.doMenu();
	}

	private void displayWelcomeMessage() {
		System.out.println("***************************************");
		System.out.println("Water Purification Inventory Management");
		System.out.println("by Your Name Here.");
		System.out.println("***************************************");
	}

	private void readInputJSONFile() {
		System.out.println("Enter the path to the input JSON file; blank to cancel.");
		System.out.println("WARNING: This will replace all current data with data from the file.");
		System.out.print("> ");
		String path = scan.nextLine().trim();

		if (path.isEmpty()) {
			return;
		}

		// Try (with resources) to read from the input file
		try (Scanner fileScanner = new Scanner(new File(path))){
			StringBuilder json = new StringBuilder();
			while (fileScanner.hasNextLine()) {
				json.append(fileScanner.nextLine());
			}
			productManager.populateFromJSON(json.toString());
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Read " + productManager.countProducts() + " products from JSON file '" + path + "'.");
	}

	private void writeOutputJSONFile() {
		String outPath = "C:/t/test1.json";
		System.out.println("Writing data to: " + outPath);
		try {
			FileWriter writer = new FileWriter(outPath);
			writer.write(productManager.getJSON());
			writer.flush();
			writer.close();

		} catch (IOException e) {
			System.out.println("ERROR: Unable to write to output file.");
			e.printStackTrace();
		}
	}

	private void displayUnitInfo() {
		try {
			String serial = pickUnitSerialNumber();
			if (serial != null && !serial.isEmpty()) {
				Product p = productManager.findOrThrow(serial);

				System.out.println();
				System.out.printf("Unit details:%n");
				System.out.printf("%10s: %s%n", "Serial", p.getSerialNumber());
				System.out.printf("%10s: %s%n", "Model", p.getModel());
				System.out.printf("%10s: %s%n", "Ship Date",
						p.getDateShipped() == null ? "-" : p.getDateShipped().format(DateTimeFormatter.ISO_LOCAL_DATE));

				TextUiReports.printTestsReportForProduct(p);
			}
		} catch(NoSuchElementException ex) {
			System.out.println("UNEXPECTED ERROR: Serial number not found.");
		}
	}

	private String pickUnitSerialNumber(){
		// Handle an empty DB of units
		if (productManager.isEmpty()) {
			System.out.println("No units defined.");
			System.out.println("Please create a unit and then re-try this option.");
			return null;
		}

		while (true) {
			// Ask for a serial number.
			System.out.print("Enter the serial number (0 for list, -1 for cancel): ");
			String serial = scan.nextLine();
			serial = serial.trim().toUpperCase(Locale.ROOT);

			// Check cases
			if (serial.equals("0")) {
				TextUiReports.printReportAllProducts(productManager.sortedBy(reportSortOrder));
			}
			else if (serial.equals("-1")) {
				return "";
			}
			else if (productManager.containsBySerialNumber(serial)) {
				return serial;
			} else {
				System.out.println("No unit found matching serial '" + serial + "'");
			}
		}
	}

	private void createAUnit() {
		System.out.println("Enter product info; blank line to quit.");
		System.out.print("Model: ");
		String model = scan.nextLine();
		if (model.isBlank()) {
			return;
		}

		boolean added = false;
		while (!added) {
			try {
				System.out.print("Serial number: ");
				String serial = scan.nextLine();
				if (serial.isBlank()) {
					return;
				}

				if (productManager.containsBySerialNumber(serial)) {
					System.out.println("Error: Serial number '" + serial + "' already assigned to a unit.");
					continue;
				}

				Product p = new Product(model.trim(), serial.trim());
				productManager.add(p);
				added = true;
			} catch (Exception ex) {
				System.out.println("Unable to add the product.");
				System.out.println("     '" + ex.getMessage() + "'");
				System.out.println("Please try again.");
			}
		}
	}

	private void testAUnit() {
		try {
			String serial = pickUnitSerialNumber();
			if (serial != null && !serial.isEmpty()) {
				Product p = productManager.findOrThrow(serial);

				System.out.print("Pass? (Y/n): ");
				boolean passed = TextMenu.readYesNoOrNothing(true);

				System.out.print("Comment: ");
				String comment = scan.nextLine();

				ProductTest test = new ProductTest(LocalDate.now(), passed, comment);
				p.addTest(test);
				System.out.println("Test recorded.");
			}
		} catch(NoSuchElementException ex) {
			System.out.println("UNEXPECTED ERROR: Serial number not found.");
		}
	}

	private void shipAUnit() {
		try {
			String serial = pickUnitSerialNumber();
			if (serial != null && !serial.isEmpty()) {
				Product p = productManager.findOrThrow(serial);
				p.setDateShipped(LocalDate.now());
				System.out.println("Unit successfully shipped.");
			}
		} catch(NoSuchElementException ex) {
			System.out.println("UNEXPECTED ERROR: Serial number not found.");
		}
	}

	private void doPrintReportMenu() {
		TextMenu.MenuEntry[] menuEntries = new TextMenu.MenuEntry[]{
				new TextMenu.MenuEntry("ALL:           All products.",
						() -> TextUiReports.printReportAllProducts(productManager.sortedBy(reportSortOrder))),
				new TextMenu.MenuEntry("DEFECTIVE:     Products that failed their last test.",
						() -> TextUiReports.printReportDefectiveProducts(productManager.sortedBy(reportSortOrder))),
				new TextMenu.MenuEntry("READY-TO-SHIP: Products passed tests, not shipped.",
						() -> TextUiReports.printReportReadyToShipProducts(productManager.sortedBy(reportSortOrder))),
				new TextMenu.MenuEntry("Cancel report request.", null),
		};
		TextMenu reportMenu = new TextMenu("Report Options", menuEntries, TextMenu.MenuMode.MODE_ONE_SHOT);
		reportMenu.doMenu();
	}

	private void setReportSortOrder() {
		TextMenu.MenuEntry[] menuEntries = new TextMenu.MenuEntry[]{
				new TextMenu.MenuEntry("Sort by serial number",
						() -> reportSortOrder = Product.sorterBySerialNumber()),
				new TextMenu.MenuEntry("Sort by model, then serial number.",
						() -> reportSortOrder = Product.sorterByModelThenSerialNumber()),
				new TextMenu.MenuEntry("Sort by most recent test date.",
						() -> reportSortOrder = Product.sorterByDateTested()),
				new TextMenu.MenuEntry("Cancel", null),
		};
		TextMenu sortMenu = new TextMenu(
				"Select desired report sort order:",
				menuEntries, TextMenu.MenuMode.MODE_ONE_SHOT);
		sortMenu.doMenu();
	}
}
