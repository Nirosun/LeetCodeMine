public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        if (n == 0) return mat;
        int num = 1, begin = 0, end = n - 1;
        while (begin < end) {
            for (int i = begin; i < end; i ++)	mat[begin][i] = num ++;
            for (int i = begin; i < end; i ++)	mat[i][end] = num ++;
            for (int i = end; i > begin; i--)	mat[end][i] = num ++;
            for (int i = end; i > begin; i --)	mat[i][begin] = num ++;
            begin ++;
            end --;
        }
        if (begin == end)	mat[begin][begin] = num;
        return mat;
    }
}
