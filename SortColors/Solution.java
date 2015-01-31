public class Solution {

    /*
    public void sortColors(int[] A) {
        int[] cnt = {0, 0, 0};

        for (int i = 0; i < A.length; i ++) {
            cnt[A[i]] ++;
        }

        for (int i = 0, index = 0; i < 3; i ++) {
            for (int j = 0; j < cnt[i]; j ++) {
                A[index ++] = i;
            }
        }
    }*/

    public void sortColors(int[] A) {   // one pass
        int red = 0; int blue = A.length - 1;

        for (int i = 0; i < blue + 1;) {
            if (A[i] == 0) {
                swap(A, i ++, red ++);
            }
            else if (A[i] == 2) {
                swap(A, i, blue --);
            }
            else {
                i ++;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
