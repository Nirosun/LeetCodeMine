public class Solution {
    public int singleNumber(int[] A) {
        int L = Integer.SIZE;
        int[] count = new int[L];
        Arrays.fill(count, 0);

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < L; j ++) {
                count[j] += (A[i] >> j) & 1;
                count[j] %= 3;
            }
        }

        int result = 0;
        for (int j = 0; j < L; j ++) {
            result += count[j] << j;
        }
        return result;
    }
}
