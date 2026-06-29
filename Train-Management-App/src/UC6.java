import java.util.HashMap;
import java.util.Map;

public class UC6 {
    public static void main(String[] args) {
        System.out.println("=== UC6: Train Consist Management (HashMap Capacity Mapping) ===\n");

        // 1. Create a HashMap<String, Integer> to store bogie-capacity information
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // 2. Use the put() method to map each bogie to its capacity (Key-Value Association)
        System.out.println("-> Registering bogie capacities into the system...");
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 56);
        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("Cargo", 100); // 100 tons limit
        bogieCapacityMap.put("Guard", 4);     // Small cabin capacity

        System.out.println("Registration complete.\n");
        System.out.println("---------------------------------------------------------");

        // 3. Iterate over the map using entrySet() to display capacities
        System.out.println("Bogie Capacity Directory:");
        System.out.println("---------------------------------------------------------");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            String bogieType = entry.getKey();
            Integer capacity = entry.getValue();

            // Format units conditionally for realism
            String unit = bogieType.equals("Cargo") ? " Tons" : " Seats";

            System.out.println("Bogie Type: " + bogieType + " \t-> Capacity: " + capacity + unit);
        }

        System.out.println("---------------------------------------------------------");

        // 4. Demonstrating Fast Lookup using a Key
        String lookupBogie = "AC Chair";
        if (bogieCapacityMap.containsKey(lookupBogie)) {
            System.out.println("-> Instant Lookup Request: Checking capacity for '" + lookupBogie + "'...");
            System.out.println("Result: " + lookupBogie + " can hold " + bogieCapacityMap.get(lookupBogie) + " passengers.");
        }

        System.out.println("\nExecution Successful.");
    }
}