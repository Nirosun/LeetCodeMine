public class Solution {
  public int removeDuplicates(int[] A) {
    if (A.length <= 2) {
      return A.length;
    }

    int curValue = A[0];
    int curIndex = 1;
    int origLength = A.length;
    int dupCnt = 1;

    for (int i = 1; i < A.length; i ++) {
      if (A[i] != curValue) {
        A[curIndex] = A[i];
        curIndex ++;
        curValue = A[i];
        dupCnt = 1;
      }
      else {
        dupCnt ++;
        if (dupCnt == 2) {
          A[curIndex] = A[i];
          curIndex ++;
        }
      }
    }
    return curIndex;
  }
}
