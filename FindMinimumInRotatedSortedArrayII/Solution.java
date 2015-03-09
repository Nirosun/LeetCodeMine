public class Solution {
    public int findMin(int[] num) {
        if (num.length == 1)    return num[0];
        if (num.length == 2)    return Math.min(num[0], num[1]);

        int start = 0;
        int end = num.length;
        int mid = (start + end) / 2;

        if (num[start] == num[mid] && num[mid] == num[end - 1]) {
            return findMin(Arrays.copyOfRange(num, start + 1, end));
        }

        if (num[start] < num[end - 1]) {
            return num[0];
        }

        if(num[mid] <= num[end - 1]) {
            return findMin(Arrays.copyOfRange(num, start, mid + 1));
        }

        return findMin(Arrays.copyOfRange(num, mid + 1, end));
    }
}
