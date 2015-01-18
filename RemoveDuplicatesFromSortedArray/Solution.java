public class Solution {
  public int removeDuplicates(int[] A) {
    if (A.length <= 1) {
      return A.length;
    }

    int curValue = A[0];
    int curIndex = 1;
    int origLength = A.length;

    for (int i = 1; i < origLength; i ++) {
      if (A[i] != curValue) {
        A[curIndex] = A[i];
        curIndex ++;
        curValue = A[i];
      }
    }
    return curIndex;
  }
}
