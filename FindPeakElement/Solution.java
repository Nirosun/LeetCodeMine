public class Solution {

    public int findPeakElement(int[] num) {

        int start = 0;
        int end = num.length - 1;

        while (end > start) {
            int mid = (start + end) / 2;
            // peak is on the right of mid
            if (num[mid] < num[mid + 1]) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }

        return start;
    }


    // Umm...Still linear...
    /*
    private int findPeakUtil(int[] num, int start, int end) {
        if (end - start == 1)   return start;

        int mid = (start + end) / 2;
        int l = findPeakUtil(num, start, mid);
        int r = findPeakUtil(num, mid, end);

        return (num[l] > num[r]) ? l : r;
    }

    public int findPeakElement(int[] num) {
        return findPeakUtil(num, 0, num.length);
    }
    */

    // linear solution
    /*
    public int findPeakElement(int[] num) {
        if (num.length == 1)    return 0;
        if (num.length == 2)    return num[0] > num[1] ? 0 : 1;

        if (num[0] > num[1])    return 0;

        for (int i = 1; i < num.length - 1; i ++) {
            if (num[i] > num[i - 1] && num[i] > num[i + 1]) {
                return i;
            }
        }

        return num.length - 1;

    }
    */
}
