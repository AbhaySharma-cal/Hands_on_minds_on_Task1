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
