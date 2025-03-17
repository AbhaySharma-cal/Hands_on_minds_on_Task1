import java.util.ArrayList;

public class Prob1 {
    static ArrayList<Integer> numbers = new ArrayList<>(); // Dynamically sized list to store polygonal numbers
    static ArrayList<Integer> types = new ArrayList<>();   // Dynamically sized list to store polygonal types
    static int totalNumbers = 0;                            // Counter for how many numbers are stored
    static int[] result = new int[6];                       // Stores the final cyclic se

    public static void main(String[] args) {
        generatePolygonalNumbers();

        // Try finding the cyclic set starting with any number
        for (int i = 0; i < totalNumbers; i++) {
            result[0] = numbers.get(i); // Start with a number
            boolean[] usedTypes = new boolean[6];
            usedTypes[types.get(i) - 3] = true;

            if (findCyclicSet(1, numbers.get(i), usedTypes)) {
                int sum = 0;
                for (int num : result) sum += num;

                System.out.println("Cyclic Set: " + java.util.Arrays.toString(result));
                System.out.println("Sum: " + sum);
                return;
            }
        }

        System.out.println("No cyclic set found.");
    }

    static void generatePolygonalNumbers() {
        for (int type = 3; type <= 8; type++) {
            for (int n = 1; ; n++) {
                int value = generatePolygonal(type, n);
                if (value >= 10000) break; // Stop if the number exceeds 9999
                if (value >= 1000) { // Only consider 4-digit numbers
                    numbers.add(value); // Add the number to the list
                    types.add(type);     // Add the type to the list
                    totalNumbers++;
                }
            }
        }
    }

    static int generatePolygonal(int type, int n) {
        switch (type) {
            case 3: return n * (n + 1) / 2;  // Triangle number
            case 4: return n * n;            // Square number
            case 5: return n * (3 * n - 1) / 2; // Pentagonal number
            case 6: return n * (2 * n - 1);   // Hexagonal number
            case 7: return n * (5 * n - 3) / 2; // Heptagonal number
            case 8: return n * (3 * n - 2);   // Octagonal number
            default: return 0;
        }
    }

    static boolean findCyclicSet(int index, int prev, boolean[] usedTypes) {
        if (index == 6) {
            return isCyclic(result[5], result[0]); // Ensure cycle is complete
        }

        for (int i = 0; i < totalNumbers; i++) {
            if (!usedTypes[types.get(i) - 3] && isCyclic(prev, numbers.get(i))) {
                result[index] = numbers.get(i);
                usedTypes[types.get(i) - 3] = true;

                if (findCyclicSet(index + 1, numbers.get(i), usedTypes)) return true;

                usedTypes[types.get(i) - 3] = false; // Backtrack
            }
        }
        return false;
    }

    static boolean isCyclic(int a, int b) {
        return a % 100 == b / 100;
    }
}