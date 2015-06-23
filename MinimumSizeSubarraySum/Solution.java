public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        LinkedList<Integer> subList = new LinkedList<Integer>();
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        for (int i = 0; i < nums.length; i ++) {

            sum += nums[i];
            
            if (sum >= s) {
                while (sum - nums[start] >= s) {
                    sum -= nums[start ++];
                }
                
                minLen = Math.min(i - start + 1, minLen);
            }
        }
        
        return sum >= s ? minLen : 0;
    }
}