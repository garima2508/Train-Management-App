import java.util.ArrayList;
import java.util.List;

public class UC12 {

    // Key Requirement: Goods Bogie configuration class with type and cargo fields
    static class GoodsBogie {
        private final String id;
        private final String shape; // e.g., "Cylindrical", "Rectangular"
        private final String cargoType;

        public GoodsBogie(String id, String shape, String cargoType) {
            this.id = id;
            this.shape = shape;
            this.cargoType = cargoType;
        }

        public String getShape() {
            return shape;
        }

        public String getCargoType() {
            return cargoType;
        }

        @Override
        public String toString() {
            return String.format("[Bogie ID: %s | Shape: %-12s | Cargo: %-12s]", id, shape, cargoType);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== UC12: Train Consist Management (Safety Compliance Check) ===\n");

        // 1. Prepare an initially SAFE train configuration
        List<GoodsBogie> safeTrainConsist = new ArrayList<>();
        safeTrainConsist.add(new GoodsBogie("G-201", "Rectangular", "Coal"));
        safeTrainConsist.add(new GoodsBogie("G-202", "Cylindrical", "Petroleum"));
        safeTrainConsist.add(new GoodsBogie("G-203", "Rectangular", "Steel Coils"));

        // 2. Prepare an UNSAFE train configuration (Violates: Cylindrical holding Chemicals/Coal)
        List<GoodsBogie> unsafeTrainConsist = new ArrayList<>();
        unsafeTrainConsist.add(new GoodsBogie("G-301", "Rectangular", "Grain"));
        unsafeTrainConsist.add(new GoodsBogie("G-302", "Cylindrical", "Coal")); // Invalid configuration!
        unsafeTrainConsist.add(new GoodsBogie("G-303", "Cylindrical", "Petroleum"));

        // Execute safety audits on both consists
        auditTrainSafety("Fleet Consist A (Standard Mix)", safeTrainConsist);
        auditTrainSafety("Fleet Consist B (Hazardous Mix)", unsafeTrainConsist);

        System.out.println("Execution Successful. Safety systems online.");
    }

    /**
     * Converts the collection to a stream and applies allMatch() validation logic.
     */
    private static void auditTrainSafety(String trainName, List<GoodsBogie> consist) {
        System.out.println("Auditing Layout: " + trainName);
        System.out.println("---------------------------------------------------------");
        consist.forEach(System.out::println);

        System.out.println("\n-> Running allMatch() stream validation pipeline...");

        // 3 & 4. Core logical constraint filter using short-circuit evaluation
        // Conditional Rule: If it's Cylindrical, it MUST be Petroleum. Otherwise, it passes.
        boolean isSafetyCompliant = consist.stream().allMatch(bogie -> {
            if ("Cylindrical".equalsIgnoreCase(bogie.getShape())) {
                return "Petroleum".equalsIgnoreCase(bogie.getCargoType());
            }
            return true; // Non-cylindrical bogies pass this particular liquid-containment rule
        });

        // 5. Display compliance result
        System.out.println("---------------------------------------------------------");
        if (isSafetyCompliant) {
            System.out.println("STATUS: 🟢 [PASSED] " + trainName + " is fully safety compliant.");
            System.out.println("Action: Permissions granted for departure.");
        } else {
            System.out.println("STATUS: 🔴 [FAILED] " + trainName + " HAS LOGISTICAL HAZARDS!");
            System.out.println("Action: Deployment halted. Non-petroleum materials detected inside cylindrical containers.");
        }
        System.out.println("---------------------------------------------------------\n");
    }
}