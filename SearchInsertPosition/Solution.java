public class Solution {

    // O(n)
    public int searchInsert(int[] A, int target) {
        for (int i = 0; i < A.length; i ++) {
            if (A[i] >= target) return i;
        }
        return A.length;
    }

    // O(log(n))
    /*public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length;

        while (start != end) {
            int mid = (start + end) / 2;
            if (A[mid] < target)    start = mid + 1;
            else    end = mid;
        }

        return start;
    }*/
}
