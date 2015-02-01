public class Solution {
    public int maxArea(int[] height) {
        int most = 0;
        int start = 0, end = height.length - 1;

        while (start < end) {
            int area = (end - start) * (height[start] < height[end] ? height[start] : height[end]);
            most = most > area ? most : area;
            if (height[start] < height[end])
                start ++;
            else
                end --;
        }

        return most;
    }
}
