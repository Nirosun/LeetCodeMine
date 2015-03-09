public class Solution {
    public int trap(int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = 0;
        maxRight[n - 1] = 0;

        for (int i = 1; i < n; i ++) {
            maxLeft[i] = (maxLeft[i - 1] > A[i - 1]) ? maxLeft[i - 1] : A[i - 1];
            maxRight[n - 1 - i] = (maxRight[n - i] > A[n - i]) ? maxRight[n - i] : A[n - i];
        }

        int sum = 0;

        for (int i = 0; i < n; i ++)	{
            int height = (maxLeft[i] < maxRight[i]) ? maxLeft[i] : maxRight[i];
            if (height > A[i]) {
                sum += height - A[i];
            }
        }

        return sum;
    }
}
