public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int start = 0;
        int end = matrix.length * matrix[0].length;

        while (start != end) {
            int mid = (start + end) / 2;
            int i = mid / n, j = mid % n;
            if (matrix[i][j] == target)  return true;
            else if (matrix[i][j] < target) start = mid + 1;
            else    end = mid;
        }

        return false;

    }
}
