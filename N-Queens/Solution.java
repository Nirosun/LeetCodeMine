public class Solution {
    int target;     // index of last row
    List<String[]> result;
    boolean[][] board;

    public List<String[]> solveNQueens(int n) {
        this.target = n - 1;
        this.result = new ArrayList<String[]>();
        board = new boolean[n][n];

        search(0);

        return result;
    }

    void search(int row) {
        if (row > target) { // reach the target
            String[] valid = new String[target + 1];    // one valid solution

            for (int i = 0; i <= target; i ++) {
                char[] chars = new char[target + 1];
                for (int j = 0; j <= target; j ++) {
                    if (board[i][j])
                        chars[j] = 'Q';
                    else
                        chars[j] = '.';
                }
                valid[i] = new String(chars);
            }
            result.add(valid);
            return;
        }

        for (int i = 0; i <= target; i ++) {
            if (tryPut(row, i)) {
                board[row][i] = true;

                search(row + 1);

                board[row][i] = false;  //reset the board
            }
        }
    }
    
    boolean tryPut(int row, int col) {
        for (int i = row - 1; i >= 0; i --) {
            int offset = row - i;
            if (board[i][col])
                return false;
            if (col + offset <= target && board[i][col + offset])
                return false;
            if (col - offset >= 0 && board[i][col - offset])
                return false;
        }
        return true;
    }
}
