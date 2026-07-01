import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UC8 {

    // Key Requirement: Nested Bogie class with name and capacity fields
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
        System.out.println("=== UC8: Train Consist Management (Stream API Filtering) ===\n");

        // 1. User creates a list of bogies
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("Executive Class", 30));
        passengerBogies.add(new Bogie("Double Decker", 120));

        System.out.println("All Available Passenger Bogies:");
        passengerBogies.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 2 & 3. Convert list into a stream and apply filter(b -> b.capacity > 60)
        System.out.println("-> Filtering for High-Capacity Bogies (Capacity > 60 seats)...");

        List<Bogie> highCapacityBogies = passengerBogies.stream()
                .filter(b -> b.getCapacity() > 60) // Stream pipeline filter logic
                .collect(Collectors.toList());    // 4. Collect results into a new list

        System.out.println("---------------------------------------------------------");

        // 5. Display the filtered bogies
        System.out.println("Filtered Fleet Configuration (High-Capacity Only):");
        highCapacityBogies.forEach(System.out::println);

        System.out.println("\nExecution Successful. Program continues.");
    }
}