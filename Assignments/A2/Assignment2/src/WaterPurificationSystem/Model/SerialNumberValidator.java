package WaterPurificationSystem.Model;

public class SerialNumberValidator {
    public static void validateSerialNumber(String serialNumber) throws Exception {
        if (serialNumber == null || !serialNumber.matches("\\d{3,15}")) {
            throw new Exception("Invalid serial number format");
        }

        // Extract the last two digits and compute the checksum
        int checksum = computeChecksum(serialNumber.substring(0, serialNumber.length() - 2));

        // Compare the computed checksum with the provided checksum
        int providedChecksum = Integer.parseInt(serialNumber.substring(serialNumber.length() - 2));
        if (checksum != providedChecksum) {
            throw new Exception("Invalid checksum");
        }
    }

    private static int computeChecksum(String digits) {
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            sum += Character.getNumericValue(digits.charAt(i));
        }
        return sum % 100;
    }
}
