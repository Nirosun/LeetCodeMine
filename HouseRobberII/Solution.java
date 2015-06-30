public class Solution {
    
    public int robHelper(int[] nums, int start, int len) {
        if (len == 0)   return 0;
        if (len == 1)   return nums[start];
        
        int[] total = new int[len];
        
        total[0] = nums[start];
        total[1] = Math.max(nums[start], nums[start + 1]);
        
        for (int i = 2; i < len; i ++) {
            total[i] = Math.max(total[i - 2] + nums[start + i], total[i - 1]);
            // Rob, or don't rob
        }
        
        return total[len - 1];
    }

    public int rob(int[] nums) {
        if (nums.length == 0)   return 0;
        if (nums.length == 1)   return nums[0];

        return Math.max(robHelper(nums, 0, nums.length - 1), robHelper(nums, 1, nums.length - 1));
    }
    
}