package cmpt213.as2.ui;
import java.util.List;

/**
 * Generate a report from a given iterable source and provided columns
 * @param <T>: Type of item to be found per row in the report's table.
 */
public class ReportPrinter<T> {
    private final String reportTitle;
    private final Iterable<T> itemIterable;
    private final String messageOnNoItems;
    private final List<Column<T>> columns;


    // --------------------------------------
    // Column: A single output column
    // --------------------------------------
    public static class Column<T> {
        private final String name;
        private final int width;
        private final TextGenerator<T> textGenerator;

        public Column(String name, int width, TextGenerator<T> textGenerator) {
            this.name = name;
            this.width = width;
            this.textGenerator = textGenerator;
        }
    }
    public interface TextGenerator<T> {
        String getText(T item);
    }







    public ReportPrinter(String reportTitle, Iterable<T> itemIterable, String messageOnNoItems, List<Column<T>> columns) {
        this.reportTitle = reportTitle;
        this.itemIterable = itemIterable;
        this.messageOnNoItems = messageOnNoItems;
        this.columns = columns;
    }

    public void printReport() {
        System.out.println();
        System.out.println(reportTitle);
        System.out.println(makeStrNChar(reportTitle.length(), '*'));

        if (!itemIterable.iterator().hasNext()) {
            System.out.println(messageOnNoItems);
        } else {
            printReportHeaderNames();
            printReportHeaderLine();
            printReportItems();
        }
    }

    private void printReportHeaderNames() {
        for (Column<T> c : columns) {
            String specifier = "%" + c.width + "s  ";
            System.out.printf(specifier, c.name);
        }
        System.out.println();
    }

    private void printReportHeaderLine() {
        for (Column<T> c : columns) {
            int width = Math.max(c.width, c.name.length());
            System.out.printf("%s  ", makeStrNChar(width, '-'));
        }
        System.out.println();
    }

    private void printReportItems() {
        for (T item : itemIterable) {
            for (Column<T> c : columns) {
                String specifier = "%" + c.width + "s  ";
                System.out.printf(specifier, c.textGenerator.getText(item));
            }
            System.out.println();
        }
    }

    private String makeStrNChar(int n, char ch) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(ch);
        }
        return str.toString();
    }
}
