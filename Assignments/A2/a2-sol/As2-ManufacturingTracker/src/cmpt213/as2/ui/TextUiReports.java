package cmpt213.as2.ui;

import cmpt213.as2.model.Product;
import cmpt213.as2.model.ProductTest;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Routines to print reports to the screen
 * (Useful reference: https://www.baeldung.com/java-iterable-to-stream)
 */
public class TextUiReports {

    // Shared Report Columns
    private static final ReportPrinter.Column<Product> columnModel = new ReportPrinter.Column<>(
            "Model",
            10,
            Product::getModel);

    private static final ReportPrinter.Column<Product> columnSerial = new ReportPrinter.Column<>(
            "Serial",
            15,
            Product::getSerialNumber);

    private static final ReportPrinter.Column<Product> columnNumTests = new ReportPrinter.Column<>(
            "# Tests",
            10,
            p -> Integer.toString(p.getNumTests()));

    private static final ReportPrinter.Column<Product> columnShipDate = new ReportPrinter.Column<>(
            "Ship Date",
            10,
            p -> p.getDateShipped() == null ? "-" : p.getDateShipped().format(DateTimeFormatter.ISO_LOCAL_DATE));

    private static final ReportPrinter.Column<Product> columnTestDate = new ReportPrinter.Column<>(
            "Test Date",
            11,
            p -> p.getLatestTest().getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));

    private static final ReportPrinter.Column<Product> columnTestComments = new ReportPrinter.Column<>(
            "Test Comments",
            1,
            p -> p.getLatestTest().getTestResultComment());


    public static void printReportAllProducts(Iterable<Product> products) {
        ReportPrinter<Product> rp = new ReportPrinter<>(
                "List of Water Purification Units:",
                products,
                "No units found.",
                Arrays.asList(columnModel, columnSerial, columnNumTests, columnShipDate)
        );
        rp.printReport();
    }

    public static void printReportDefectiveProducts(Iterable<Product> products) {
        // Filter: only defect units
        List<Product> filtered = StreamSupport.stream(products.spliterator(), false)
                .filter(p -> p.getLatestTest() != null)
                .filter(p -> !p.getLatestTest().isTestPassed())
                .collect(Collectors.toList());

        ReportPrinter<Product> rp = new ReportPrinter<>(
                "Le DEFECTIVE Water Purification Units:",
                filtered,
                "No units found.",
                Arrays.asList(columnModel, columnSerial, columnNumTests, columnTestDate, columnTestComments, columnSerial)
        );
        rp.printReport();
    }

    public static void printReportReadyToShipProducts(Iterable<Product> products) {
        // Filter: only not-defect, unshipped units
        List<Product> filtered = StreamSupport.stream(products.spliterator(), false)
                .filter(p -> p.getLatestTest() != null)
                .filter(p -> p.getLatestTest().isTestPassed())
                .filter(p -> p.getDateShipped() == null)
                .collect(Collectors.toList());

        ReportPrinter<Product> rp = new ReportPrinter<>(
                "READ-TO-SHIP Water Purification Units:",
                filtered,
                "No units found.",
                Arrays.asList(columnModel, columnSerial, columnTestDate)
        );
        rp.printReport();
    }

    public static void printTestsReportForProduct(Product p) {
        List<ReportPrinter.Column<ProductTest>> columns = Arrays.asList(
                new ReportPrinter.Column<>(
                        "Date",
                        12,
                        pt -> pt.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE)),
                new ReportPrinter.Column<>(
                        "Passed?",
                        8,
                        pt -> pt.isTestPassed() ? "Passed" : "FAILED"),
                new ReportPrinter.Column<>(
                        "Test Comments",
                        1,
                        ProductTest::getTestResultComment)
        );

        ReportPrinter<ProductTest> rp = new ReportPrinter<>(
                "Tests",
                p.testsIterable(),
                "     No tests done for this unit.",
                columns
        );
        rp.printReport();
    }
}
