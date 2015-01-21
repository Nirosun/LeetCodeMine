public class Solution {
  public boolean isValidSudoku(char[][] board) {
    boolean[] used = new boolean[9];

    // by row
    for (int i = 0; i < 9; i ++) {
      fill(used, false);
      for (int j = 0; j < 9; j ++) {
        if (!check(board[i][j], used)) {
          return false;
        }
      }
    }

    // by column
    for (int i = 0; i < 9; i ++) {
      fill(used, false);
      for (int j = 0; j < 9; j ++) {
        if (!check(board[j][i], used)) {
          return false;
        }
      }
    }

    // by lattice
    for (int i = 0; i < 3; i ++) {
      for (int j = 0; j < 3; j ++) {
        fill(used, false);
        for (int i1 = i * 3; i1 < i * 3 + 3; i1 ++) {
          for (int j1 = j * 3; j1 < j * 3 + 3; j1 ++) {
            if (!check(board[i1][j1], used)) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  private boolean check(char ch, boolean[] used) {
    if (ch == '.') return true;
    if (used[ch - '1']) return false;

    return (used[ch - '1'] = true);
  }

  private void fill(boolean[] arr, boolean val) {
    for (int i = 0; i < arr.length; i ++) {
      arr[i] = val;
    }
  }
}
