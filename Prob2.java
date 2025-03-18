public class Prob2 {
    public static void main(String[] args) {
        long N = 10000000000L; // Given limit
        System.out.println("B(" + N + ") = " + countBiclinicQuadrilaterals(N));
    }

    public static long countBiclinicQuadrilaterals(long N) {
        long count = 0;

        for (long a = 1; a * a <= N; a++) { 
            for (long b = a; a * a + b * b <= N; b++) { 
                for (long c = b; a * a + b * b + c * c <= N; c++) { 
                    long d = (long) Math.sqrt(N - (a * a + b * b + c * c));
                    if (d >= c && (a * a + b * b + c * c + d * d) <= N) { 
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

// public class Prob2 {
//     public static void main(String[] args) {
//         long N = 1000000L; //Given limit
//         System.out.println("B(" + N + ") = " + countBiclinicQuadrilaterals(N));
//     }

//     public static long countBiclinicQuadrilaterals(long N) {
//         long count = 0;

//         for (long a = 1; a * a <= N; a++) { 
//             for (long b = a; a * a + b * b <= N; b++) { 
//                 for (long c = b; a * a + b * b + c * c <= N; c++) { 
//                     long d = (long) Math.sqrt(N - (a * a + b * b + c * c));
//                     if (d >= c && (a * a + b * b + c * c + d * d) <= N) { 
//                         count++;
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }

// public class Prob2 {
//     public static void main(String[] args) {
//         long N = 10000L; // Given limit
//         System.out.println("B(" + N + ") = " + countQuadrilaterals(N));
//     }

//     public static long countQuadrilaterals(long N) {
//         long count = 0; 

//         for (long a = 1; a * a <= N; a++) { 
//             for (long b = a; a * a + b * b <= N; b++) { 
//                 for (long c = b; a * a + b * b + c * c <= N; c++) { 
//                     for (long d = c; a * a + b * b + c * c + d * d <= N; d++) { 
//                         count++; 
//                     }
//                 }
//             }
//         }
//         return count; 
//     }
// }

// public class Prob2 {
//     public static void main(String[] args) {
//         long N = 10000; // The given constraint
//         System.out.println("B(" + N + ") = " + countBiclinicQuadrilaterals(N));
//     }

//     public static int countBiclinicQuadrilaterals(long N) {
//         int count = 0;

//         for (int AB = 1; AB * AB <= N; AB++) {
//             for (int BC = AB; BC * BC + AB * AB <= N; BC++) {
//                 for (int CD = BC; CD * CD + BC * BC + AB * AB <= N; CD++) {
//                     for (int AD = CD; AD * AD + CD * CD + BC * BC + AB * AB <= N; AD++) {
//                         int BD = (AB + CD) / 2; // BD should be an integer
//                         if ((AB + CD) % 2 == 0) {
//                             int AO = BD / 2; // Midpoint O should also be integer
//                             if (AO * 2 == BD) {
//                                 count++;
//                             }
//                         }
//                     }
//                 }

//             }
//         }
//         return count;
//     }
// }