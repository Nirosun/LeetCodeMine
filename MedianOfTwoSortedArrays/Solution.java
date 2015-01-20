public class Solution {
  public double findMedianSortedArrays(int A[], int B[]) {
    int m = A.length;
    int n = B.length;
    int total = m + n;

    if (total / 2.0 != total / 2) {
      return (double)find_kth(A, 0, B, 0, total / 2 + 1);
    }
    else {
      return (find_kth(A, 0, B, 0, total / 2) + find_kth(A, 0, B, 0, total / 2 + 1)) / 2.0;
    }

  }

  // use startA and startB to mark part of the arrays
  private int find_kth(int A[], int startA, int B[], int startB, int k) {
    int m = A.length - startA;
    int n = B.length - startB; 

    if (m > n) {
      return find_kth(B, startB, A, startA, k);
    }
    if (m == 0) {
      return B[startB + k - 1];
    }
    if (k == 1) {
      return ((A[startA] < B[startB]) ? A[startA] : B[startB]);
    }

    // divide k into two parts
    int ia = (k/2 < m) ? k/2 : m;
    int ib = k - ia;

    if (A[startA + ia - 1] < B[startB + ib - 1]) {
      return find_kth(A, startA + ia, B, startB, k - ia);
    }
    else if (A[startA + ia - 1] > B[startB + ib - 1]) {
      return find_kth(A, startA, B, startB + ib, k - ib);
    }
    else {
      return A[startA + ia - 1];
    }

  }
}
