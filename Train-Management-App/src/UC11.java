import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UC11 {

    // 1. Define strict regex patterns according to business requirements
    // Format: "TRN-" followed exactly by 4 numeric digits
    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";

    // Format: "PET-" followed exactly by 2 uppercase alphabetic characters
    private static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";

    // Pre-compile the patterns for optimization and performance reuse
    private static final Pattern trainIdPattern = Pattern.compile(TRAIN_ID_REGEX);
    private static final Pattern cargoCodePattern = Pattern.compile(CARGO_CODE_REGEX);

    /**
     * Validates a Train ID format against business constraints.
     */
    public static boolean validateTrainId(String trainId) {
        Matcher matcher = trainIdPattern.matcher(trainId);
        return matcher.matches();
    }

    /**
     * Validates a Cargo Code format against business constraints.
     */
    public static boolean validateCargoCode(String cargoCode) {
        Matcher matcher = cargoCodePattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("=== UC11: Train Consist Management (Regex Data Validation) ===\n");

        // Test cases simulating user data inputs
        String[] testTrainIds = {"TRN-1234", "TRAIN12", "TRN12A", "TRN-9999", "1234-TRN"};
        String[] testCargoCodes = {"PET-CH", "PET-xx", "PET-AG", "OIL-12", "PET-XYZ"};

        // 2 & 3. Validate Train IDs
        System.out.println("--- Validating Train ID Entries (Required Format: TRN-####) ---");
        for (String id : testTrainIds) {
            boolean isValid = validateTrainId(id);
            if (isValid) {
                System.out.println("  ✔ [ACCEPTED] Train ID: " + id + " is valid.");
            } else {
                System.out.println("  ❌ [REJECTED] Train ID: " + id + " does not match 'TRN-####'.");
            }
        }

        System.out.println("---------------------------------------------------------");

        // 4. Validate Cargo Codes
        System.out.println("--- Validating Cargo Code Entries (Required Format: PET-[A-Z]{2}) ---");
        for (String code : testCargoCodes) {
            boolean isValid = validateCargoCode(code);
            if (isValid) {
                System.out.println("  ✔ [ACCEPTED] Cargo Code: " + code + " is valid.");
            } else {
                System.out.println("  ❌ [REJECTED] Cargo Code: " + code + " does not match 'PET-XX' rules.");
            }
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("\nExecution Successful. System input barrier checked. Program continues.");
    }
}