import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UC9 {

    // Key Requirement: Self-contained Bogie class with type/category tracking
    static class Bogie {
        private final String id;
        private final String type; // e.g., "Passenger", "Goods"
        private final String name; // e.g., "Sleeper", "Cargo"
        private final int capacity;

        public Bogie(String id, String type, String name, int capacity) {
            this.id = id;
            this.type = type;
            this.name = name;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return String.format("[%s: %s (Cap: %d)]", id, name, capacity);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== UC9: Train Consist Management (Stream API Grouping) ===\n");

        // 1. User creates a diverse list of bogies (Passenger vs. Goods)
        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new Bogie("B-101", "Passenger", "Sleeper", 72));
        trainConsist.add(new Bogie("B-102", "Passenger", "AC Chair", 56));
        trainConsist.add(new Bogie("B-501", "Goods", "Rectangular Cargo", 100));
        trainConsist.add(new Bogie("B-103", "Passenger", "First Class", 24));
        trainConsist.add(new Bogie("B-502", "Goods", "Cylindrical Tanker", 80));

        System.out.println("Original Uncategorized Train Consist:");
        System.out.println(trainConsist);
        System.out.println("---------------------------------------------------------");

        // 2 & 3. Convert list to stream and apply Collectors.groupingBy()
        System.out.println("-> Categorizing bogies by operational Type...");

        // 4. Store the structured result in Map<String, List<Bogie>>
        Map<String, List<Bogie>> groupedBogies = trainConsist.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        System.out.println("Grouping Complete.");
        System.out.println("---------------------------------------------------------");

        // 5. Display the final grouped structure 
        System.out.println("Structured Administrative Inventory Report:");
        groupedBogies.forEach((type, bogieList) -> {
            System.out.println("\nCategory: [" + type.toUpperCase() + "]");
            System.out.println("Count   : " + bogieList.size() + " coach(es)");
            System.out.println("Details : ");
            bogieList.forEach(bogie -> System.out.println("  " + bogie));
        });

        System.out.println("\nExecution Successful. Program continues.");
    }
}