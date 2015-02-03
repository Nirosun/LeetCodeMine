public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<Integer>();
        if (matrix.length == 0) return l;
        int x1 = 0, y1 = 0, x2 = matrix.length - 1, y2 = matrix[0].length - 1;
        while (true) {
            for (int i = y1; i <= y2; i ++)	l.add(matrix[x1][i]);
            if (++ x1 > x2)	break;
            for (int i = x1; i <= x2; i ++)	l.add(matrix[i][y2]);
            if (-- y2 < y1)	break;
            for (int i = y2; i >= y1; i --)	l.add(matrix[x2][i]);
            if (-- x2 < x1)	break;
            for (int i = x2; i >= x1; i --)	l.add(matrix[i][y1]);
            if (++ y1 > y2)	break;
        }

        return l;
    }
}
