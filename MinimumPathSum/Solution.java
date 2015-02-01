public class Solution {
    /*
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i ++)
            grid[i][0] += grid[i - 1][0];

        for (int j = 1; j < n; j ++)
            grid[0][j] += grid[0][j - 1];

        for (int i = 1; i < m; i ++)
            for (int j = 1; j < n; j ++)
                grid[i][j] += (grid[i - 1][j] < grid[i][j - 1]) ?
                    grid[i - 1][j] : grid[i][j - 1];

        return grid[m - 1][n - 1];
    }
    */

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] f = new int[n];   // rolling array
        Arrays.fill(f, Integer.MAX_VALUE);

        f[0] = 0;

        for (int i = 0; i < m; i ++) {
            f[0] += grid[i][0];
            for (int j = 1; j < n; j ++) {
                f[j] = grid[i][j] + ((f[j - 1] < f[j]) ? f[j - 1] : f[j]);
            }
        }
        return f[n - 1];
    }
}
