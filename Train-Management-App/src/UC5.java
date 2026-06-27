import java.util.TreeSet;
import java.util.Set;

public class UC5 {
    public static void main(String[] args) {
        System.out.println("=== UC5: Train Consist Management (TreeSet Sorted Approach) ===\n");

        // 1. Create a TreeSet to automatically sort and prevent duplicate Bogie IDs
        Set<String> uniqueSortedBogies = new TreeSet<>();

        // 2. User adds bogie IDs (including accidental duplicates)
        System.out.println("-> Adding Bogies to the system...");
        uniqueSortedBogies.add("Engine-01");
        uniqueSortedBogies.add("Sleeper-02");
        uniqueSortedBogies.add("AC-03");
        uniqueSortedBogies.add("Cargo-04");

        // Attempting to add duplicate IDs
        System.out.println("-> Attempting to add duplicate IDs ('Sleeper-02' and 'Engine-01')...");
        boolean isSleeperAdded = uniqueSortedBogies.add("Sleeper-02");
        boolean isEngineAdded = uniqueSortedBogies.add("Engine-01");

        // Adding a guard coach
        uniqueSortedBogies.add("Guard-05");
        System.out.println("---------------------------------------------------------");

        // 3. System identifies and ignores duplicates
        System.out.println("Duplicate Verification Results:");
        System.out.println("Was second 'Sleeper-02' accepted? " + (isSleeperAdded ? "Yes" : "No (Ignored)"));
        System.out.println("Was second 'Engine-01' accepted? " + (isEngineAdded ? "Yes" : "No (Ignored)"));
        System.out.println("---------------------------------------------------------");

        // 4. Display the unique, naturally sorted train consist IDs
        System.out.println("Final Unique & Alphabetically Sorted Bogie IDs:");
        System.out.println(uniqueSortedBogies);

        System.out.println("\nExecution Successful.");
    }
}