public class Solution {
    public int firstMissingPositive(int[] A) {
        partialSort(A);

        for (int i = 0; i < A.length; i ++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    void partialSort(int[] A) {
        for (int i = 0; i < A.length; i ++) {
            while (A[i] != i + 1) {
                if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1]) {
                    break;
                }
                swap(A, i, A[i] - 1);
            }
        }
    }

    void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
