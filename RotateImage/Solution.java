public class Solution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;

    for (int layer = 0; layer < n / 2; layer ++) {
      int first = layer;
      int last = n - 1 - layer;
      int tmp;

      for (int i = first; i < last; i ++) {
        int offset = i - first;

        // move top to tmp
        tmp = matrix[first][i];

        // move left to top
        matrix[first][i] = matrix[last-offset][first];

        // move bottom to left
        matrix[last-offset][first] = matrix[last][last-offset];

        // move right to bottom
        matrix[last][last-offset] = matrix[i][last];

        // move tmp to right
        matrix[i][last] = tmp;

      }
    }

  }


}
