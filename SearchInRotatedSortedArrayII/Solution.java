public class Solution {
  public boolean search(int[] A, int target) {
    int first = 0, last = A.length, mid;

    while (first != last) {
      mid = (first + last) / 2;

      // Find the target
      if (A[mid] == target) {
        return true;
      }

      // The rotate point is on the right
      if (A[first] < A[mid]) {
        if (target >= A[first] && target < A[mid]) {
          last = mid;
        }
        else {
          first = mid + 1;
        }
      }

      // The rotate point is on the left
      else if (A[first] > A[mid]) {
        if (target > A[mid] && target <= A[last - 1]) {
          first = mid + 1;
        }
        else {
          last = mid;
        }
      }

      // Skip the duplicate
      else {
        first ++;
      }
    }

    return false;
  }
}
