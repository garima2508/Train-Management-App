import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Key Requirement: Create a Bogie class with name and capacity fields
class Bogie {
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
        return String.format("[Bogie: %-12s | Capacity: %3d seats]", name, capacity);
    }
}

public class UC7 {
    public static void main(String[] args) {
        System.out.println("=== UC7: Train Consist Management (Comparator Sorting) ===\n");

        // 1. Create a List<Bogie> to store passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();

        // 2. Add bogies with varying capacities to the list
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("Executive Class", 30));

        System.out.println("Original Unsorted Bogie List:");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }
        System.out.println("---------------------------------------------------------");

        // 3. Use Comparator.comparingInt() to define sorting based on capacity (Ascending)
        System.out.println("-> Sorting bogies by capacity (Low to High)...");
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nSorted Train Formation (Ascending Capacity):");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }
        System.out.println("---------------------------------------------------------");

        // Optional Operational Requirement: Sort by Highest Capacity First (Descending)
        System.out.println("-> Sorting bogies for capacity optimization (High to Low)...");
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\nFinal Priority Operational View (Descending Capacity):");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        System.out.println("\nExecution Successful.");
    }
}