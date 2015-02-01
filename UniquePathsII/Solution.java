public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)    return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] f = new int[n];

        f[0] = 1;

        for (int i = 0; i < m; i ++) {
            if (obstacleGrid[i][0] == 1)
                f[0] = 0;
            for (int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 1)
                    f[j] = 0;
                else
                    f[j] += f[j - 1];
            }
        }
        return f[n - 1];
    }
}
