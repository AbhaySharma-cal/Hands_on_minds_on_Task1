 public class Prob3{
    public static void main(String[] args) {
        int m = 15;
        long s = (long) Math.pow(10, 9); 
 
        int games = 40;
        double tolerance = Math.pow(10, -20);
 
        double root = 0.5;
        double step = 0.5;
 
        double[] probabilities = new double[games];
        double[] payoffs = new double[games];
 
        for (int game = 0; game < games; game++) {
            probabilities[game] = Math.pow(2, -(game + 1));
            payoffs[game] = Math.pow(2, game) - m;
        }
 
        double difference;
        do {
            difference = 0.0;
            for (int game = 0; game < games; game++) {
                difference += probabilities[game] * Math.pow(root, payoffs[game]);
            }
            difference -= 1.0;
 
            root += Math.signum(difference) * step;
            step /= 2.0;
        } while (Math.abs(difference) > tolerance);
 
        double result = 1 - Math.pow(root, s);
        System.out.println(String.format("%.7f", result));
    }
}



// public class Prob3 {
//     public static void main(String[] args) {
//         int m = 15; // Cost per game
//         long s = 1_000_000_000L; // Initial fortune
//         System.out.printf("%.7f\n", getProbability(m, s));
//     }

//     public static double getProbability(int m, long s) {
//         if (s < m) return 0.0; // If s < m, gambler can't play, so probability is 0
//         return 1 - 0.5 * (1 - getProbability(m, 2 * s)); // Recursive formula
//     }
// }


// public class Prob3 {
//     public static double calculateProbability(int m, long s) {
//         int maxGames = 40; // Limit to avoid excessive computation
//         double tolerance = 1e-20;
//         double root = 0.5, step = 0.5;
        
//         double[] probabilities = new double[maxGames];
//         double[] payoffs = new double[maxGames];
        
//         for (int i = 0; i < maxGames; i++) {
//             probabilities[i] = Math.pow(2, -(i + 1));
//             payoffs[i] = Math.pow(2, i) - m;
//         }
        
//         double diff;
//         do {
//             diff = -1.0;
//             for (int i = 0; i < maxGames; i++) {
//                 diff += probabilities[i] * Math.pow(root, payoffs[i]);
//             }
//             root += Math.signum(diff) * step;
//             step /= 2.0;
//         } while (Math.abs(diff) > tolerance);
        
//         return 1 - Math.pow(root, s);
//     }
    
//     public static void main(String[] args) {
//         int m = 15;
//         long s = 1_000_000_000L; // 10^9
//         System.out.printf("%.7f\n", calculateProbability(m, s));
//     }
// }
