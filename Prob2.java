public class Prob2 {
    public static void main(String[] args) {
        long N = 10000000000L; 
        System.out.println("B(N) = " + countBiclinicQuadrilaterals(N));
    }

    public static long countBiclinicQuadrilaterals(long N) {
        long count = 0;

        for (long a = 1; a * a <= N; a++) 
        { 
            for (long b = a; a * a + b * b <= N; b++) 
            { 
                for (long c = b; a * a + b * b + c * c <= N; c++) 
                { 
                          long d = (long) Math.sqrt(N - (a * a + b * b + c * c));
                          if (d >= c && (a * a + b * b + c * c + d * d) <= N)
                    { 
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
