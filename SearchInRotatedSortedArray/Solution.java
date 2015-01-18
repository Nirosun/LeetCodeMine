public class Solution {
  public int search(int[] A, int target) {
    if (A.length == 1) {
      return (A[0] == target) ? 0 : -1;
    }

    int lastElem = A[A.length - 1];
    int firstElem = A[0];
    boolean isRotated = true;

    if (firstElem < lastElem) {
      isRotated = false;
      if (target > lastElem || target < firstElem) {
        return -1;
      }
    }

    if (isRotated) {
      if (target > lastElem && target < firstElem) {
        return -1;
      }
    }

    int prevElem = A[0];

    // Search the front part
    if (A[0] == target) return 0;
    for (int i = 1; i < A.length; i ++) {
      if (A[i] < prevElem || A[i] > target) break;
      if (A[i] == target) return i;
      prevElem = A[i];
    }

    if (!isRotated) return -1;

    // Search the behind part
    if (A[A.length - 1] == target) return A.length - 1;
    prevElem = A[A.length - 1];
    for (int i = A.length - 2; i >= 0; i --) {
      if (A[i] > prevElem || A[i] < target) break;
      if (A[i] == target) return i;
      prevElem = A[i];
    }

    return -1;
  }
}
