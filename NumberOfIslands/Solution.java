public class Solution {
    private boolean canVisit(int x, int y, int xLen, int yLen, char[][] grid, boolean[][] visited) {
        return x >= 0 && y >= 0
            && x < xLen && y < yLen
            && grid[x][y] == '1'
            && !visited[x][y];
    }
    
    private void travel(int x, int y, int xLen, int yLen, char[][] grid, boolean[][] visited) {
        visited[x][y] = true;
        int[][] next = new int[][] {{x, y + 1}, {x, y - 1}, {x + 1, y}, {x - 1, y}};
        
        for (int[] xy : next) {
            if (canVisit(xy[0], xy[1], xLen, yLen, grid, visited)) {
                travel(xy[0], xy[1], xLen, yLen, grid, visited);
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        final int xLen = grid.length;
        if (xLen == 0)  return 0;
        final int yLen = grid[0].length;
        
        int cnt = 0;
        boolean[][] visited = new boolean[xLen][yLen];
        //Arrays.fill(visited, false);
        
        for (int x = 0; x < xLen; x ++) {
            for (int y = 0; y < yLen; y ++) {
                if (canVisit(x, y, xLen, yLen, grid, visited)) {
                    cnt ++;
                    travel(x, y, xLen, yLen, grid, visited);
                }
            }
        }
        
        return cnt;
    }
    
    
}