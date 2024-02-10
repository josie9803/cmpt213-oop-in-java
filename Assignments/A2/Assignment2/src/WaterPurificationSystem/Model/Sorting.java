package WaterPurificationSystem.Model;

import java.util.Comparator;

public class Sorting {
     static class bySerialNumber implements Comparator<WaterUnit> {
        @Override
        public int compare(WaterUnit unit1, WaterUnit unit2) {
            long serialNumber1 = Long.parseLong(unit1.getSerialNumber());
            long serialNumber2 = Long.parseLong(unit2.getSerialNumber());

            return Long.compare(serialNumber1, serialNumber2);
        }
    }

    static class byModelAndSerialNumber implements Comparator<WaterUnit>{
        @Override
        public int compare(WaterUnit unit1, WaterUnit unit2) {
            int modelComparison = unit1.getModel().compareTo(unit2.getModel());

            if (modelComparison == 0) {
                long serialNumber1 = Long.parseLong(unit1.getSerialNumber());
                long serialNumber2 = Long.parseLong(unit2.getSerialNumber());
                return Long.compare(serialNumber1, serialNumber2);
            }

            return modelComparison;
        }
    }

    static class byRecentTestDate implements Comparator<WaterUnit>{
        @Override
        public int compare(WaterUnit unit1, WaterUnit unit2) {
            if (unit1.getTests().isEmpty() && unit2.getTests().isEmpty()) {
                return 0; // No specified order among units with no tests
            } else if (unit1.getTests().isEmpty()) {
                return 1; // Units with no tests come after units with tests
            } else if (unit2.getTests().isEmpty()) {
                return -1; // Units with tests come before units with no tests
            }

            // Compare by the date of the most recent test
            return unit1.getMostRecentTest().compareTo(unit2.getMostRecentTest());
        }
    }
}
