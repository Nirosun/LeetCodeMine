public class Solution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n - 1; i ++) {
      for (int j = 0; j < n - i; j ++) {
        swap(matrix, i, j, n - 1 - j, n - 1 - i);
      }
    }

    for (int i = 0; i < n / 2; i ++) {
      for (int j = 0; j < n; j ++) {
        swap(matrix, i, j, n - 1 - i, j);
      }
    }

  }

  private void swap(int[][] mat, int i1, int j1, int i2, int j2) {
    int tmp;
    tmp = mat[i1][j1];
    mat[i1][j1] = mat[i2][j2];
    mat[i2][j2] = tmp;
  }


}
