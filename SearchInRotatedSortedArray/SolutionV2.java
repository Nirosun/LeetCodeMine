public class Solution {
  public int search(int[] A, int target) {
    int first = 0, last = A.length, mid;

    while (first != last) {
      mid = (first + last) / 2;
      if (A[mid] == target) {
        return mid;
      }
      if (A[first] <= A[mid]) {
        if (target >= A[first] && target < A[mid]) {
          last = mid;
        }
        else {
          first = mid + 1;
        }
      }
      else {
        if (target > A[mid] && target <= A[last - 1]) {
          first = mid + 1;
        }
        else {
          last = mid;
        }
      }
    }

    return -1;
  }
}
