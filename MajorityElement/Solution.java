public class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int major = nums[0];
        
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == major) {
                cnt ++;
            }
            else if (cnt > 0) {
                cnt --;
            }
            else {
                major = nums[i];
            }
        }
        
        return major;
    }
}