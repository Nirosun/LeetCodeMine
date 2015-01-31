public class Solution {
    public int sqrt(int x) {
        if (x < 2) return x;

        int start = 1;
        int end = x / 2;
        int lastMid = 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (x / mid > mid) {
                start = mid + 1;
                lastMid = mid;
            }
            else if (x / mid < mid) {
                end = mid - 1;
            }
            else
                return mid;
        }

        return lastMid;
    }
}
