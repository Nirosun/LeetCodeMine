/**
 * O(n) solution
 */
// public class Solution {
//     public int trailingZeroes(int n) {
//         int c2 = 0;
//         int c5 = 0;
//         int c0 = 0;
        
//         for (int i = 0; i < n; i ++) {
//             int m = n;
//             while (m % 2 == 0) {
//                 c2 ++;
//                 m /= 2;
//             }
//             while (m % 5 == 0) {
//                 c5 ++;
//                 m /= 5;
//             }
//             c0 += Math.min(c2, c5);
//             c2 -= c0;
//             c5 -= c0;
//         }
        
//         return c0;
//     }
// }

/**
 * O(log n) solution
 */
public class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        return n / 5 + trailingZeroes(n / 5);   // First calculate how many 5's are contained (by "n / 5")
                                                // Then calculate how many 25's, 125's, ... (by recursion)
    }
}


