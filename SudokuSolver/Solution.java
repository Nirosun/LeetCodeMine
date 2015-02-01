public class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        for (int i = 0; i < 9; i ++) {  // row
            for (int j = 0; j < 9; j ++) {  // col
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k ++) {  // 1~9
                        board[i][j] = k;
                        if (isValid(board, i, j) && solve(board))
                            return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < 9; i ++) {
            if (i != x && board[i][y] == board[x][y])
                return false;
        }
        for (int i = 0; i < 9; i ++) {
            if (i != y && board[x][i] == board[x][y])
                return false;
        }
        int baseX = (x / 3) * 3;
        int baseY = (y / 3) * 3;
        for (int i = baseX; i < baseX + 3; i ++) {
            for (int j = baseY; j < baseY + 3; j ++) {
                if ((i != x && j != y) && board[i][j] == board[x][y])
                    return false;
            }
        }
        return true;
    }
}
