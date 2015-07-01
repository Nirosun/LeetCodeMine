public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> appeared = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i ++) {
            if (appeared.containsKey(nums[i])) {
                if (i - appeared.get(nums[i]) > k) {
                    appeared.put(nums[i], i);
                }
                else {
                    return true;
                }
            }
            else {
                appeared.put(nums[i], i);
            }
        }
        
        return false;
    }
}