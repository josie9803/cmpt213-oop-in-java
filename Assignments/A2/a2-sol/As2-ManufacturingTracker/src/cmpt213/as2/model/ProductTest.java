package cmpt213.as2.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * Represent a single test done on an item.
 */
public class ProductTest implements Comparable<ProductTest>{
    private LocalDate date;
    private boolean isTestPassed;
    private String testResultComment;

    public ProductTest(LocalDate date, boolean isTestPassed, String testResultComment) {
        this.date = date;
        this.isTestPassed = isTestPassed;
        this.testResultComment = testResultComment;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isTestPassed() {
        return isTestPassed;
    }

    public String getTestResultComment() {
        return testResultComment;
    }

    @Override
    public String toString() {
        return "ProductTest{" +
                "date=" + date +
                ", isTestPassed=" + isTestPassed +
                ", testResultComment='" + testResultComment + '\'' +
                '}';
    }

    @Override
    public int compareTo(ProductTest o) {
        return date.compareTo(o.date);
    }
}
