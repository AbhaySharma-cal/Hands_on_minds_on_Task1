import java.util.ArrayList;

public class Prob1 {
    static ArrayList<Integer> numbers = new ArrayList<>(); 
    static ArrayList<Integer> types = new ArrayList<>();   
    static int totalNumbers = 0;                           
    static int[] result = new int[6];                       

    public static void main(String[] args) {
        generatePolygonalNumbers();

        for (int i = 0; i < totalNumbers; i++) {
            result[0] = numbers.get(i); 
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
                if (value >= 10000){
                    break; 
                }
                if (value >= 1000) { 
                    numbers.add(value);
                    types.add(type);     
                    totalNumbers++;
                }
            }
        }
    }

    static int generatePolygonal(int type, int n) {
        switch (type) {
            case 3: return n * (n + 1) / 2;  
            case 4: return n * n;            
            case 5: return n * (3 * n - 1) / 2; 
            case 6: return n * (2 * n - 1);   
            case 7: return n * (5 * n - 3) / 2; 
            case 8: return n * (3 * n - 2);  
            default: return 0;
        }
    }

    static boolean findCyclicSet(int index, int prev, boolean[] usedTypes) {
        if (index == 6) {
            return isCyclic(result[5], result[0]); 
        }

        for (int i = 0; i < totalNumbers; i++) {
            if (!usedTypes[types.get(i) - 3] && isCyclic(prev, numbers.get(i))) {
                result[index] = numbers.get(i);
                usedTypes[types.get(i) - 3] = true;

                if (findCyclicSet(index + 1, numbers.get(i), usedTypes)) return true;

                usedTypes[types.get(i) - 3] = false;
            }
        }
        return false;
    }

    static boolean isCyclic(int a, int b) {
        return a % 100 == b / 100;
    }
}
