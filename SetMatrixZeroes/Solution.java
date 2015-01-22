public class Solution {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    boolean flagRow = false, flagCol = false;

    for (int i = 0; i < m; i ++) {
      if (matrix[i][0] == 0) {
        flagCol = true;
        break;
      }
    }
    for (int i = 0; i < n; i ++) {
      if (matrix[0][i] == 0) {
        flagRow = true;
        break;
      }
    }

    for (int i = 1; i < m; i ++) {
      for (int j = 1; j < n; j ++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    for (int i = 1; i < m; i ++) {
      if (matrix[i][0] == 0) {
        clearRow(matrix, i);
      }
    }

    for (int i = 1; i < n; i ++) {
      if (matrix[0][i] == 0) {
        clearColumn(matrix, i);
      }
    }

    if (flagRow)
      clearRow(matrix, 0);
    if (flagCol)
      clearColumn(matrix, 0);
  }

  private void clearRow(int[][] mat, int rowID) {
    for (int i = 0; i < mat[0].length; i ++) {
      mat[rowID][i] = 0;
    }
  }

  private void clearColumn(int[][] mat, int colID) {
    for (int i = 0; i < mat.length; i ++) {
      mat[i][colID] = 0;
    }
  }
}
