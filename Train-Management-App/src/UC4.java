import java.util.LinkedList;

public class UC4 {
    public static void main(String[] args) {
        System.out.println("=== UC4: Train Consist Management (LinkedList Approach) ===\n");

        // 1. Create a LinkedList<String> for the consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // 2. Add initial bogies to establish the physical sequence
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Formation:");
        System.out.println(trainConsist);
        System.out.println("---------------------------------------------------------");

        // 3. Insert a Pantry Car at position 2
        System.out.println("-> Inserting 'Pantry Car' at position 2...");
        trainConsist.add(2, "Pantry Car");

        System.out.println("Current Consist: " + trainConsist);
        System.out.println("---------------------------------------------------------");

        // 4. Remove the first and last bogie
        System.out.println("-> Detaching the first bogie (" + trainConsist.peekFirst() + ")...");
        trainConsist.removeFirst();

        System.out.println("-> Detaching the last bogie (" + trainConsist.peekLast() + ")...");
        trainConsist.removeLast();
        System.out.println("---------------------------------------------------------");

        // 5. Display the final ordered train consist
        System.out.println("Final Ordered Train Consist:");
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.print("[" + trainConsist.get(i) + "]");
            if (i < trainConsist.size() - 1) {
                System.out.print(" <-> ");
            }
        }
        System.out.println("\n\nExecution Successful.");
    }
}
