public class Solution {
    public boolean canJump(int[] A) {
        int reach = 1;

        for (int i = 0; i < reach && reach < A.length; i ++)
            reach = (reach > A[i] + i + 1) ? reach : A[i] + i + 1;
            // plus 1 because reach is 1-based

        return reach >= A.length;
    }
}
