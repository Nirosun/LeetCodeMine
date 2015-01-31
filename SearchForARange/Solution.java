public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = 0;
        int end = A.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                int s = mid, e = mid;
                while (s >= 0 && A[s] == target) s --;
                while (e < A.length && A[e] == target) e ++;

                return new int[] {++ s, -- e};
            }
            else if (A[mid] > target)   end = mid;
            else    start = mid + 1;
        }

        return new int[] {-1, -1};
    }

    /*
    private int binarySearch(int[] A, int target, int start, int end) {
        if (start >= end) return -1;

        int mid = (start + end) / 2;

        if (A[mid] == target)
            return mid;
        else if (A[mid] < target)
            return binarySearch(A, target, mid + 1, end);
        else
            return binarySearch(A, target, start, mid);
    }*/

    /*private int lowerBound(int[] A, int target) {
        int start = 0;
        int last = A.length;

        while (first != last) {
            int mid = (start + end) / 2;
            if (A[mid] == target)   return mid;
            else if (A[mid] < target)   start = mid + 1;
            else    end = mid;
        }

        return -1;
    }*/
}
