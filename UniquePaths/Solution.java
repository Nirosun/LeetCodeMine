public class Solution {
    // DP and rolling array
    public int uniquePaths(int m, int n) {
        int[] f = new int[n];

        Arrays.fill(f, 1);
        //f[0] = 1;

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                f[j] += f[j - 1];
            }
        }
        return f[n - 1];
    }
}