public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] chars = word.toCharArray();

        for (int i = 0; i < m; i ++)
            Arrays.fill(visited[i], false);

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (search(board, chars, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }

    boolean search(char[][] board, char[] word, int index, int x, int y, boolean[][] visited) {
        if (index == word.length)   return true;    // convergence condition
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)    // pruning
            return false;
        if (visited[x][y])  return false;
        if (board[x][y] != word[index]) return false;

        visited[x][y] = true;
        boolean isFound = search(board, word, index + 1, x - 1, y, visited) ||
                        search(board, word, index + 1, x + 1, y, visited) ||
                        search(board, word, index + 1, x, y - 1, visited) ||
                        search(board, word, index + 1, x, y + 1, visited);
        visited[x][y] = false;
        return isFound;
    }
}
