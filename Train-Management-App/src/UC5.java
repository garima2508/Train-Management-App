import java.util.LinkedHashSet;
import java.util.Set;

public class UC5 {
    public static void main(String[] args) {
        System.out.println("=== UC5: Train Consist Management (LinkedHashSet Approach) ===\n");

        // 1. Create a LinkedHashSet<String> to represent the train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // 2. Attach initial bogies
        System.out.println("-> Attaching bogies: Engine, Sleeper, Cargo, Guard...");
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // 3. Attempt to attach a duplicate bogie intentionally (Sleeper again)
        System.out.println("-> Attempting to attach duplicate bogie: 'Sleeper' again...");
        boolean isAddedAgain = trainFormation.add("Sleeper");

        System.out.println("---------------------------------------------------------");

        // 4. Verify deduplication behavior
        System.out.println("Deduplication Status:");
        System.out.println("Was duplicate 'Sleeper' added to the consist? " + (isAddedAgain ? "Yes" : "No (Automatically Ignored)"));
        System.out.println("---------------------------------------------------------");

        // 5. Display the final ordered train consist using System.out.println()
        System.out.println("Final Ordered Train Consist (Insertion Order Maintained):");
        System.out.println(trainFormation);

        System.out.println("\nExecution Successful.");
    }
}