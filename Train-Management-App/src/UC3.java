import java.util.HashSet;
import java.util.Set;
public class UC3 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // 1. Create a HashSet to store unique bogie IDs
        // The Set interface ensures no duplicates, and HashSet provides high performance.
        Set<String> bogieIds = new HashSet<>();

        // 2. Add bogie IDs to the system
        System.out.println("Registering bogies in the system...");
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");

        // 3. Attempt to add a duplicate ID (Intentional)
        System.out.println("Attempting to add duplicate ID: BG101");
        boolean isAdded = bogieIds.add("BG101");

        // 4. Verify uniqueness logic
        if (!isAdded) {
            System.out.println("Status: Duplicate ID detected. System blocked entry for BG101.");
        }

        // 5. Display the final set of unique IDs
        System.out.println("\n--- Current Registered Bogie IDs ---");
        System.out.println("IDs: " + bogieIds);
        System.out.println("Total Unique Bogies: " + bogieIds.size());

        System.out.println("\nValidation Complete: Consist integrity maintained.");
    }
}
