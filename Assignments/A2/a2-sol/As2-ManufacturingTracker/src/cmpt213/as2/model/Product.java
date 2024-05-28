package cmpt213.as2.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

/**
 * Information on a single product
 */
public class Product {
    private static final int CHECKSUM_LENGTH = 2;

    private final String model;
    private final String serialNumber;
    private LocalDate dateShipped;
    private final List<ProductTest> tests = new ArrayList<>();

    public Product(String model, String serialNumber) {
        verifySerialOrThrow(serialNumber);

        this.model = model;
        this.serialNumber = serialNumber;
    }

    private void verifySerialOrThrow(String serialNumber) {
        if (serialNumber == null || serialNumber.length() <= CHECKSUM_LENGTH) {
            throw new RuntimeException("Serial Number Error: must be > " + CHECKSUM_LENGTH + " digits long.");
        }

        long numDigits = serialNumber.chars().filter(Character::isDigit).count();
        if (numDigits != serialNumber.length()) {
            throw new RuntimeException("Serial Number Error: must only contain digits (0 through 9)");
        }

        String noChecksumStr = serialNumber.substring(0, serialNumber.length() - CHECKSUM_LENGTH);
        String checksumStr = serialNumber.substring(serialNumber.length() - CHECKSUM_LENGTH);

        int expectedChecksum = noChecksumStr.chars().map(v -> v - '0').sum() % 100;
        int receivedChecksum = Integer.parseInt(checksumStr);
        if (expectedChecksum != receivedChecksum) {
            throw new RuntimeException("Serial Number Error: Checksum does not match.");
        }
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public LocalDate getDateShipped() {
        return dateShipped;
    }

    public void addTest(ProductTest test) {
        tests.add(test);
        Collections.sort(tests);
    }
    public Iterable<ProductTest> testsIterable() {
        return () -> tests.iterator();
    }
    public int countTests() {
        return tests.size();
    }

    @Override
    public String toString() {
        return "Product{" +
                "modelNumber='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", dateShipped=" + dateShipped +
                ", tests=" + tests +
                '}';
    }

    public int getNumTests() {
        return tests.size();
    }

    public void setDateShipped(LocalDate dateShipped) {
        this.dateShipped = dateShipped;
    }


    public static Comparator<Product> sorterBySerialNumber() {
        return (o1, o2) -> Product.compareSerialNumbers(o1, o2);
    }
    public static Comparator<Product> sorterByModelThenSerialNumber() {
        return (o1, o2) -> {
            int modelCompare = o1.getModel().compareToIgnoreCase(o2.getModel());
            if (modelCompare != 0) {
                return modelCompare;
            }

            return Product.compareSerialNumbers(o2, o2);
        };
    }
    public static Comparator<Product> sorterByDateTested() {
        return (o1, o2) -> {
            LocalDate latest1 = o1.getLatestTest() == null ? null : o1.getLatestTest().getDate();
            LocalDate latest2 = o2.getLatestTest() == null ? null : o2.getLatestTest().getDate();
            if (latest1 == latest2) {
                return 0;
            }
            if (latest1 == null) {
                return 1;
            }
            if (latest2 == null) {
                return -1;
            }
            return latest1.compareTo(latest2);
        };
    }

    private static int compareSerialNumbers(Product o1, Product o2) {
        BigInteger serial1 = new BigInteger(o1.getSerialNumber());
        BigInteger serial2 = new BigInteger(o2.getSerialNumber());
        return serial1.compareTo(serial2);
    }

    public ProductTest getLatestTest() {
        // `tests` maintained in chronological sorted order
        if (tests.isEmpty()) {
            return null;
        }
        return tests.get(tests.size() - 1);
    }
}

