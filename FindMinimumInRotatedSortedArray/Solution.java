public class Solution {
    public int findMin(int[] num) {
        if (num.length == 1)    return num[0];
        if (num.length == 2)    return Math.min(num[0], num[1]);

        int start = 0;
        int end = num.length;
        int mid = (start + end) / 2;

        if (num[start] < num[end - 1])  return num[start];

        // min at right half
        if (num[mid] > num[end - 1])
            return findMin(Arrays.copyOfRange(num, mid, end));
        
        // min at left half
        return findMin(Arrays.copyOfRange(num, start, mid + 1));

    }
}
