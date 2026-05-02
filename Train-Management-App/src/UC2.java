import java.util.ArrayList;
import java.util.List;
public class UC2 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // 1. Create an ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // 2. Add bogies: Sleeper, AC Chair, First Class
        // The add() method appends elements to the end of the list, preserving order.
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // 3. Print the list after insertion
        System.out.println("After adding bogies: " + passengerBogies);

        // 4. Remove one bogie (AC Chair)
        // remove() searches for the object and deletes it, shifting subsequent elements.
        passengerBogies.remove("AC Chair");
        System.out.println("Removed: AC Chair");

        // 5. Use contains() to check if Sleeper exists
        // contains() returns a boolean (true/false)
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Is 'Sleeper' attached to the train? " + hasSleeper);

        // 6. Print final list state and count
        System.out.println("Final Consist: " + passengerBogies);
        System.out.println("Current bogie count: " + passengerBogies.size());

        System.out.println("Program continues...");
    }
}
