import java.util.ArrayList;
import java.util.List;

public class UC10 {

    // Reusing our self-contained Bogie class structural layout
    static class Bogie {
        private final String name;
        private final int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return String.format("[Bogie: %-15s | Capacity: %3d seats]", name, capacity);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== UC10: Train Consist Management (Stream API Reduction) ===\n");

        // 1. User creates a list of passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("Executive Class", 30));
        passengerBogies.add(new Bogie("Sleeper Coach 2", 72));

        System.out.println("Current Fleet Consist Configuration:");
        passengerBogies.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        System.out.println("-> Commencing Stream pipeline computation...");
        System.out.println("-> Step 1: Mapping Bogie objects to Integer capacities.");
        System.out.println("-> Step 2: Accumulating values via reduce(0, Integer::sum).");

        // 2, 3 & 4. Process the stream: Convert to stream, map capacities, and reduce to an aggregate sum
        int totalSeatingCapacity = passengerBogies.stream()
                .map(Bogie::getCapacity)        // Extracts numeric capacities
                .reduce(0, Integer::sum);       // Aggregates matching values safely with identity 0

        System.out.println("---------------------------------------------------------");

        // 5. Display the calculated metrics for operational analysis
        System.out.println("LOGISTICS & UTILIZATION REPORT:");
        System.out.println("Total Passenger Bogies Linked : " + passengerBogies.size());
        System.out.println("Total Train Seating Capacity  : " + totalSeatingCapacity + " seats");
        System.out.println("---------------------------------------------------------");

        System.out.println("\nExecution Successful. Program continues.");
    }
}